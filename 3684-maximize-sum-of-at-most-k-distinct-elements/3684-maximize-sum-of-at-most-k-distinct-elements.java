class Solution {
    public int[] maxKDistinct(int[] nums, int k) {
        Arrays.sort(nums);
        
        int[] copy= nums; 
        Set<Integer> set=new HashSet<>();
        for(int num:copy){
            set.add(num);
        }
        ArrayList<Integer> list=new ArrayList<>(set);
        list.sort(Collections.reverseOrder());
        int size=Math.min(k,list.size());
        int[] res=new int[size];
        for(int i=0;i<size;i++){
            res[i]=list.get(i);
        }
        return res;
    }
}