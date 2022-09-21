package graphs;

import java.util.LinkedList;
import java.util.Queue;

/***
 @author: Pratiksha Kulkarni
 date: 9/21/2022
 */
public class numberOfIslands {
    private class Pair {
        int row;
        int column;

        public Pair() {
        }

        public Pair(int i, int j) {
            this.row = i;
            this.column = j;
        }

        public int getRow() {
            return this.row;
        }

        public int getColumn() {
            return this.column;
        }
    }

    private void bfs(Pair startIndex, char[][] grid, boolean[][] vis) {
        //get row and columns
        int i = startIndex.getRow();
        int j = startIndex.getColumn();

        //Queue to store the vertices and its neighbours
        Queue<Pair> q = new LinkedList<>();
        q.add(startIndex);
        //marked it as visited
        vis[i][j] = true;

        while (!q.isEmpty()) {
            Pair currentCell = q.poll();
            int m = currentCell.getRow();
            int n = currentCell.getColumn();

            for (int drow = -1; drow <= 1; drow++) {
                for (int dcol = -1; dcol <= 1; dcol++) {
                    //getting neighbors for currentcell
                    int nrow = drow + m;
                    int ncol = dcol + n;

                    if (nrow >= 0 && nrow < grid.length && ncol >= 0 && ncol < grid[0].length
                            && grid[nrow][ncol] == '1' && !vis[nrow][ncol]) {
                        vis[nrow][ncol] = true;
                        q.add(new Pair(nrow, ncol));
                    }
                }
            }
        }

    }

    // Function to find the number of islands.
    public int numIslands(char[][] grid) {
        // Code here
        //rows n columns m
        int n = grid.length;
        int m = grid[0].length;

        //visited array
        boolean[][] vis = new boolean[n][m];
        int noOfIslands = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == '1' && !vis[i][j]) {
                    noOfIslands++;
                    bfs(new Pair(i, j), grid, vis);
                }
            }
        }

        return noOfIslands;

    }
}
