package dp;

/**
 * Not a leetcode problem.
 *
 * Given int array nums, find out if there's a subset of nums that sums to k.
 *
 * time: O(n * k)
 * space: O(n * k)
 *
 */
public class SubsetSum {

    public boolean subsetSum(int[] nums, int k) {
        boolean[][] dp = new boolean[nums.length][k + 1];
        for (int i = 0; i < dp.length; i++) {
            dp[i][0] = true;
        }

        for (int i = 0; i < dp[0].length; i++) {
            dp[0][i] = nums[0] == i;
        }

        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                boolean ignore = dp[i - 1][j];
                boolean select = false;
                if (nums[i] <= j) {
                    select = dp[i - 1][j - nums[i]];
                }
                dp[i][j] = ignore || select;
            }
        }

        return dp[nums.length - 1][k];
    }

    public static void main(String[] args) {
        SubsetSum solver = new SubsetSum();
        int[] nums1 = new int[]{1,2,3,7};
        int k1 = 6;
        System.out.println(solver.subsetSum(nums1, k1)); // true

        int[] nums2 = new int[]{1,2,7,1,5};
        int k2 = 10;
        System.out.println(solver.subsetSum(nums2, k2)); // true

        int[] nums3 = new int[]{1,3,4,8};
        int k3 = 6;
        System.out.println(solver.subsetSum(nums3, k3)); // false
    }
}
