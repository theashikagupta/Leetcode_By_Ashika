class Solution {
    class Pair {
        char ch;
        int freq;
        public Pair(char ch, int freq) {
            this.ch = ch;
            this.freq = freq;
        }
    }

    public String removeDuplicates(String s, int k) {
        Stack<Pair> st=new Stack<>();
        for(char ch:s.toCharArray()){
            if(!st.isEmpty() && st.peek().ch==ch){
                st.peek().freq++;
                if(st.peek().freq==k){
                    st.pop();
                }
            }else{
                st.push(new Pair(ch,1));
            }
        }
        StringBuilder sb=new StringBuilder();
        int size=st.size();
        for(int i=0;i<size;i++ ){
            sb.append(st.pop().ch);
        }
        return sb.reverse().toString();
    }
}
    