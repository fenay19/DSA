class Solution {
    HashMap<Integer,Integer>dp=new HashMap<>();
    int ans=0;
    public int climbStairs(int n) {
         return sum(0,n);
    }

    public int sum(int i,int n){


        if(i==n) return 1;
        if(i>n) return 0;
if(dp.containsKey(i)){
    return dp.get(i);
}
        int a=sum(i+1,n);
        int b=sum(i+2,n);

         ans=a+b;
        dp.put(i,ans);
        return ans;
    }
}