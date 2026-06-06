class Solution {

    public void dfs(int node,List<List<Integer>> arr,boolean[]vis){
vis[node]=true;
for(Integer k:arr.get(node)){

    if(vis[k]==false){
        dfs(k,arr,vis);
    }
}

    }
    public int findCircleNum(int[][] isConnected) {
        int cnt=0;
        int n=isConnected.length;
        boolean [] vis=new boolean[n];
  List<List<Integer> >adj=new ArrayList<>();
        for(int i=0;i<n;i++){
adj.add(new ArrayList<Integer>());
        }

        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
        if(isConnected[i][j] == 1 && i != j) {
                    adj.get(i).add(j);
                }


            }
        }

        for(int i=0;i<n;i++){
if(vis[i]==false){
    cnt++;
    dfs(i,adj,vis);
}


        }

        return cnt;
        
    }
}