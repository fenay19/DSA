class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        return atmost(nums,k)-atmost(nums,k-1);
    }
    int atmost(int [] arr,int x){
int oddc=0;
int l=0;
int ans=0;
for(int r=0;r<arr.length;r++){

if(arr[r]%2!=0){
    oddc++;
}

while(oddc>x){
if(arr[l]%2!=0){
    oddc--;
}
l++;


}
ans+=r-l+1;


}

return ans;

    }
}