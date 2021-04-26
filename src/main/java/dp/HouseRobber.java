package dp;

/**
 * No.198 House robber.
 *
 * Date: 04/26/2021
 */
public class HouseRobber {

    public int rob(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }

        int[] dp = new int[nums.length + 1];
        dp[0] = 0;
        dp[1] = nums[0];
        for (int i = 2; i < nums.length + 1; i++) {
            dp[i] = Math.max(nums[i - 1] + dp[i - 2], dp[i - 1]);
        }
        return dp[nums.length];
    }

    public int robSpaceOptimized(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int n1 = 0, n2 = nums[0], temp;
        for (int i = 2; i < nums.length + 1; i++) {
            temp = Math.max(n2, n1 + nums[i - 1]);
            n1 = n2;
            n2 = temp;
        }
        return n2;
    }

    public static void main(String[] args) {
        int[] nums = {2,7,9,3,1}; // 12
        HouseRobber solver = new HouseRobber();
        System.out.println(solver.rob(nums));
        System.out.println(solver.robSpaceOptimized(nums));
    }
}
