class Solution {
    public int maxProfit(int[] prices) {
        int purch=prices[0];
        int ans=0;
        for(int i=1;i<prices.length;i++){
            int p=prices[i]-purch;
            if(p>ans){
            ans=p;
            }
           purch=Math.min(prices[i],purch);
        }
       return ans; 
    }
}