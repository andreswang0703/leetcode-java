package dp;

/**
 * No.1824 Minimum sideway jumps.
 *
 */
public class MinimumSidewayJumps {

    public int minimum(int[] ob) {
        int max = ob.length + 1;

        int[][] dp = new int[3][ob.length];
        dp[0][0] = 1;  // mistake: dp[0][0] dp[0][1] dp[0][2]
        dp[1][0] = 0;
        dp[2][0] = 1;

        for (int i = 1; i < ob.length; i++) {
            for (int j = 0; j < 3; j++) {
                if (ob[i] == j + 1) {  // mistake: ob[i] == j
                    dp[j][i] = max;
                } else {
                    dp[j][i] = dp[j][i - 1];
                }
            }

            int minJump = Math.min(dp[0][i], Math.min(dp[1][i], dp[2][i]));
            for (int j = 0; j < 3; j++) {
                if (ob[i] - 1 == j) continue; // mistake: this line missing, we shouldn't update obstacle cell
                dp[j][i] = Math.min(dp[i][j], minJump + 1);
            }
        }

        return Math.min(dp[0][ob.length - 1], Math.min(dp[1][ob.length - 1], dp[2][ob.length - 1]));
    }
}
