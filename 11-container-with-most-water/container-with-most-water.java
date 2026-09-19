class Solution {
    public int maxArea(int[] height) {
     int ans1=0;
     int i=0;
     int j=height.length-1;
     while(i<j)   {
       int ans=Math.min(height[i],height[j])*(j-i);
       ans1=Math.max(ans1,ans);

       if(height[i]==height[j]){
        i++;
        j--;
       }
       else if(height[i]<height[j]){
        i++;
       }
       else{
        j--;
       }
     }
     return ans1;
    }
}