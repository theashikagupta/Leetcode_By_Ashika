class Solution {
    public int maxEnvelopes(int[][] envelopes) {
       int n=envelopes.length;
        Arrays.sort(envelopes, (a, b) -> {
            if (a[0] == b[0]) {
                return b[1] - a[1];
            }
            return a[0] - b[0];
        });
        ArrayList<Integer> tails=new ArrayList<>();
        for(int[] envelop:envelopes) {
            int x=envelop[1];
            int idx=lowerBound(tails,x);

            if(tails.size()==idx){
                tails.add(x);
            }else{
                tails.set(idx,x);
            }
        }
        return tails.size();
    }
    public int lowerBound(ArrayList<Integer> arr, int target){
        int low=0; int high=arr.size();
        while(low<high){
            int mid=(low+high)/2;
            if(arr.get(mid)>=target) 
                high=mid;
            else 
                low=mid+1;
        }  
        return low;
    }
}
