class Solution {
    public boolean checkInclusion(String s1, String s2) {
     if(s1.length()>s2.length())    return false;

     HashMap<Character,Integer> map=new HashMap<>();
     HashMap<Character,Integer> map2=new HashMap<>();

     for(char ch:s1.toCharArray()){
        map.put(ch,map.getOrDefault(ch,0)+1);
     }
     int i=0;
     int j=0;
     while(j<s2.length()){
        char c=s2.charAt(j);
        map2.put(c,map2.getOrDefault(c,0)+1);
        if((j-i+1)==s1.length()){
          if(map.equals(map2)){
            return true;
          }
          char ch=s2.charAt(i);
          map2.put(ch,map2.get(ch)-1);
          if(map2.get(ch)==0){
            map2.remove(ch);
          }
          i++;
        }
        j++;
     }
     return false;
    }
}