package graphs;

/***
 @author: Pratiksha Kulkarni
 date: 9/21/2022
 */
public class FloodFill {
    private void dfs(int[][] image, int sr, int sc, int newColor, int[] drows, int[] dcols, int inColor, int[][] newImage) {
        newImage[sr][sc] = newColor;

        //4 colors
        for (int i = 0; i < 4; i++) {
            int nrow = sr + drows[i];
            int ncol = sc + dcols[i];

            if (nrow >= 0 && nrow < image.length && ncol >= 0 && ncol < image[0].length && image[nrow][ncol] == inColor &&
                    newImage[nrow][ncol] != newColor) {
                dfs(image, nrow, ncol, newColor, drows, dcols, inColor, newImage);
            }
        }
    }

    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        //get the initial color
        int inColor = image[sr][sc];

        int[][] newImage = image;

        //row changes upwards and downwards 4 directions = up,right,down,left
        int[] drows = {-1, 0, +1, 0};
        int[] dcols = {0, +1, 0, -1};

        //call dfs
        dfs(image, sr, sc, newColor, drows, dcols, inColor, newImage);
        return newImage;
    }
}
