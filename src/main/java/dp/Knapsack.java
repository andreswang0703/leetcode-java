package dp;

import java.util.Arrays;

/**
 * 0/1 Knapsack problem.
 *
 * Date: 03/23/2021
 */
public class Knapsack {

    /**
     *  Bottom-up memorization:
     *
     *  Use 2-dimensional array for memorization:
     *  Each cell represents a sub-problem, for dp[i][j]:
     *  What is the max possible value with capacity of j,
     *  and choosing from items 0 to i (inclusive).
     *
     *  time: O(n * capacity)
     *  space: O(n * capacity)
     */
    public int solveKnapsack(int[] weight, int[] value, int capacity) {
        int[][] dp = new int[weight.length][capacity + 1];

        // initialize first column: 0 when capacity is 0
        for (int i = 0; i < weight.length; i++) {
            dp[i][0] = 0;
        }

        // initialize first row: take first item if capacity allows
        for (int i = 1; i <= capacity; i++) {
            if (weight[0] < capacity) {
                dp[0][i] = value[0];
            }
        }

        for (int i = 1; i < weight.length; i++) {
            for (int j = 1; j <= capacity; j++) {
                int ignoreCurrent = dp[i - 1][j];

                // if current item's weight exceeds capacity, we can only ignore
                if (weight[i] > j) {
                    dp[i][j] = ignoreCurrent;
                } else {
                    int takeCurrent = dp[i - 1][j - weight[i]] + value[i];
                    dp[i][j] = Math.max(ignoreCurrent, takeCurrent);
                }
            }
        }

        printMatrix(dp);
        return dp[weight.length - 1][capacity];
    }

    public static void main(String[] args) {
        int[] values1 = new int[]{1, 6, 10, 16};
        int[] weight1 = new int[]{1, 2, 3, 5};

        Knapsack solver = new Knapsack();
        int maxCapacity = solver.solveKnapsack(weight1, values1, 5);
        System.out.println(maxCapacity);
    }

    static void printMatrix(int[][] arr) {
        for (int[] ints : arr) {
            System.out.println(Arrays.toString(ints));
        }
    }
}
