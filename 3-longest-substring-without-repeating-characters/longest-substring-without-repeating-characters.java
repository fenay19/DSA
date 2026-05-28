class Solution {
    public int lengthOfLongestSubstring(String s) {
        int l=0;
        int max=0;
        int n=s.length();
        HashMap<Character,Integer>map=new HashMap<>();
        for(int h=0;h<n;h++){
            char x=s.charAt(h);
      map.put(x,map.getOrDefault(x,0)+1);

      while(map.get(x)>1){
       char left=s.charAt(l);

            map.put(left,map.get(left)-1);
 if(map.get(left)==0){
    map.remove(left);
 }
            l++;

        }
if(map.get(x)==1){
        int res=h-l+1;
        max=Math.max(res,max);
      }
      }
      return max;
        
    }
}