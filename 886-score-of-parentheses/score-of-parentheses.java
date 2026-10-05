class Solution {
    public int scoreOfParentheses(String s) {
        int ans=0;
        int cnt=0;
        for(int j=0;j<s.length();j++){
            if(s.charAt(j)=='('){
                cnt++;
               
            }
            else{
                cnt--;

                if(s.charAt(j-1)=='('){
                    ans+=1<<cnt;
                }
            }
         
        }
        return ans;
    }
}