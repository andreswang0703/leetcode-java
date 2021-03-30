package dp;

/**
 * Given a set of positive numbers, partition the set into two subsets
 * with a minimum difference between their subset sums.
 *
 * time: O(n * sum)
 * space: O(n * sum)
 *
 */
public class MinimumSubsetSumDifferenceBottomUp {

    public int partition(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }

        boolean[][] dp = new boolean[nums.length][sum/2 + 1];

        for (int i = 0; i < nums.length; i++) {
            dp[i][0] = true;
        }

        for (int i = 1; i < dp[0].length; i++) {
            if (nums[0] == i) {
                dp[0][i] = true;
            }
        }

        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                if (dp[i - 1][j]) {
                    dp[i][j] = true;
                } else if (nums[i] <= j){
                    dp[i][j] = dp[i - 1][j - nums[i]];
                }
            }
        }

        // find out in the last row, biggest sum
        int sum1 = 0;
        for (int i = dp[0].length - 1; i >= 0; i--) {
            if (dp[dp.length - 1][i]) {
                sum1 = i;
                break;
            }
        }

        return Math.abs(sum - sum1 - sum1);
    }

    public static void main(String[] args) {
        MinimumSubsetSumDifferenceBottomUp solver = new MinimumSubsetSumDifferenceBottomUp();
        int[] nums = {1, 2, 3, 9};
        System.out.println(solver.partition(nums));
        nums = new int[]{1, 2, 7, 1, 5};
        System.out.println(solver.partition(nums));
        nums = new int[]{1, 3, 100, 4};
        System.out.println(solver.partition(nums));
    }
}
