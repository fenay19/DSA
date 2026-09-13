class Solution {
    public int rangeSum(int[] nums, int n, int left, int right) {
          int MOD = 1_000_000_007;
     ArrayList<Integer> arr =new ArrayList<>();
for(int i=0;i<n;i++){
    int sum=0;
    for(int j=i;j<n;j++){
        sum+=nums[j];
        arr.add(sum);
    }

}
int sum1=0;
arr.sort(Comparator.naturalOrder()); 
for(int i=left-1;i<right;i++){
sum1=(sum1+arr.get(i))%MOD;
}
return (int) sum1;
    }
}