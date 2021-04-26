package graph.dfs;

/**
 * No.695 Max Area Of Island.
 *
 * Date: 4/26/2021
 */
public class MaxAreaOfIsland {

    public int maxAreaOfIsland(int[][] grid) {
        boolean[][] seen = new boolean[grid.length][grid[0].length];
        int maxArea = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                // only update maxArea when it's island
                if (grid[i][j] == 1) {
                    maxArea = Math.max(maxArea, recursive(grid, seen, i, j));
                }
            }
        }

        return maxArea;
    }

    private int recursive(int[][] grid, boolean[][] seen, int r, int c) {
        if (r < 0 || c < 0 || r >= grid.length || c >= grid[0].length || grid[r][c] == 0 || seen[r][c]) {
            return 0;
        }

        seen[r][c] = true;
        return recursive(grid, seen, r + 1, c) +
                recursive(grid, seen, r - 1, c) +
                recursive(grid, seen, r, c - 1) +
                recursive(grid, seen, r, c + 1) + 1;
    }
}