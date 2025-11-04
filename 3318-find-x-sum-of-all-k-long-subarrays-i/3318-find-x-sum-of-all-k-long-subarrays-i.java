class Solution {
    public int[] findXSum(int[] nums, int k, int x) {
        int n=nums.length;
        int[] ans=new int[n-k+1];
        // Step 1️⃣ frequency map for current window
        HashMap<Integer,Integer> freq=new HashMap<>();
         // Step 2️⃣ initialize first window 
        for(int i=0; i<k; i++){
            int num=nums[i];
            freq.put(num,freq.getOrDefault(num,0)+1);
        }
        ans[0]=(int)getSum(freq,x);    // calculate x-sum for first window  
         // Step 3️⃣ slide the window
       
        for(int i=k; i<n; i++){
             int out=nums[i-k];  // outgoing element
             int in=nums[i];    // new incoming element
            freq.put(out,freq.get(out)-1);   // decrease frequency of outgoing
            freq.put(in,freq.getOrDefault(in,0)+1) ;   // add incoming element
            if(freq.get(out)==0){
                freq.remove(out);         
            }  
            ans[i-k+1] =(int)getSum(freq,x);             // recalculate x-sum for new window      
                             
        }

        return ans;
    }

    private long getSum(Map<Integer, Integer> freq, int x) {
        // Step 4️⃣ min-heap to keep top x frequent (by freq, then by value)
       PriorityQueue<int[]> pq=new PriorityQueue<>((a,b)->{  // [value,freq]
         if(a[1]==b[1]) return a[0]-b[0];
         return a[1]-b[1];
       });

       for(Map.Entry<Integer,Integer> e:freq.entrySet()){
          pq.offer(new int[] {e.getKey() , e.getValue()});
          if(pq.size()>x){
            pq.poll();
          }
       }
       long sum=0;
       while(!pq.isEmpty()){
        int[] curr=pq.poll();
        sum+=curr[0]*curr[1];
       }

        return sum;
    }
}
