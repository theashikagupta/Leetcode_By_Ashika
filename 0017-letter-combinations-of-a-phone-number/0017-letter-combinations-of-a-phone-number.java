class Solution {
    String[] map={"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
    public List<String> letterCombinations(String digits) {
        List<String> ans=new ArrayList<>();
        helper(digits,0,"",ans);
        return ans;
    }
    public void helper(String digits,int i,String curr,List<String> ans){
        if(i==digits.length()){   //basecase
            ans.add(curr);
            return;
        }
        for(char c:map[digits.charAt(i)-'0'].toCharArray()){
            helper(digits,i+1,curr+c,ans);
        }
    }
}