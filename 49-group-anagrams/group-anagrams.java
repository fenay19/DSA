class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> res=new ArrayList<>();
    HashMap<String,List<String>>map=new HashMap<>();
for(String s:strs){
     char[] ca = s.toCharArray();
     Arrays.sort(ca);
     String key= new String(ca);

     map.computeIfAbsent(key,k->new ArrayList<>()).add(s);

}
     return new ArrayList<>(map.values())   ;
    }
}