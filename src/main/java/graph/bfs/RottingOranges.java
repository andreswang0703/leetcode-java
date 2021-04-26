package graph.bfs;

import java.util.LinkedList;
import java.util.Queue;

/**
 * No.994 Rotting oranges.
 *
 */
public class RottingOranges {

    public int rotting(int[][] oranges) {
        Queue<int[]> queue = new LinkedList<>();
        int fresh = 0;
        for (int i = 0; i < oranges.length; i++) {
            for (int j = 0; j < oranges[0].length; j++) {
                if (oranges[i][j] == 1) {
                    fresh++;
                } else if (oranges[i][j] == 2) {
                    queue.offer(new int[]{i, j});
                }
            }
        }

        int[][] directions = {{0,1}, {1,0}, {0,-1}, {-1,0}};
        int timeLapsed = 0;
        while (!queue.isEmpty() && fresh > 0) {  // mistake: didn't add fresh > 0
            int size = queue.size();
            while (size > 0) {
                int[] orange = queue.poll();
                for (int[] direction : directions) {
                    int row = orange[0] + direction[0];
                    int col = orange[1] + direction[1];
                    if (row >= 0 && row < oranges.length && col >= 0 && col < oranges[0].length && oranges[row][col] == 1) {
                        fresh--;
                        oranges[row][col] = 2;
                        queue.offer(new int[]{row, col});
                    }
                }
                size--;
            }
            timeLapsed++;
        }

        if (fresh == 0) {
            return timeLapsed;
        } else {
            return -1;
        }
    }
}
