package dp;

public class Staircase {

    /**
     * Recursive brute force.
     *
     * time: O(3^n)
     * space: O(n) - recursion stack
     *
     */
    public int count(int total) {
        if (total == 0 || total == 1) {
            return 1;
        }
        if (total == 2) {
            return 2;
        }

        int take1Step = count(total - 1);
        int take2Steps = count(total - 2);
        int take3Steps = count(total - 3);

        return take1Step + take2Steps + take3Steps;
    }

    public int countTopDown(int total) {
        int[] dp = new int[total + 1];
        return recursion(dp, total);
    }

    private int recursion(int[] dp, int total) {
        if (total == 0 || total == 1) {
            return 1;
        }
        if (total == 2) {
            return 2;
        }

        if (dp[total] == 0) {
            int a = recursion(dp, total - 1);
            int b = recursion(dp, total - 2);
            int c = recursion(dp, total - 3);
            dp[total] = a + b + c;
        }

        return dp[total];
    }
}
