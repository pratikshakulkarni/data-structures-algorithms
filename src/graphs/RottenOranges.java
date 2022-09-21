package graphs;

import java.util.LinkedList;
import java.util.Queue;

/***
 @author: Pratiksha Kulkarni
 date: 9/21/2022
 */
public class RottenOranges {
    class Pair {
        int row;
        int col;
        int time;

        public Pair(int _row, int _col, int _time) {
            row = _row;
            col = _col;
            time = _time;
        }
    }

    //Function to find minimum time required to rot all oranges.
    public int orangesRotting(int[][] grid) {
        //grid sizes
        int n = grid.length;
        int m = grid[0].length;
        int freshCount = 0;
        int[] drows = {-1, 0, +1, 0};
        int[] dcols = {0, +1, 0, -1};
        int cnt = 0;

        //Queue for all vertices
        Queue<Pair> q = new LinkedList<>();

        int[][] vis = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 2) {
                    q.add(new Pair(i, j, 0));

                    vis[i][j] = 2;
                } else if (grid[i][j] == 1) {
                    vis[i][j] = 0;
                    freshCount++;
                } else {
                    vis[i][j] = 0;
                }
            }
        }

        int minTime = 0;

        while (!q.isEmpty()) {
            Pair currentOrange = q.remove();
            int r = currentOrange.row;
            int c = currentOrange.col;
            int t = currentOrange.time;
            minTime = Math.max(minTime, t);

            for (int i = 0; i < 4; i++) {
                int nrow = r + drows[i];
                int ncol = c + dcols[i];

                if (nrow >= 0 && nrow < n && ncol >= 0 && ncol < m && grid[nrow][ncol] == 1 && vis[nrow][ncol] == 0) {
                    q.add(new Pair(nrow, ncol, t + 1));
                    vis[nrow][ncol] = 2;
                    cnt++;
                }
            }

        }

        if (cnt != freshCount)
            return -1;
        else
            return minTime;

    }
}
