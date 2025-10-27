class Solution {
    public int numberOfBeams(String[] bank) {
        int prev=0;
        int current=0;
        int res=0;
        for(String s:bank){
            for(char c:s.toCharArray()){
                if(c=='1'){
                    current+=1;
                }
            }
            if(current>0){
                res+=prev*current;
                prev=current;
            }
        }
        return res;
    }
}