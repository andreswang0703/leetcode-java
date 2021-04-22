package dp;

/**
 *
 * Given an array of positive numbers, where each element represents the max number of jumps
 * that can be made forward from that element, write a program to find the minimum number of jumps needed
 * to reach the end of the array (starting from the first element).
 * If an element is 0, then we cannot move through that element.
 *
 * Input = {2,1,1,1,4}
 * Output = 3
 * Explanation: Starting from index '0', we can reach the last index through: 0->2->3->4
 *
 */
public class MinimumJumpToReachTheEnd {

    /**
     * time: O(n^2)
     * space: O(n)
     */
    public int minimumJumps(int[] jumps) {
        int[] dp = new int[jumps.length];

        for (int i = 1; i < jumps.length; i++) {
            dp[i] = Integer.MAX_VALUE;  // initialize as max value except dp[0]
        }
        for (int i = 0; i < jumps.length; i++) {
            for (int j = i + 1; j < i + jumps[i] && j < jumps.length; j++) {
                dp[j] = Math.min(dp[j], dp[i] + 1);
            }
        }
        return dp[jumps.length - 1];
    }
}
