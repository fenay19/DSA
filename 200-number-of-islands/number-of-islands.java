class Solution {
    public int numIslands(char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        
        boolean[][] vis = new boolean[n][m];
        int res = 0;

        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(grid[i][j] == '1' && !vis[i][j]){
                    dfs(grid, i, j, vis, n, m);
                    res++;
                }
            }
        }
        return res;
    }

    public boolean valid(int i, int j, int n, int m){
        return (i >= 0 && i < n && j >= 0 && j < m);
    }

    public void dfs(char[][] grid, int i, int j, boolean[][] vis, int n, int m){
        vis[i][j] = true;

        int[] x = {-1, 1, 0, 0};
        int[] y = {0, 0, -1, 1};

        for(int k = 0; k < 4; k++){
            int r = i + x[k];
            int c = j + y[k];

            if(valid(r, c, n, m) && grid[r][c] == '1' && !vis[r][c]){
                dfs(grid, r, c, vis, n, m);
            }
        }
    }
}