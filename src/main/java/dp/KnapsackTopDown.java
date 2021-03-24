package dp;

/**
 * Top-down memorization for 0/1 knapsack problem.
 *
 * Date: 03/23/2021
 *
 */
public class KnapsackTopDown {

    /**
     * Optimized based on brute force. Cache result in array during calculation.
     *
     * time: O(n * capacity)
     * space: O(n * capacity)
     */
    public int solveKnapsack(int[] weights, int[] values, int capacity) {
        int[][] dp = new int[weights.length][capacity + 1];
        for (int i = 0; i < weights.length; i++) {
            for (int j = 0; j <= capacity; j++) {
                dp[i][j] = -1;
            }
        }
        return recursive(dp, weights, values, capacity, 0);
    }

    private int recursive(int[][] dp, int[] weights, int[] values, int capacity, int index) {
        if (capacity <= 0 || index >= weights.length) {
            return 0;
        }

        // return result if calculated before
        if (dp[index][capacity] != -1) {
            return dp[index][capacity];
        }

        int takeCurrent = 0;
        if (weights[index] <= capacity) {
            takeCurrent = recursive(dp, weights, values, capacity - weights[index], index + 1) + values[index];
        }
        int ignoreCurrent = recursive(dp, weights, values, capacity, index + 1);

        int maxProfit = Math.max(takeCurrent, ignoreCurrent);

        // cache result
        dp[index][capacity] = maxProfit;
        return maxProfit;
    }

    public static void main(String[] args) {
        int[] values1 = new int[]{1, 6, 10, 16};
        int[] weight1 = new int[]{1, 2, 3, 5};

        KnapsackTopDown solver = new KnapsackTopDown();
        int maxProfit = solver.solveKnapsack(weight1, values1, 5);
        System.out.println(maxProfit);
    }
}
