class Solution {
    public int coinChange(int[] coins, int amount) {
     int n = coins.length;
     int dp[][] = new int[n+1][amount+1];
     for(int i = 0; i <= n; i++)
         dp[i][0] = 0;
    for(int j = 0; j <= amount; j++)
        dp[0][j] = 100000;
     for(int i = 1; i <= n; i++)
     {
         for(int j = 1; j <= amount; j++)
         {
             if(coins[i-1] > j)
                 dp[i][j] = dp[i-1][j];
             else 
                 dp[i][j] = Integer.min(1+dp[i][j-coins[i-1]],dp[i-1][j]);
         }
     }
        // return dp[n][amount];
        return dp[n][amount] >1e4 ? -1 :dp[n][amount];
    }
}
