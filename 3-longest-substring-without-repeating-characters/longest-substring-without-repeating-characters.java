import java.util.*;

class Solution {
    public int lengthOfLongestSubstring(String s) {
    Map<Character,Integer> mp =  new HashMap <> ();
    int ans=0;
    int fp=0;
    for(int sp=0;sp<s.length();sp++){
        char ch= s.charAt(sp);

    if(mp.containsKey(ch) && mp.get(ch) >= fp){
        fp=mp.get(ch)+1;
    }
    mp.put(ch,sp);
    ans=Math.max(ans,sp-fp+1);
    }
 return ans;
    }
   
}
