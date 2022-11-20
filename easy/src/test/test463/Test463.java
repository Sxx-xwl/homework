package test.test463;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 给定一个 row x col 的二维网格地图 grid ，
 * 其中：grid[i][j] = 1 表示陆地， grid[i][j] = 0 表示水域。
 * 网格中的格子 水平和垂直 方向相连（对角线方向不相连）。
 * 整个网格被水完全包围，但其中恰好有一个岛屿（或者说，
 * 一个或多个表示陆地的格子相连组成的岛屿）。
 * 岛屿中没有“湖”（“湖” 指水域在岛屿内部且不和岛屿周围的水相连）。
 * 格子是边长为 1 的正方形。网格为长方形，且宽度和高度均不超过 100 。
 * 计算这个岛屿的周长。
 * https://leetcode.cn/problems/island-perimeter/
 *
 * @author sxx_xwl
 * @version 1.0.0
 * @className test.test463
 * @create 2022-11-20-11:00
 */
public class Test463 {
    public static void main(String[] args) {
        int[][] grid = {{0, 1, 0, 0}, {1, 1, 1, 0}, {0, 1, 0, 0}, {1, 1, 0, 0}};
        int[][] grid2 = {{1, 1}, {1, 1}};
        System.out.println(new Solution().islandPerimeter(grid2));
    }
}

class Solution {
    public int islandPerimeter(int[][] grid) {
        //存储上一行的数组
        int[] arr = new int[grid[0].length];
        int res = 0;
        for (int[] row : grid) {
            //遍历当前行
            for (int i = 0; i < row.length; i++) {
                if (row[i] == 1) {
                    //如果当前格子为陆地，周长+4
                    res += 4;
                    //检查同列上一行是否是陆地 是的话 减去重复边
                    res -= arr[i] * 2;
                    //如果该格子不是边界格子则检查前一个格子是否是陆地
                    if (i > 0) {
                        res -= row[i - 1] * 2;
                    }
                }
            }
            arr = row;
        }
        return res;
    }
}