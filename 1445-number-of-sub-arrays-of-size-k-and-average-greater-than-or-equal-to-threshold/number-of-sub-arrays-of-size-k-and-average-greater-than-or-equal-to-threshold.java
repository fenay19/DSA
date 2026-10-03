class Solution {
    public int numOfSubarrays(int[] arr, int k, int threshold) {
        int cnt=0;
        int j=0;
 int sum=0;
        for(int i=0;i<arr.length;i++){
sum+=arr[i];
int avg=sum/k;
int len=i-j+1;
if(len==k && avg>=threshold){
    cnt++;

}
while(len>=k){
    sum-=arr[j];
    len--;
    j++;
}
        }
        return cnt;
    }
}