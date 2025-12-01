class Solution {
    public List<String> letterCasePermutation(String s) {
        List<String> result = new ArrayList<>();

        helper(0,result,s,"");

        return result;

    }

    public void helper(int i, List<String> result, String s, String curr){
        if(i==s.length()){
            result.add(curr);
            return;
        }

        helper(i+1,result,s,curr+s.charAt(i));

        char ch=s.charAt(i);

        if(Character.isLetter(ch)){
            if(Character.isLowerCase(ch)){
                helper(i+1,result,s,curr+ Character.toUpperCase(ch));
            }
            else{
                helper(i+1,result,s,curr+Character.toLowerCase(ch));
            }
        }
    }
}