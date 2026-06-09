class Solution {
    public int numEnclaves(int[][] grid) {
        Queue<Pair>q=new LinkedList<>();

        int n=grid.length;
        int m=grid[0].length;
        int[][]vis=new int[n][m];

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){

                if(i==0||j==0||i==n-1||j==m-1){
                    if(grid[i][j]==1){
                        q.offer(new Pair(i,j));

                        vis[i][j]=1;
                    }
                }
            }
        }


        int []x={1,-1,0,0};
        int []y={0,0,1,-1};

while(!q.isEmpty()){
    Pair curr = q.poll();
int r = curr.first;
int c = curr.second;

    for(int i=0;i<4;i++){
        int r1=r+x[i];
        int c1=c+y[i];

        if(r1>=0 && r1<n && c1>=0 && c1<m && vis[r1][c1]==0 && grid[r1][c1]==1){

q.offer(new Pair(r1,c1));
vis[r1][c1]=1;


        }
    }
}
int cnt=0;
for(int i=0;i<n;i++){
    for(int j=0;j<m;j++){
if(vis[i][j]==0 && grid[i][j]==1){
    cnt++;
}

    }
}

  return cnt;  }
}
class Pair {
    int first;
    int second;

    Pair(int first, int second) {
        this.first = first;
        this.second = second;
    }
}