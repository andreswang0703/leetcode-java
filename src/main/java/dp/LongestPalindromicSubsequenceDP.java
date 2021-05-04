package dp;

/**
 * No.516 Longest palindromic sequence.
 *
 * Date: 04/26/2021
 *
 */
public class LongestPalindromicSubsequenceDP {
    public int longest(String s) {

        int n = s.length();
        int[][] dp = new int[n][n];

        for (int i = 0; i < n; i++) {
            dp[i][i] = 1;
        }

        // d: distance of i & j: j = i + d
        for (int d = 1; d < n; d++) {
            for (int i = 0; i + d < n; i++) {
                int j = i + d;
                if (s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = dp[i + 1][j - 1] + 2;
                } else {
                    dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]);
                }
            }
        }

        return dp[0][n - 1];
    }
}
