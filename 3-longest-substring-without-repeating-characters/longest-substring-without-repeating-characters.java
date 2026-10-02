class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character,Integer>map=new HashMap<>();
        int j=0;
        int ans=0;
        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);
 
    map.put(ch,map.getOrDefault(ch,0)+1);


while(map.get(ch)>1){

    char cf=s.charAt(j);
    map.put(cf,map.get(cf)-1);

    j++;

}
ans=Math.max(ans,i-j+1);
        }
        return ans;
    }
}