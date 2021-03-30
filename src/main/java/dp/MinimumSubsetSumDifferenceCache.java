package dp;

/**
 * Given a set of positive numbers, partition the set into two subsets
 * with a minimum difference between their subset sums.
 *
 */
public class MinimumSubsetSumDifferenceCache {

    public int partition(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }

        Integer[][] dp = new Integer[nums.length][sum + 1];
        return partitionRecursive(dp, nums, 0, 0, 0);
    }

    private int partitionRecursive(Integer[][] dp, int[] nums, int index, int sum1, int sum2) {
        if (index == nums.length) {
            return Math.abs(sum1 - sum2);
        }

        if (dp[index][sum1] == null) {
            int diff1 = partitionRecursive(dp, nums, index + 1, sum1 + nums[index], sum2);
            int diff2 = partitionRecursive(dp, nums, index + 1, sum1, sum2 + nums[index]);

            dp[index][sum1] = Math.min(diff1, diff2);
        }

        return dp[index][sum1];
    }

    public static void main(String[] args) {
        MinimumSubsetSumDifferenceCache solver = new MinimumSubsetSumDifferenceCache();
        int[] nums = {1, 2, 3, 9};
        System.out.println(solver.partition(nums));
        nums = new int[]{1, 2, 7, 1, 5};
        System.out.println(solver.partition(nums));
        nums = new int[]{1, 3, 100, 4};
        System.out.println(solver.partition(nums));
    }
}
