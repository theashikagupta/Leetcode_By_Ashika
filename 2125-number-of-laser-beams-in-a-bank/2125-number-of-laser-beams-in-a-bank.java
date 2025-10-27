class Solution {
    public int numberOfBeams(String[] bank) {
        // int prev=0;
        // int res=0;
        // for(String s:bank){
        //     int current=0;
        //     for(char c:s.toCharArray()){
        //         if(c=='1'){
        //             current+=1;
        //         }
        //     }
        //     if(current>0){
        //         res+=prev*current;
        //         prev=current;
        //     }
        // }
        // return res;

        
        int prevRowCount = 0;
        int total=0;

        for(String row : bank) {
            int curRowCount = calc(row);
            if(curRowCount==0) 
                continue;

            total += curRowCount * prevRowCount;
            prevRowCount = curRowCount;
        }
        return total;
    }

    private int calc(String s) {
        int count = 0;
        for(char c : s.toCharArray()) 
            count += c - '0';

        return count;
    }    
}
  