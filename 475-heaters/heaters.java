class Solution {
    public int findRadius(int[] houses, int[] heaters) {
        Arrays.sort(houses);
        Arrays.sort(heaters);
        int ans=0;
        int j=0;
        for(int i=0;i<houses.length;i++){
           
           while(j<heaters.length-1 &&
           Math.abs(heaters[j+1]-houses[i])<=Math.abs(houses[i]-heaters[j])){
            j++;
           }
           int dist=Math.abs(heaters[j]-houses[i]);
           ans=Math.max(ans,dist);



        }
        return ans;
    }
}