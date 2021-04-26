package graph.bfs;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class PathWithMinimumEffort {
    public int minimumEffortPath(int[][] heights) {
        int n = heights.length, m = heights[0].length;
        int[][] directions = {{0,1},{1,0},{-1,0},{0,-1}};
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        boolean[][] visited = new boolean[n][m];
        int[][] minEfforts = new int[n][m];
        for (int[] arr : minEfforts) {
            Arrays.fill(arr, Integer.MAX_VALUE);
        }
        minEfforts[0][0] = 0;

        pq.add(new int[]{0,0,0});

        while (!pq.isEmpty()) {
            int[] cell = pq.poll();

            int maxEffortOfPathSoFar = cell[0];
            int r = cell[1], c = cell[2];
            visited[r][c] = true;

            for (int[] dir : directions) {
                int rNext = r + dir[0];
                int cNext = c + dir[1];
                if (rNext < 0 || cNext < 0 || rNext >= n || cNext >= m || visited[rNext][cNext]) {
                    continue;
                }
                int heightDiff = Math.abs(heights[r][c] - heights[rNext][cNext]);
                int maxEffortOfPath = Math.max(maxEffortOfPathSoFar, heightDiff);
                if (maxEffortOfPath < minEfforts[rNext][cNext]) {
                    pq.add(new int[]{maxEffortOfPath, rNext, cNext});
                    minEfforts[rNext][cNext] = maxEffortOfPath;
                }
            }
        }

        for (int[] ar : minEfforts) {
            System.out.println(Arrays.toString(ar));
        }

        return minEfforts[n - 1][m - 1];
    }

    public static void main(String[] args) {
        int[][] arr = {{1,2,2,},{3,8,2},{5,3,5}};
        PathWithMinimumEffort solver = new PathWithMinimumEffort();
        System.out.println(solver.minimumEffortPath(arr));
    }
}
