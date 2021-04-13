package dp;

public class UnboundedKnapsack {

    public int getMaxProfit(int[] profits, int[] weights, int capacity) {
        int n = profits.length;
        int[][] dp = new int[n][capacity + 1];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                int selectCurrent = 0;
                int ignoreCurrent = 0;
                if (weights[i] <= j) {
                    selectCurrent = dp[i][j - weights[i]] + profits[i];
                }
                if (i != 0) {
                    ignoreCurrent = dp[i - 1][j];
                }
                dp[i][j] = Math.max(selectCurrent, ignoreCurrent);
            }
        }

        return dp[n - 1][capacity];
    }

    public static void main(String[] args) {
        UnboundedKnapsack solver = new UnboundedKnapsack();
        int[] weights = new int[]{1,3,4,5};
        int[] profits = new int[]{15,50,60,90};
        int capacity = 8;
        int res = solver.getMaxProfit(profits, weights, capacity);
        System.out.println(res);
    }
}
