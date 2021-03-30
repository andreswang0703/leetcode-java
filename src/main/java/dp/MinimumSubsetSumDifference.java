package dp;

public class MinimumSubsetSumDifference {

    public int partition(int[] nums) {
        return partitionRecursive(nums, 0,0,0);
    }

    private int partitionRecursive(int[] nums, int index, int sum1, int sum2) {
        if (index == nums.length) {
            return Math.abs(sum1 - sum2);
        }

        int diff1 = partitionRecursive(nums, index + 1, sum1 + nums[index], sum2);
        int diff2 = partitionRecursive(nums, index + 1, sum1, sum2 + nums[index]);

        return Math.min(diff1, diff2);
    }

    public static void main(String[] args) {
        MinimumSubsetSumDifference solver = new MinimumSubsetSumDifference();
        int[] num = {1, 2, 3, 9};
        System.out.println(solver.partition(num));
        num = new int[]{1, 2, 7, 1, 5};
        System.out.println(solver.partition(num));
        num = new int[]{1, 3, 100, 4};
        System.out.println(solver.partition(num));
    }
}
