// Time Complexity: O(n log n)
// Space Complexity: O(n)

class Solution {
    //Create hashmap 
        HashMap<Integer , Integer> freq=new HashMap<>();
    //create set 
        List<Integer> list;
        private long dp[];

    public long maximumTotalDamage(int[] power) {
        
        for(int p:power){
            freq.put(p,freq.getOrDefault(p,0)+1);
        }
        
        //create set 
        list=new ArrayList<>(freq.keySet());
        //sort list in asc order
        Collections.sort(list);
        dp=new long[list.size()];
        Arrays.fill(dp, -1);
        return helper(0);
        
    }
    //create helper function 
    private long helper(int i){
        if(i>=list.size()){
            return 0;
        }
        if(dp[i]!=-1){
            return dp[i];
        }
        //pick
        long pick=(long) list.get(i)*freq.get(list.get(i));
        int index=getIndex(list.get(i)+2);
        pick+=helper(index);
        //skip
        long skip=helper(i+1);
        //return res=max(skip,pick)

        return dp[i] = Math.max(skip, pick);
    }
   
    //create get index function , use binary search to find index 
    private int getIndex(int target){
        int l=0 , r=list.size();

        while(l<r){
            int mid=(l+r)/2;
            if(list.get(mid)<=target){
                l=mid+1;
            }else{
                r=mid;
            }
        }
    return l;
    }
    
}

