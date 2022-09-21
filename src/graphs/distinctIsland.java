package graphs;

import java.util.ArrayList;
import java.util.HashSet;

/***
 @author: Pratiksha Kulkarni
 date: 9/22/2022
 */
public class distinctIsland {
    private static String toString(int r, int c) {
        String a = Integer.toString(r) + " " + Integer.toString(c);
        return a;
    }

    private void dfs(int r, int c, int[][] vis, int[][] grid, int r0, int c0, ArrayList<String> list) {
        int[] drow = {-1, 0, +1, 0};
        int[] dcol = {0, -1, 0, +1};
        int m = grid.length;
        int n = grid[0].length;
        vis[r][c] = 1;
        list.add(toString(r - r0, c - c0));
        for (int d = 0; d < 4; d++) {
            int nr = r + drow[d];
            int nc = c + dcol[d];
            if (nr >= 0 && nr < m && nc >= 0 && nc < n && vis[nr][nc] == 0 && grid[nr][nc] == 1) {
                dfs(nr, nc, vis, grid, r0, c0, list);
            }
        }
    }

    int countDistinctIslands(int[][] grid) {
        int r = grid.length;
        int c = grid[0].length;
        int[][] vis = new int[r][c];
        HashSet<ArrayList<String>> set = new HashSet<>();
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (vis[i][j] == 0 && grid[i][j] == 1) {
                    ArrayList<String> list = new ArrayList<>();
                    dfs(i, j, vis, grid, i, j, list);
                    set.add(list);
                }
            }
        }
        return set.size();
    }
}
