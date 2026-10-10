class Solution {
    public int longestSubarray(int[] nums, int limit) {
        Deque<Integer> maxd= new ArrayDeque<>();
        Deque<Integer> mind =new ArrayDeque<>();

        int i=0;
        int len=0;
        for(int j=0;j<nums.length;j++){
            while(!maxd.isEmpty() && nums[maxd.peekLast()]<nums[j]){
  
            maxd.pollLast();

            }

            maxd.offerLast(j);
              while(!mind.isEmpty() && nums[mind.peekLast()]>nums[j]){
  
            mind.pollLast();

            }

            mind.offerLast(j);

            while(nums[maxd.peekFirst()]-(long)nums[mind.peekFirst()]>limit){

               if(maxd.peekFirst()==i){
                maxd.pollFirst();
               }
               if(mind.peekFirst()==i){
                mind.pollFirst();
               }

               i++;



            }
            len=Math.max(len,j-i+1);
        }
return len;
    }
}