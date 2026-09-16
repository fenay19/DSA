class Solution {
    public int lengthOfLongestSubstring(String s) {
        int i=0;
        int ans=0;
        HashMap<Character,Integer> map=new HashMap<>();
        for(int j=0;j<s.length();j++){
            char ch=s.charAt(j);
         map.put(ch,map.getOrDefault(ch,0)+1);
       while(map.get(ch)>1){
        char l=s.charAt(i);
        map.put(l,map.get(l)-1);
        i++;
       }
ans=Math.max(ans,j-i+1);
        }
        return ans;
    }
}