class Solution {
    public int maxProfit(int[] prices) {
    int minp=Integer.MAX_VALUE;
    int ans=0;
    for(int p:prices){
        minp=Math.min(p,minp);
        int pro=p-minp;

ans=Math.max(pro,ans);
    }
    return ans;
    }
}