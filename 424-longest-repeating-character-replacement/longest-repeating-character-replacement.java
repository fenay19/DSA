class Solution {
    public int characterReplacement(String s, int k) {
        int l=0;
        int ans=0;
        int maxfreq=0;
        int [] freq=new int[26];
        for(int r=0;r<s.length();r++){
            int inx=s.charAt(r)-'A';
            freq[inx]++;
             maxfreq=Math.max(maxfreq,freq[inx]);
            while((r-l+1)-maxfreq>k){
                freq[s.charAt(l)-'A']--;
                l++;
            }
            ans=Math.max(ans,r-l+1);
        }
        return ans;
    }
}