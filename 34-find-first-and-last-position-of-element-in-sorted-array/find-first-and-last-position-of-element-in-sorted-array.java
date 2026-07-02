class Solution {
    public int[] searchRange(int[] nums, int target) {
    return new int[]{first(nums,target),last(nums,target)};
    }

    int first(int [] nums,int target){


            int l=0;
        int h=nums.length-1;

        int res=-1;

        while(l<=h){
            int mid=l+(h-l)/2;

            if(nums[mid]==target){
               res=mid;
               h=mid-1;
            }
            else if(nums[mid]>target){
                h=mid-1;
            }
            else{
                 l=mid+1;
            }

            
        }
return res;

    }

    int last(int []nums,int target){
            int l=0;
        int h=nums.length-1;

        int res=-1;

        while(l<=h){
            int mid=l+(h-l)/2;

            if(nums[mid]==target){
               res=mid;
               l=mid+1;
            }
            else if(nums[mid]>target){
                h=mid-1;
            }
            else{
                 l=mid+1;
            }

            
        }
        return res;
    }
}