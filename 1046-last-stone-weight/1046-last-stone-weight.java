class Solution {
    public int lastStoneWeight(int[] stones) {
        //Approach-1 (Sorting)
        List<Integer> list=new ArrayList<>();
        for(int stone:stones){
            list.add(stone);
        }
        while(list.size()>1){
            Collections.sort(list);
            int y=list.get(list.size()-1);
            list.remove(list.size()-1);
            int x=list.get(list.size()-1);
            list.remove(list.size()-1);
            list.add(Math.abs(y-x));
        }
        return list.isEmpty()?0:list.get(0);
    }
}