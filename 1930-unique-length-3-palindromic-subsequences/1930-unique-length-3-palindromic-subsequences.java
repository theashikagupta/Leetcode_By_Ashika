class Solution {
    public int countPalindromicSubsequence(String s) {
        int n=s.length();
        int[] left=new int[26];    //store index of leftmost index of ch
        int[] right=new int[26];   //store index of leftmost index of ch
        for(int i=0;i<26;i++){ 
            left[i]=-1;           //initialise with -1
            right[i]=-1;
        }
        for(int i=0;i<n;i++){        
            int c=s.charAt(i)-'a';          //find the index (c)
            if(left[c]==-1) left[c]=i;
            right[c]=i;
        }
        int res=0;
        for(int i=0;i<26;i++){
            if(left[i]==-1) continue;

            Set<Character> set=new HashSet<>();
            for(int mid=left[i]+1; mid<=right[i]-1; mid++){
                set.add(s.charAt(mid));
            }
            res+=set.size();
        }
        return res;
    }
}