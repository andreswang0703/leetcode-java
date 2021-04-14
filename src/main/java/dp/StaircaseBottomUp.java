package dp;

public class StaircaseBottomUp {

    public int count(int total) {
        int[] dp = new int[total + 1];
        dp[0] = 1;
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i < total + 1; i++) {
            dp[i] = dp[i - 1] + dp[i - 2] + dp[i - 3];
        }
        return dp[total];
    }

    public int countSpaceOptimized(int total) {
        if (total < 2) {
            return 1;
        }
        if (total == 2) {
            return 2;
        }
        int a = 1, b = 1, c = 2, temp;
        for (int i = 3; i <= total; i++) {
            temp = a + b + c;
            a = b;
            b = c;
            c = temp;
        }
        return c;
    }

    public static void main(String[] args) {
        StaircaseBottomUp solver = new StaircaseBottomUp();
        System.out.println(solver.count(3));
        System.out.println(solver.count(4));
        System.out.println(solver.count(5));
        System.out.println(solver.count(6));

        System.out.println(solver.countSpaceOptimized(3));
        System.out.println(solver.countSpaceOptimized(4));
        System.out.println(solver.countSpaceOptimized(5));
        System.out.println(solver.countSpaceOptimized(6));
    }
}
