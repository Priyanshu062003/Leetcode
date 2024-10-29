class Solution {
    int n,m;
    Integer dp[][];
    int solve(int i, int j, int [][]grid) {
        if(dp[i][j] != null) return dp[i][j];
        int up = 0, same = 0, down = 0;
        if(j+1==m) return 0;
        if(i-1 >=0&& grid[i][j] < grid[i-1][j+1]) 
            up = solve(i-1,j+1,grid)+1;
        
        if(grid[i][j] < grid[i][j+1]) 
            same = solve(i,j+1,grid)+1;
        
        if(i+1 < n && grid[i][j] < grid[i+1][j+1]) 
            down = solve(i+1,j+1,grid)+1;
        
        return dp[i][j] = Math.max(up,Math.max(same,down));
    }
    public int maxMoves(int[][] grid) {
        n = grid.length;
        m = grid[0].length;
        dp = new Integer[n][m];
        int ans = 0;
        for(int i=n-1; i>=0; i--) {
            ans = Math.max(ans,solve(i,0,grid));
            System.out.println(ans);
        }
        return ans;
    }
}