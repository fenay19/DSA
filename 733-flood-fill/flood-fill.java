class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {

        int n=image.length;
        int m=image[0].length;
        Queue<Pair>q=new LinkedList<>();
int orig=image[sr][sc];

if(orig==color){
    return image;
}
        boolean[][] vis=new boolean[n][m];

       q.offer(new Pair(sr,sc));
       vis[sr][sc]=true;
       int []x={1,-1,0,0};
       int []y={0,0,1,-1};

       while(!q.isEmpty()){
int r=q.peek().x1;
int c=q.peek().y1;
q.remove();

 image[r][c]=color;
 for(int k=0;k<4;k++){

    int r1=r+x[k];
    int c1=c+y[k];


    if(r1<n && r1>=0 && c1<m && c1>=0  && orig==image[r1][c1] && vis[r1][c1]==false ){


        image[r1][c1]=color;
        q.offer(new Pair(r1,c1));
        vis[r1][c1]=true;
    }
 }


       }
       return image;
    }
}

class Pair{
    int x1;
    int y1;
    Pair(int x1,int y1){
        this.x1=x1;
        this.y1=y1;

    }
}