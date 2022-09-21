package graphs;

/***
 @author: Pratiksha Kulkarni
 date: 9/21/2022
 */
public class numberOfEnclave {
    private void dfs(int r, int c, int[][] vis, int[][] grid, int[] drow, int[] dcol) {
        int m = grid.length;
        int n = grid[0].length;
        vis[r][c] = 1;

        for (int d = 0; d < 4; d++) {
            int nr = r + drow[d];
            int nc = c + dcol[d];

            if (nr > 0 && nr < m && nc > 0 && nc < n && vis[nr][nc] == 0 && grid[nr][nc] == 1) {
                dfs(nr, nc, vis, grid, drow, dcol);
            }
        }
    }

    int numberOfEnclaves(int[][] grid) {
        //0 sea and 1 land
        int r = grid.length;
        int c = grid[0].length;
        int[][] vis = new int[r][c];
        int enclaves = 0;
        int[] drow = {-1, 0, +1, 0};
        int[] dcol = {0, +1, 0, -1};

        //get all the lands on grid boundry visited
        for (int i = 0; i < c; i++) {
            if (vis[0][i] == 0 && grid[0][i] == 1)
                dfs(0, i, vis, grid, drow, dcol);

            if (vis[r - 1][i] == 0 && grid[r - 1][i] == 1)
                dfs(r - 1, i, vis, grid, drow, dcol);
        }

        for (int i = 0; i < r; i++) {
            if (vis[i][0] == 0 && grid[i][0] == 1)
                dfs(i, 0, vis, grid, drow, dcol);

            if (vis[i][c - 1] == 0 && grid[i][c - 1] == 1)
                dfs(i, c - 1, vis, grid, drow, dcol);
        }

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (vis[i][j] == 0 && grid[i][j] == 1) {
                    enclaves++;
                }
            }
        }
        return enclaves;
    }
}
