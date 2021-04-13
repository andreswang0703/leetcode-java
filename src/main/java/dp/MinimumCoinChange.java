package dp;

import java.util.Arrays;

/**
 * No.322 Minimum coin change.
 *
 */
public class MinimumCoinChange {

    public int coinChange(int[] coins, int amount) {
        int n = coins.length;
        int[][] dp = new int[n][amount + 1];

        for (int i = 0; i < n; i++) {
            for (int j = 1; j < amount + 1; j++) {
                dp[i][j] = amount + 1;
            }
        }

        for (int i = 1; i < amount + 1; i++) {
            if (i % coins[0] == 0) {
                dp[0][i] = i / coins[0];
            }
        }

        for (int i = 1; i < n; i++) {
            for (int j = 1; j < amount + 1; j++) {
                int a = dp[i - 1][j];
                if (coins[i] <= j) {
                    a = Math.min(a, dp[i][j - coins[i]] + 1);
                }
                dp[i][j] = a;
            }
        }

        return dp[n - 1][amount] == amount + 1 ? -1 : dp[n - 1][amount];
    }

    /**
     * Optimized to use 1d array.
     */
    public int coinChangeSpaceOptimized(int[] coins, int amount) {
        int n = coins.length;
        int[] dp = new int[amount + 1];

        int max = amount + 1;
        Arrays.fill(dp, max);
        dp[0] = 0;  // mistake: didn't set dp[0] = 0

        for (int i = 0; i < n; i++) {
            for (int j = 1; j < amount + 1; j++) {
                if (coins[i] <= j) {
                    dp[j] = Math.min(dp[j], dp[j - coins[i]] + 1);
                }
            }
        }

        return dp[amount] == max ? -1 : dp[amount];
    }
}
