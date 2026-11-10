class Solution {
    public int climbStairs(int n, int[] costs) {
        int[] dp = new int[n + 1];
        Arrays.fill(dp, -1);
        return solve(0, n, costs, dp);
    }

    public int solve(int i, int n, int[] costs, int[] dp) {
        if (i == n) {
            return 0;
        }
        if (dp[i] != -1) {
            return dp[i];
        }
        int minCost = Integer.MAX_VALUE;
        for (int j = 1; j <= 3 && i + j <= n; j++) {
            int cost = costs[i + j - 1] + j * j;
            minCost = Math.min(minCost, cost + solve(i + j, n, costs, dp));
        }

        return dp[i] = minCost;
    }
}