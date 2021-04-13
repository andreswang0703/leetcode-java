package dp;

/**
 * Given a set of positive numbers, find the total number of subsets whose sum is equal to a given number s.
 */
public class CountOfSubsetSum {

    public int count(int[] nums, int s) {
        int[][] dp = new int[nums.length][s + 1];

        for (int i = 0; i < dp.length; i++) {
            dp[i][0] = 1;
        }

        for (int i = 1; i < dp[0].length; i++) {
            if (nums[0] == i) {
                dp[0][i] = 1;
            } else {
                dp[0][i] = 0;
            }
        }

        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                int count = dp[i - 1][j];
                if (nums[i] <= j) {
                    count += dp[i - 1][j - nums[i]];
                }
                dp[i][j] = count;
            }
        }

        return dp[nums.length - 1][s];
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,1,2,3};
        int s = 4;
        CountOfSubsetSum solver = new CountOfSubsetSum();
        System.out.println(solver.count(nums, s));
    }
}
