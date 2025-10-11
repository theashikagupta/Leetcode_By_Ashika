// class Solution {
//     //Create hashmap 
//         HashMap<Integer , Integer> freq=new HashMap<>();
//     //create set 
//         List<Integer> list;

//     public long maximumTotalDamage(int[] power) {
        
//         for(int p:power){
//             freq.put(p,freq.getOrDefault(p,0)+1);
//         }
//         //sort array in asc order
//         Collections.sort(list);
//         //create set 
//         list=new ArrayList<>(freq.keySet());
        
//         return helper(0);
        
//     }
//     //create helper function 
//     private long helper(int i){
//         if(i>=list.size()){
//             return 0;
//         }
//         //pick
//         long pick=(long) list.get(i)*freq.get(list.get(i));
//         i=getIndex(list.get(i)+2);
//         pick+=helper(i);
//         //skip
//         long skip=helper(i+1);
//         //return res=max(skip,pick)
//         long result=Math.max(skip,pick);
//     return result;
//     }
   
//     //create get index function , use binary search to find index 
//     private int getIndex(int target){
//         int l=0 , r=list.size();

//         while(l<r){
//             int mid=(l+r)/2;
//             if(list.get(mid)<=target){
//                 l=mid+1;
//             }else{
//                 r=mid;
//             }
//         }
//     return l;
//     }
    
// }

import java.util.*;

class Solution {
    private long[] memo;
    private List<Integer> uniq;
    private Map<Integer, Integer> cnt;
    private int[] nxt;  // next non-conflicting index

    public long maximumTotalDamage(int[] power) {
        cnt = new HashMap<>();
        for (int x : power) {
            cnt.put(x, cnt.getOrDefault(x, 0) + 1);
        }
        // Unique sorted damage values
        uniq = new ArrayList<>(cnt.keySet());
        Collections.sort(uniq);

        int m = uniq.size();
        memo = new long[m];
        Arrays.fill(memo, -1);
        nxt = new int[m];

        // Precompute nxt[i]
        for (int i = 0; i < m; i++) {
            int x = uniq.get(i);
            // we want first j > i with uniq[j] > x + 2
            int target = x + 3;  // strictly greater than x + 2
            int j = Collections.binarySearch(uniq, target);
            if (j < 0) {
                j = -j - 1;
            } else {
                // binarySearch finds exact match; we want first position >= target
                while (j < m && uniq.get(j) < target) {
                    j++;
                }
            }
            nxt[i] = j;
        }

        return dfs(0);
    }

    private long dfs(int i) {
        if (i >= uniq.size()) return 0;
        if (memo[i] != -1) return memo[i];

        // skip
        long skip = dfs(i + 1);

        // pick
        int x = uniq.get(i);
        long gain = (long) x * cnt.get(x);
        long pick = gain + dfs(nxt[i]);

        memo[i] = Math.max(skip, pick);
        return memo[i];
    }
}
