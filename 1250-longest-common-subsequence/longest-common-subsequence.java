class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int n=text1.length();
        int m=text2.length();
        int [][] dp=new int[n+1][m+1];
  for(int i = 0; i < n; i++){
            Arrays.fill(dp[i], -1);
        }
        return lcs(text1,text2,n,m,0,0,dp);
    }
    int lcs(String s1,String s2,int n,int m,int i,int j,int[][]dp){

if(i==n || j==m) return 0;

if(dp[i][j]!=-1) return dp[i][j];

if(s1.charAt(i)==s2.charAt(j)){
    return dp[i][j]= 1+lcs(s1,s2,n,m,i+1,j+1,dp);
}
int c1=lcs(s1,s2,n,m,i+1,j,dp);
int c2=lcs(s1,s2,n,m,i,j+1,dp);

return dp[i][j]=Math.max(c1,c2);


    }
}