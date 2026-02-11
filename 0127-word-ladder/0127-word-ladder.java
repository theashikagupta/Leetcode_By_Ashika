class Solution {
    static class Pair{
        String str;
        int step;
        public Pair(String str, int step){
            this.str=str;
            this.step=step;
        }
    }
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {

        HashSet<String> hs=new HashSet<>();

        for(String word: wordList){
            hs.add(word);
        }

        //edge case
        if(!hs.contains(endWord)){
            return 0;
        }

        // hs.remove(beginWord);

        Queue<Pair> q=new LinkedList<>();
        q.offer(new Pair(beginWord,1));
        while(!q.isEmpty()){
            Pair curr=q.poll();
            String word=curr.str;
            int step=curr.step;
            if(word.equals(endWord))  return step;
            
            int len=word.length();
            for(int i=0;i<len;i++){
                char[] arr=word.toCharArray();
                for(char ch='a' ; ch<='z' ;ch++){
                    if(arr[i]==ch) continue;
                    arr[i]=ch;
                    String replaceWord=new String(arr);
                    if(hs.contains(replaceWord))   q.offer(new Pair(replaceWord,step+1));
                    hs.remove(replaceWord);
                }
            }
        }
        return 0;
    }
}