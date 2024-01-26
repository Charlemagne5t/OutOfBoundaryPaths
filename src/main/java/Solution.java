public class Solution {
    public int findPaths(int m, int n, int maxMove, int startRow, int startColumn) {
        int mod = (int)1e9 +7;
        Long[][][] memo = new Long[m + 1][n + 1][maxMove + 1];
        return dfs(m, n, maxMove, startRow, startColumn, memo) % mod;
    }
    private int dfs(int m, int n, int maxMove, int i, int j, Long[][][] memo){
        int mod = (int)1e9 +7;
        if( i == -1 || i == m || j == -1 || j == n){
            return 1;
        }
        if(maxMove == 0){
            return 0;
        }
        if(memo[i][j][maxMove] != null){
            return (int) (memo[i][j][maxMove] % mod);
        }
        long result = 0;
        long up = dfs(m, n, maxMove - 1, i - 1, j, memo) % mod;
        long down = dfs(m, n, maxMove - 1, i + 1, j, memo) % mod;
        long left = dfs(m, n, maxMove - 1, i, j - 1, memo) % mod;
        long right = dfs(m, n, maxMove - 1, i, j + 1, memo) % mod;
        result = (up + down + left + right) % mod;
        memo[i][j][maxMove] = Long.valueOf(result % mod);
        return (int)result;

    }
}
