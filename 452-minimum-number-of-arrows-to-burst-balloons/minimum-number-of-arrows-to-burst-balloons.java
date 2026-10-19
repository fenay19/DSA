class Solution {
    public int findMinArrowShots(int[][] points) {
        Arrays.sort(points, Comparator.comparingInt(a -> a[0]));
int arrows=1;
     int l=points[0][1];
        for(int i=1;i<points.length;i++){
         
            int f=points[i][0];
       
         if(l<f){
            arrows++;
    l=points[i][1];
         }
     else{
        l=Math.min(l,points[i][1]);
     }
            
        }
        return arrows;
    }
}