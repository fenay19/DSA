class Solution {
    public int swimInWater(int[][] grid) {
        int n=grid.length;
        int m=grid[0].length;

        int l=grid[0][0];
        int h=grid[0][0];

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                h=Math.max(h,grid[i][j]);
            }
        }

        int res=0;
        while(l<=h){
            int v=l+(h-l)/2;

     if(bfs(grid,n,m,v)){
 res=v;
 h=v-1;
     }
     else{

        l=v+1;
     }
        }
        return res;
    }

         boolean bfs(int[][] a,int n,int m,int v){
            if(a[0][0]>v) return false;
        Queue<int []>q=new LinkedList<>();
        boolean[][] vis = new boolean[n][m];
        vis[0][0]=true;
        int[] x={1,-1,0,0};
        int[] y={0,0,1,-1};
        q.offer(new int [] {0,0});

        while(!q.isEmpty()){
            int [] curr=q.poll();
            int r=curr[0];
            int c=curr[1];
            if(r==n-1 && c==m-1){
                return true;
            }
for(int i=0;i<4;i++){
  int  r1=r+x[i];
  int  c1=c+y[i];

            if(r1>=0 && r1<n && c1>=0 &&c1<m && vis[r1][c1]==false && v>=a[r1][c1] ){

                q.offer(new int [] {r1,c1});

                vis[r1][c1]=true;
               
            }
        }
        }

return false;

        }
    
}