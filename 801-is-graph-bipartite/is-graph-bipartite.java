class Solution {
    boolean res=true;
    public boolean isBipartite(int[][] graph) {
        int n=graph.length;
      
     int[] color = new int[n];
        for (int i = 0; i < n; i++) {
            color[i] = -1;
        }
        for(int i=0;i<n;i++ ){
            if(color[i]==-1){
                dfs(graph,i,0,color);
            }
        }
return res;
    }
public void dfs(int[][] a,int n,int c,int[]color){
color[n]=c;
for(int j=0;j<a[n].length;j++){
    int neigh=a[n][j];
if(color[neigh]!=-1 && color[neigh]==c){
    res=false;
    return;
}
if(color[neigh]==-1){
    dfs(a,neigh,1-c,color);
}
}


}

}