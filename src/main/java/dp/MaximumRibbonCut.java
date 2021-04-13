package dp;

import java.util.Arrays;

public class MaximumRibbonCut {

    public int maximumRibbonCut(int[] list, int total) {
        int n = list.length;
        int[][] dp = new int[n][total + 1];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], -1);
        }
        for (int i = 0; i < n; i++) {
            dp[i][0] = 0;
        }

        for (int i = 0; i < n; i++) {
            for (int j = 1; j < total + 1; j++) {
                if (i > 0) {
                    dp[i][j] = dp[i - 1][j];
                }
                if (list[i] <= j && dp[i][j - list[i]] != -1) {
                    dp[i][j] = Math.max(dp[i][j], dp[i][j - list[i]] + 1);
                }
            }
        }

        return dp[n - 1][total];
    }

    public static void main(String[] args) {
        int[] list = {2,3,5};
        MaximumRibbonCut solver = new MaximumRibbonCut();
        System.out.println(solver.maximumRibbonCut(list, 5));
        int[] list2 = {5,3,7};
        System.out.println(solver.maximumRibbonCut(list2, 13));
        int[] list3 = {3,5};
        System.out.println(solver.maximumRibbonCut(list3, 7));
    }
}
