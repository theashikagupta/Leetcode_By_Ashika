class Solution {
    public int[] recoverOrder(int[] order, int[] friends) {
        // Method-1   TC:O(n^2) SC:O(n);
        // int[] arr=new int[friends.length];
        // int k=0;
        // for(int i=0;i<order.length;i++){
        //     for(int j=0;j<friends.length;j++){
        //         if(order[i]==friends[j]){
        //             arr[k++]=order[i];
        //         }
        //     }
        // }
        // return arr;

        // Method-2  TC:O(n)  SC:O(n^3)
        HashSet<Integer> friendSet=new HashSet<>(friends.length);  
        for(int f:friends){
            friendSet.add(f);
        }
        List<Integer> result=new ArrayList<>();
        for(int o:order){
            if(friendSet.contains(o)){
                result.add(o);
            }
            
        }
        int[] ans=new int[friends.length];
        for(int i=0;i<friends.length;i++){
            ans[i]=result.get(i);
        }
    return ans;
    }
}