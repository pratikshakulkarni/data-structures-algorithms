package graphs;

/***
 @author: Pratiksha Kulkarni
 date: 9/21/2022
 */
public class ReplaceOwithX {
    private static void dfs(int r, int c, int[][] vis, char[][] a, int[] drow, int[] dcol) {
        vis[r][c] = 1;
        for (int d = 0; d < 4; d++) {
            int nr = r + drow[d];
            int nc = c + dcol[d];
            if (nr >= 0 && nr < a.length && nc >= 0 && nc < a[0].length && vis[nr][nc] == 0 && a[nr][nc] == 'O') {
                dfs(nr, nc, vis, a, drow, dcol);
            }
        }

    }

    static char[][] fill(int n, int m, char a[][]) {
        int r = a.length;
        int c = a[0].length;
        int vis[][] = new int[r][c];
        int[] drow = {-1, 0, +1, 0};
        int[] dcol = {0, +1, 0, -1};

        //get all O's on the boundary as visited and do not replace them
        for (int i = 0; i < c; i++) {
            //1st row i.e. r=0 and i changes
            if (vis[0][i] == 0 && a[0][i] == 'O')
                dfs(0, i, vis, a, drow, dcol);

            //last row i.e. r-1 and i changes
            if (vis[r - 1][i] == 0 && a[r - 1][i] == 'O')
                dfs(r - 1, i, vis, a, drow, dcol);
        }

        for (int i = 0; i < r; i++) {
            //first colomn i.e. i changes and c=0;
            if (vis[i][0] == 0 && a[i][0] == 'O')
                dfs(i, 0, vis, a, drow, dcol);

            //last colomn i.e. i changes and c-1;
            if (vis[i][c - 1] == 0 && a[i][c - 1] == 'O')
                dfs(i, c - 1, vis, a, drow, dcol);
        }

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (vis[i][j] == 0 && a[i][j] == 'O') {
                    a[i][j] = 'X';
                }
            }
        }
        return a;
    }
}
