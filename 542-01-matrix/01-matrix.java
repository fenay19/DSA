class Solution {
    public int[][] updateMatrix(int[][] mat) {

        int n=mat.length;
        int m=mat[0].length;
        int [][] res=new int[n][m];
        boolean [][] vis=new boolean[n][m];
        Queue<node>q=new LinkedList<>();
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){

if(mat[i][j]==0){


    q.offer(new node(i,j,0));
    vis[i][j]=true;
   
}
else{
    vis[i][j]=false;
}


            }
        }

        int []x={1,-1,0,0};
        int[]y={0,0,1,-1};

        while(!q.isEmpty()){
       int r=q.peek().f;
       int c=q.peek().s;
       int wt=q.peek().t;
       q.remove();
        res[r][c]=wt;
       for(int i=0;i<4;i++){
       int r1=r+x[i];
        int c1=c+y[i];
       
       if(r1<n && r1>=0 && c1<m && c1>=0 && vis[r1][c1]==false ){
        q.offer(new node(r1,c1,wt+1));
        vis[r1][c1]=true;
        
       }
       }


        }
        return res;
    }
}

class node{

int f;
int s;
int t;
node(int f,int s,int t){
    this.f=f;
    this.s=s;
    this.t=t;
}
}