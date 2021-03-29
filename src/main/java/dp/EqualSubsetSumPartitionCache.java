package dp;

/**
 * No.416 Partition Equal Subset Sum. (medium)
 *
 */
class EqualSubsetSumPartitionCache {
    private int half;

    /**
     * Solve using cache to store calculated result.
     *
     * time: O(n * sum)
     * space: O(n * sum)
     */
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int i : nums) {
            sum += i;
        }
        if (sum % 2 == 1) {
            return false;
        }

        this.half = sum / 2;
        int[][] dp = new int[nums.length][this.half + 1]; // 0: initialized, 1: true, -1: false

        return recursion(dp, nums, this.half, 0);
    }

    private boolean recursion(int[][] dp, int[] nums, int remain, int index) {
        if (index == nums.length || remain < 0) {
            return false;
        }

        if (nums[index] == remain) {
            return true;
        }

        if (dp[index][remain] != 0) {
            return dp[index][remain] == 1;
        }

        boolean select = recursion(dp, nums, remain - nums[index], index + 1);
        boolean ignore = recursion(dp, nums, remain, index + 1);

        if (select || ignore) {
            dp[index][remain] = 1;
            return true;
        }

        dp[index][remain] = -1;
        return false;
    }

    public static void main(String[] args) {
        EqualSubsetSumPartitionCache solver = new EqualSubsetSumPartitionCache();
        int[] nums = new int[]{1,5,11,5}; // true
        int[] nums1 = new int[]{1,2,3,5}; // false
        System.out.println(solver.canPartition(nums));
        System.out.println(solver.canPartition(nums1));
    }
}
