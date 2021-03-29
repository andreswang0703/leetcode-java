package dp;

/**
 * No.416 Partition Equal Subset Sum. (medium)
 *
 */
class EqualSubsetSumPartition {

    /**
     * Brute force algorithm using recursion.
     *
     * time: O(2 ^ n)
     * space: O(n)
     */
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int i : nums) {
            sum += i;
        }
        if (sum % 2 == 1) {
            return false;
        }

        return recursion(nums, sum / 2, 0);
    }

    /**
     * Check if nums[0, index] can have subset summed to int remain.
     */
    private boolean recursion(int[] nums, int remain, int index) {
        if (index == nums.length || remain < 0) {
            return false;
        }

        if (nums[index] == remain) {
            return true;
        }

        boolean select = recursion(nums, remain - nums[index], index + 1);
        boolean ignore = recursion(nums, remain, index + 1);

        return select || ignore;
    }

    public static void main(String[] args) {
        EqualSubsetSumPartition solver = new EqualSubsetSumPartition();
        int[] nums = new int[]{1,5,11,5}; // true
        int[] nums1 = new int[]{1,2,3,5}; // false
        System.out.println(solver.canPartition(nums));
        System.out.println(solver.canPartition(nums1));
    }
}