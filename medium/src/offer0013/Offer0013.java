package offer0013;

import java.util.ArrayList;

/**
 * 地上有一个m行n列的方格，从坐标 [0,0] 到坐标 [m-1,n-1] 。
 * 一个机器人从坐标 [0, 0] 的格子开始移动，
 * 它每次可以向左、右、上、下移动一格（不能移动到方格外），
 * 也不能进入行坐标和列坐标的数位之和大于k的格子。
 * 例如，当k为18时，机器人能够进入方格 [35, 37] ，
 * 因为3+5+3+7=18。但它不能进入方格 [35, 38]，
 * 因为3+5+3+8=19。请问该机器人能够到达多少个格子？
 *
 * @author sxx_27
 * @create 2022-05-13 13:22
 */
public class Offer0013 {
    public static void main(String[] args) {

        System.out.println(new Solution().movingCount(16, 8, 4));

    }
}

class Solution {
    int res = 0;
    boolean[][] list;

    public int movingCount(int m, int n, int k) {
        list = new boolean[m][n];
        search(m, n, k, 0, 0);
        return res;
    }

    private void search(int m, int n, int k, int i, int j) {
        if (i < 0 || i >= m || j < 0 || j >= n ||(i % 10 + i / 10 + j % 10 + j / 10) > k|| list[i][j]) {
            return;
        }
        list[i][j] = true;
        res++;
        search(m, n, k, i + 1, j);
        search(m, n, k, i - 1, j);
        search(m, n, k, i, j + 1);
        search(m, n, k, i, j - 1);
        return;
    }
}