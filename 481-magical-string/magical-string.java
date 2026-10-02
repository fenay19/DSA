class Solution {
    public int magicalString(int n) {
        if(n<=0) return 0;
        if(n<=3) return 1;
        int a[]=new int[n+2];
        a[0]=1;
        a[1]=2;
        a[2]=2;
        int nums=1;
        int i=2;
        int j=3;
        int cnt=1;
        while(j<n){
            int times=a[i];
            for(int k=0;k<times && j<n;k++){
               a[j]=nums;
               if(nums==1){
                cnt++;
               }
               j++;
            }
            nums=3-nums;
            i++;
        }
        return cnt;
    }
}