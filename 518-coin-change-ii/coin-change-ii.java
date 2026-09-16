class Solution {
    public int change(int amount, int[] coins) {
        int [][] dp=new int [coins.length][amount+1];

        for(int i=0;i<coins.length;i++){
            Arrays.fill(dp[i],-1);
        }
return algo(0,amount,coins,dp);
    }
    int algo(int indx,int amt,int [] coins,int [][]dp){
        if(amt==0) return 1;


        if(indx==coins.length || amt<0){

            return 0;
        }

        if(dp[indx][amt]!=-1){
            return dp[indx][amt];
        }

        int task=algo(indx,amt-coins[indx],coins,dp);
        int leave=algo(indx+1,amt,coins,dp);
        dp[indx][amt]=task+leave;
        return dp[indx][amt];
    }
}