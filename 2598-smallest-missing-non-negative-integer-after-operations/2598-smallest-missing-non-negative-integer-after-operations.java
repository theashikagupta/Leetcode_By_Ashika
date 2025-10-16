class Solution {
    public int findSmallestInteger(int[] nums, int value) {
        //find modulo of num and store it with its frequency in the map
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int num:nums){
            num=((num%value)+value)%value;
            map.put(num,map.getOrDefault(num,0)+1);
        }
        //check MEX % value is present in the map or not if present map[freq]-- and mex++ otherwise ans=MEX
        int MEX=0;
        while(true){
            if(map.getOrDefault(MEX%value,0)>0){
                map.put(MEX%value, map.get(MEX%value) - 1);
                MEX++;
            }else{
                return MEX;
            }
        }
    }
}