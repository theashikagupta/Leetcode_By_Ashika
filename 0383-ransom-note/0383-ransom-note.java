class Solution {
    public boolean canConstruct(String r, String m) {
        // if(r.length()>m.length()) return false;
   
        Map<Character, Integer> map = new HashMap<>();
        for(int i=0; i<m.length(); i++){
            char ch=m.charAt(i);
            map.put(ch,map.getOrDefault(ch,0)+1);
        }
        for(int i=0; i<r.length(); i++){
            char ch=r.charAt(i);
            if(!map.containsKey(ch) || map.get(ch)==0){
               return false;
            }
            map.put(ch,map.get(ch)-1);
        }
        return true;
    }
}