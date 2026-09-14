class Solution {
    public boolean isRectangleOverlap(int[] rec1, int[] rec2) {
        int left=Math.max(rec1[0],rec2[0]);
        int right=Math.min(rec1[2],rec2[2]);
    int w=right-left;
    int bot=Math.max(rec1[1],rec2[1]);
    int top=Math.min(rec1[3],rec2[3]);

    int h=top-bot;

   return w>0 && h>0;
    }
}