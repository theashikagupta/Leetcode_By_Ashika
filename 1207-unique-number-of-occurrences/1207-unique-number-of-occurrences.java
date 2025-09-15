class Solution {
    public boolean uniqueOccurrences(int[] arr) {
        HashMap<Integer,Integer> hm=new HashMap<>();
        for(int n:arr){
            hm.put(n,hm.getOrDefault(n,0)+1);
        }
        Set<Integer> set = new HashSet<>(hm.values());
        return hm.size()==set.size();
    }
}