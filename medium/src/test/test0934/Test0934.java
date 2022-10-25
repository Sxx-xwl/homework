package test.test0934;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 给你一个大小为 n x n 的二元矩阵 grid ，其中 1 表示陆地，0 表示水域。
 * 岛 是由四面相连的 1 形成的一个最大组，即不会与非组内的任何其他 1 相连。grid 中 恰好存在两座岛 。
 * 你可以将任意数量的 0 变为 1 ，以使两座岛连接起来，变成 一座岛 。
 * 返回必须翻转的 0 的最小数目。
 *
 * @author sxx_xwl
 * @version 1.0.0
 * @className test.test0934
 * @create 2022-10-25-10:14
 */
public class Test0934 {
    public static void main(String[] args) {
        int[][] grid = {{0, 1, 0, 0, 0}, {0, 1, 0, 1, 1}, {0, 0, 0, 0, 1}, {0, 0, 0, 0, 0}, {0, 0, 0, 0, 0}};
        System.out.println(new Solution().shortestBridge(grid));
    }
}

class Solution {
    private int[][] grid, coordinates = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}}; // 上、下、右、左四个方向
    private Deque<int[]> edges; // 用户存储边缘格子

    public int shortestBridge(int[][] grid) {
        int res = 0;
        boolean findIsLand = false;
        this.grid = grid;
        edges = new LinkedList<>();
        /** 步骤1：为其中一个岛屿打标记（val=2），并保存”边界格子“到edges中 */
        for (int i = 0; !findIsLand && i < grid.length; i++) {
            for (int j = 0; !findIsLand && j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    dfs(i, j);
                    findIsLand = true;
                }
            }
        }
        /** 步骤2：利用边界edges，一层一层扩展岛屿（val=2），直到遇到另一个岛屿（val=1）*/
        while (!edges.isEmpty()) {
            res++;
            int size = edges.size();
            for (int i = 0; i < size; i++) {
                int[] cur = edges.removeFirst();
                for (int[] temp : coordinates) {
                    int newX = temp[0] + cur[0];
                    int newY = temp[1] + cur[1];
                    if (!isBinary(newX, newY) && grid[newX][newY] == 1) {
                        return res;
                    } else if (!isBinary(newX, newY) && grid[newX][newY] == 0) {
                        grid[newX][newY] = 2;
                        edges.add(new int[]{newX, newY});
                    }
                }
            }
        }
        return res;
    }

    private void dfs(int i, int j) {
        if (isBinary(i, j) || grid[i][j] == 2) {
            return;
        }
        if (grid[i][j] == 0) {
            grid[i][j] = 2;
            edges.add(new int[]{i, j});
            return;
        }
        grid[i][j] = 2;
        for (int[] temp : coordinates) {
            dfs(i + temp[0], j + temp[1]);
        }
    }

    private boolean isBinary(int i, int j) {
        return i < 0 || j < 0 || i >= grid.length || j >= grid[0].length;
    }
}
