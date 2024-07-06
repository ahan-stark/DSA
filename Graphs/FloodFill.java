// You are also given three integers sr, sc, and color. You should perform a flood fill on the image starting from the pixel image[sr][sc].

// To perform a flood fill, consider the starting pixel, plus any pixels connected 4-directionally to the starting pixel of the same color as the starting pixel, plus any pixels connected 4-directionally to those pixels (also with the same color), and so on. Replace the color of all of the aforementioned pixels with color.

// Return the modified image after performing the flood fill.

public class FloodFill {
    public static void main(String[] args) {
        int[][] image = { { 1, 1, 1 }, { 1, 1, 0 }, { 1, 0, 1 } };
        int sr = 1, sc = 1, color = 2;
        Solution solution = new Solution();
        int[][] newImg = solution.getFloodFillImg(image, sr, sc, color);
        for (int i = 0; i < newImg.length; i++) {
            for (int j = 0; j < newImg[0].length; j++) {
                System.out.print(newImg[i][j]);
            }
            System.out.println();
        }

    }

    private static class Solution {
        private int[][] getFloodFillImg(int[][] image, int sr, int sc, int color) {
            int vis[][] = new int[image.length][image[0].length];
            for (int i = 0; i < image.length; i++) {
                for (int j = 0; j < image[0].length; j++) {
                    vis[i][j] = image[i][j];
                }
            }
            int colorToChnage = image[sr][sc];
            floodFill(image, vis, sr, sc, colorToChnage, color);
            return vis;
        }

        private void floodFill(int[][] image, int[][] vis, int sr, int sc, int colorToChange, int color) {
            if (sr < 0 || sr >= image.length || sc < 0 || sc >= image[0].length || vis[sr][sc] == color
                    || image[sr][sc] != colorToChange) {
                return;
            }

            vis[sr][sc] = color;
            floodFill(image, vis, sr - 1, sc, colorToChange, color);
            floodFill(image, vis, sr + 1, sc, colorToChange, color);
            floodFill(image, vis, sr, sc - 1, colorToChange, color);
            floodFill(image, vis, sr, sc + 1, colorToChange, color);
        }
    }
}

// similar to finding number of islands.. take the initial sr,sc and that elem
// present should be modifies to given color in entire image... so take the row
// & col and do complete dfs and start changing the color. chnage it in all 4
// directions

//modify the visited array and make the changing of color in there...

//This is also kind of connected components
//In this both DFS and BFS can be applied