class Solution {
    public int fib(int n) {
        // tabulation approach
        if(n==0 ||n==1) return n;
        int p_prev=0;
        int prev=1;
        int ans=0;
        for(int i=2;i<=n;i++){
        ans=prev+p_prev;
        p_prev=prev;
        prev=ans;

        }
        return ans;
    }
}