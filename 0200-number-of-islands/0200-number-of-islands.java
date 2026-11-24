class Solution {
    public void markisland(char[][]grid, int i, int j, int m,int n){
        if(i < 0 || j < 0 || i >= m || j >= n || grid[i][j] == '0'){
            return;
        }
        grid[i][j] = '0';
        markisland(grid, i + 1, j, m, n);
        markisland(grid, i - 1, j , m, n);
        markisland(grid, i , j + 1, m , n);
        markisland(grid, i, j - 1, m, n);
    }
    public int countIslands(char[][] grid, int m, int n){
        int count = 0;
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(grid[i][j] == '1'){
                    count++;
                    markisland(grid,i, j, m,n);
                }
            }
        }
        return count;
    }
    public int numIslands(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int ans = countIslands(grid,m, n);
        return ans;
    }
    
}