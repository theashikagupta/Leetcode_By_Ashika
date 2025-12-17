class Solution {
    public int longestStrChain(String[] words) {
        int[] t=new int[1000];
        Arrays.sort(words, (a, b) -> a.length() - b.length());
        Arrays.fill(t,1);
        return solve(words,t);
    }
    public int solve(String[] words, int[]t){
        int n=words.length;
        
        int maxL=1;
       
        for(int i=1;i<n;i++){
            for(int j=0;j<i;j++){
                if(isPredecessor(words[j],words[i])){
                    t[i]=Math.max(t[i],t[j]+1);
                    
                }
            }
            maxL=Math.max(maxL,t[i]);
        }
        return maxL;
    }
    public static boolean isPredecessor(String word1, String word2){
        if(word1.length()>=word2.length()||word2.length()-word1.length()!=1){
            return false;
        }

        int i=0 ,j=0;
        while(i<word1.length() && j<word2.length()){
           if(word1.charAt(i)==word2.charAt(j)){
            i++;
           }
           j++;
        }
        return i==word1.length();
        
    }
    
}
