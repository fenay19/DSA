class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        int n=grid.length;
          
        if(grid[0][0]==1 || grid[n-1][n-1]==1){
            return -1;
        }
        if(n==1){
            return 1;
        }
      
        int [][]dist=new int[n][n];
        Queue<node> q=new LinkedList<>();
q.offer(new node(0,0,1));

dist[0][0]=1;


int []x={-1,-1,-1,0,0,1,1,1};
int []y={-1,0,1,-1,1,-1,0,1};

while(!q.isEmpty()){
     int r=q.peek().r;
    int c=q.peek().c;
    int wt=q.peek().wt;
   

    q.remove();

    for(int i=0;i<8;i++){

        int r1=r+x[i];
        int c1=c+y[i];
    

    if(r1<n && r1>=0 && c1<n && c1>=0 && grid[r1][c1]==0 && dist[r1][c1]==0 ){
      
    

      if(r1==n-1 && c1==n-1){
        return wt+1;
      }
  q.offer(new node(r1,c1,wt+1));
dist[r1][c1]=1;
    }
    }
}
return -1;
    }
}

class node{
int wt;
int r;
int c;
node(int r,int c,int wt){
   this.r=r;
    this.c=c;
    this.wt=wt;
     
}


}