package dp;

public class KnapsackBruteForceRecursive {

    public int solveKnapsack(int[] weight, int[] values, int capacity) {
        return recursive(weight, values, capacity, 0);
    }

    private int recursive(int[] weight, int[] values, int capacity, int index) {
        if (index >= weight.length || capacity <= 0) {
            return 0;
        }

        int takeCurrent = 0;
        if (capacity >= weight[index]) {
            takeCurrent = recursive(weight, values, capacity - weight[index], index + 1) + values[index];
        }
        int ignoreCurrent = recursive(weight, values, capacity, index + 1);

        return Math.max(ignoreCurrent, takeCurrent);
    }

    public static void main(String[] args) {
        int[] values1 = new int[]{1, 6, 10, 16};
        int[] weight1 = new int[]{1, 2, 3, 5};

        KnapsackBruteForceRecursive solver = new KnapsackBruteForceRecursive();
        int maxProfit = solver.solveKnapsack(weight1, values1, 5);
        System.out.println(maxProfit);
    }
}
