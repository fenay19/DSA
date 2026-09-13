class Solution {
    public int findTheLongestSubstring(String s) {
        HashMap<String, Integer> map = new HashMap<>();
        int ans=0;
        map.put("00000", -1);
        int acnt = 0;
        int ecnt = 0;
        int icnt = 0;
        int ocnt = 0;
        int ucnt = 0;
        for (int i=0;i<s.length();i++) {
            char ch=s.charAt(i);
            if (ch == 'a') {
                acnt^=1;
            } else if (ch == 'e') {
                ecnt^=1;
            } else if (ch == 'i') {
                icnt^=1;
            } else if (ch == 'o') {
                ocnt^=1;
            } else if (ch == 'u') {
                ucnt^=1;

            }
            String state=""+acnt+icnt+ecnt+ocnt+ucnt;

            if(map.containsKey(state)){
                int len=i-map.get(state);
                ans=Math.max(ans,len);
            }
            else{
                map.put(state,i);
            }
        }
        return ans;
    }
}