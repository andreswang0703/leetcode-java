package dp;

/**
 * No.416 Partition equal subset sum. (medium)
 *
 * time: O(n * sum)
 * space: O(n * sum)
 */
class EqualSubsetSumPartitionBottomUpDP {

    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int i : nums) {
            sum += i;
        }
        if (sum % 2 == 1) {
            return false;
        }

        int half = sum / 2;

        // dp[i][j]: means whether nums [0, i] can have subset that sums to j
        boolean[][] dp = new boolean[nums.length][half + 1];

        // first column: check if subset can have sum = 0
        // always can get sum = 0 from nums (not select anything)
        for (int i = 0; i < nums.length; i++) {
            dp[i][0] = true;
        }

        // first row: check if set {nums[0]} can be summed to j
        // true only when j == nums[0], or j = 0
        for (int j = 1; j < half + 1; j++) {
            dp[0][j] = nums[0] == j;
        }

        for (int i = 1; i < nums.length; i++) {
            for (int j = 1; j <= half; j++) {
                boolean ignore = dp[i - 1][j];
                boolean select = false;
                if (nums[i] <= j) {
                    select = dp[i - 1][j - nums[i]];
                }
                dp[i][j] = ignore || select;
            }
        }

        return dp[nums.length - 1][half];
    }

    public boolean canPartitionSpaceOptimized(int[] nums) {
        int sum = 0;
        for (int i : nums) {
            sum += i;
        }
        if (sum % 2 == 1) {
            return false;
        }

        int half = sum / 2;
        boolean[] dp = new boolean[half + 1];
        dp[0] = true;
        if (nums[0] < half + 1) {
            dp[nums[0]] = true;
        }
        for (int i = 1; i < nums.length; i++) {
            for (int j = half; j >= 0; j--) {
                if (j >= nums[i]) {
                    dp[j] = dp[j] || dp[j - nums[i]];
                }
            }
        }
        return dp[half];
    }

    public static void main(String[] args) {
        EqualSubsetSumPartitionBottomUpDP solver = new EqualSubsetSumPartitionBottomUpDP();
        int[] nums = new int[]{1,5,11,5}; // true
        int[] nums1 = new int[]{1,2,3,5}; // false
        System.out.println(solver.canPartition(nums));
        System.out.println(solver.canPartition(nums1));
        System.out.println(solver.canPartitionSpaceOptimized(nums));
        System.out.println(solver.canPartitionSpaceOptimized(nums1));
    }
}
