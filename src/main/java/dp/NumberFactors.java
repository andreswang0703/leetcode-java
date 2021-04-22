package dp;

/**
 * Given a number ‘n’, implement a method to count how many possible ways there are to express ‘n’ as the sum of 1, 3, or 4.
 *
 */
public class NumberFactors {

    public int factors(int n) {
        if (n < 3) {
            return 1;
        }
        if (n == 3) { // 3 * 1; 3
            return 2;
        }
        if (n == 4) { // 4 * 1; 1 + 3; 4
            return 3;
        }

        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 1;
        dp[3] = 2;
        dp[4] = 3;

        for (int i = 5; i < n + 1; i++) {
            dp[i] = dp[i - 1] + dp[i - 3] + dp[i - 4];
        }
        return dp[n];
    }
}
