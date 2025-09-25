class Solution {
    public String removeOuterParentheses(String s) {
        int n=s.length();
        int count=0;
        StringBuilder res = new StringBuilder();
        for(char c:s.toCharArray()){
            if(c=='('){
                if(count>0){
                   res.append(c);
                }
                count++;
            }else{
                count--;
                if(count>0){
                    res.append(c);
                }
            }
            
            
        }
        return res.toString();
    }
}