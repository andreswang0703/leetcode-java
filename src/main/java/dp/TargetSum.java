package dp;

import java.util.Arrays;

public class TargetSum {
    public int findTargetSumWays(int[] nums, int S) {
        int n = nums.length;
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if (S > sum || S < -sum) {
            return 0;
        }

        int size = 2 * sum + 1;
        int[][] dp = new int[n][size];

        for (int i = 0; i < size; i++) {
            if (i == sum - nums[0]) {
                dp[0][i] += 1;
            }
            if (i == sum + nums[0]) {
                dp[0][i] += 1;
            }
        }

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < size; j++) {
                int count = 0;
                if (j + nums[i] < size) {
                    count += dp[i - 1][j + nums[i]];
                }
                if (j - nums[i] >= 0) {
                    count += dp[i - 1][j - nums[i]];
                }
                dp[i][j] = count;
            }
        }

        printMatrix(dp);

        return dp[n - 1][sum + S];
    }

        public int findTargetSumWaysII(int[] nums, int S) {
            int[][] dp = new int[nums.length][2001];
            dp[0][nums[0] + 1000] = 1;
            dp[0][-nums[0] + 1000] += 1;
            for (int i = 1; i < nums.length; i++) {
                for (int sum = -1000; sum <= 1000; sum++) {
                    if (dp[i - 1][sum + 1000] > 0) {
                        dp[i][sum + nums[i] + 1000] += dp[i - 1][sum + 1000];
                        dp[i][sum - nums[i] + 1000] += dp[i - 1][sum + 1000];
                    }
                }
            }
            printMatrix(dp);
            return S > 1000 ? 0 : dp[nums.length - 1][S + 1000];
        }


    public static void main(String[] args) {
        int[] nums = new int[]{0,0,0,0,0,0,0,0,1};
        int S = 1;
        TargetSum solver = new TargetSum();
        solver.findTargetSumWays(nums, S);
//        solver.findTargetSumWaysII(nums, S);
    }

    private static void printMatrix(int[][] nums) {
        for (int[] arr : nums) {
            System.out.println(Arrays.toString(arr));
        }
    }
}
