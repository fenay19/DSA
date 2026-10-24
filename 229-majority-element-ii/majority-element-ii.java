class Solution {
    public List<Integer> majorityElement(int[] nums) {
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<nums.length;i++){
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);

        }
        int s=nums.length/3;
       List<Integer> ans=new ArrayList<>();
        for(int x=0;x<nums.length;x++){

            if(map.get(nums[x])>s && !ans.contains(nums[x])){
                ans.add(nums[x]);
            }
  




        }
        return ans;
    }
}