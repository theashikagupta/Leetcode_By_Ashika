class Solution {
    public String removeDuplicates(String s) {
        Stack<Character> st=new Stack<>();
        
        for(int i=0;i<s.length();i++){
            char c=s.charAt(i);
            if(st.isEmpty() || st.peek()!=c){
                st.push(c);
            }
            else{
                st.pop();
            }
        }
        StringBuilder res = new StringBuilder();
            for (char c : st) {
                res.append(c);
            }
        
        
        
        return res.toString();        
    }
}