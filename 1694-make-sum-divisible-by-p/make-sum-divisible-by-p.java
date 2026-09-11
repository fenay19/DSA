class Solution {
    public int minSubarray(int[] nums, int p) {
        int sum=0;
        for(int i=0;i<nums.length;i++){
            sum=(sum+nums[i])%p;
        }
if(sum==0){
    return 0;
}
        int prefix=0;
        int tar=0;
        int ans=nums.length;
HashMap<Integer,Integer>map=new HashMap<>();
map.put(0,-1);
        for(int i=0;i<nums.length;i++){

            prefix=(prefix+nums[i])%p;

            tar=(prefix-sum+p)%p;
            if(map.containsKey(tar)){
                ans=Math.min(ans,i-map.get(tar));
            }
            
                map.put(prefix,i);

        }
        if(ans==nums.length){
            return -1;
        }
        return ans;
 
    }
}