class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        if( strs==null||strs.length==0 ){
            return new ArrayList<>();
        }
        HashMap<String, List<String>> AnagramGroup=new HashMap<>();
        for(String str:strs){
            char[] a=str.toCharArray();
            Arrays.sort(a);
            String sortedStr=new String(a);
            
            if(!AnagramGroup.containsKey(sortedStr)){
                AnagramGroup.put(sortedStr,new ArrayList<>());
            }
            AnagramGroup.get(sortedStr).add(str);

            
        }
        return new ArrayList<>(AnagramGroup.values());
    }
}