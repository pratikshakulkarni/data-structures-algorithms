package graphs;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/***
 @author: Pratiksha Kulkarni
 date: 9/21/2022
 */
public class NearestCellHavingOne {
    class Node {
        int row;
        int col;
        int distance;

        public Node(int _r, int _c, int _d) {
            row = _r;
            col = _c;
            distance = _d;
        }
    }

    //Function to find distance of nearest 1 in the grid for each cell.
    public int[][] nearest(int[][] grid) {
        //Create a queue for storing all the current cells
        Queue<Node> q = new LinkedList<>();

        //direction
        int[] drows = {-1, 0, +1, 0};
        int[] dcols = {0, +1, 0, -1};

        //rows and columns of the given grid
        int r = grid.length;
        int c = grid[0].length;

        //create a visisted array
        int[][] vis = new int[r][c];
        //create a new resultant array
        int[][] result = new int[r][c];

        for (int i = 0; i < r; i++) {
            Arrays.fill(vis[i], 0);
            for (int j = 0; j < c; j++) {
                if (grid[i][j] == 1) {
                    q.add(new Node(i, j, 0));
                    vis[i][j] = 1;
                } else {
                    vis[i][j] = 0;
                }
            }
        }

        while (!q.isEmpty()) {
            int cr = q.peek().row;
            int cc = q.peek().col;
            int cd = q.peek().distance;
            q.remove();
            result[cr][cc] = cd;

            for (int d = 0; d < 4; d++) {
                int nr = cr + drows[d];
                int nc = cc + dcols[d];

                if (nr >= 0 && nr < r && nc >= 0 && nc < c && vis[nr][nc] == 0) {
                    vis[nr][nc] = 1;
                    q.add(new Node(nr, nc, cd + 1));
                }
            }
        }

        return result;
    }
}
