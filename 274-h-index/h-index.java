class Solution {
    public int hIndex(int[] c) {
        int l=0;
        int h=c.length-1;
        int n=c.length;
        Arrays.sort(c);
        int res=0;
        while(l<=h){
int m=(l+h)/2;

if(c[m]>=n-m){
    res=n-m;
    h=m-1;
}
else{
    l=m+1;
}



        }
        return res;
    }
}