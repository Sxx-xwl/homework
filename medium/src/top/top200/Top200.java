package top.top200;

import java.util.TreeMap;

/**
 * 给你一个由'1'（陆地）和 '0'（水）组成的的二维网格，
 * 请你计算网格中岛屿的数量。
 * 岛屿总是被水包围，
 * 并且每座岛屿只能由水平方向和/或竖直方向上相邻的陆地连接形成。
 * 此外，
 * 你可以假设该网格的四条边均被水包围。
 *
 * @Classname Top200
 * @Version 1.0.0
 * @Date 2022/7/20 13:00
 * @Created by sxx_xwl
 */
public class Top200 {
    public static void main(String[] args) {
        char[][] gird = {{'1','1','1','1','0'},{'1','1','0','1','0'},{'1','1','0','0','0'},{'0','0','0','0','0'}};
        System.out.println(new Solution().numIslands(gird));
    }
}

class Solution {
    int count = 0;

    public int numIslands(char[][] grid) {
        int rowLen = grid.length;
        int cloLen = grid[0].length;
        for (int i = 0; i < rowLen; i++) {
            for (int j = 0; j < cloLen; j++) {
                if (grid[i][j] == '1') {
                    count++;
                    search(grid, i, j);
                    grid[i][j] = '0';
                }
            }
        }
        return count;
    }

    private void search(char[][] grid, int row, int clo) {
        int rowLen = grid.length;
        int cloLen = grid[0].length;
        if (clo < 0 || clo >= cloLen || row < 0 || row >= rowLen) {
            return;
        }
        if (grid[row][clo] == '0') {
            return;
        }
        grid[row][clo] = '0';
        search(grid, row + 1, clo);
        search(grid, row - 1, clo);
        search(grid, row, clo + 1);
        search(grid, row, clo - 1);
    }
}