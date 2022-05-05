package test566;

import java.util.Arrays;

/**
 * 在 MATLAB 中，有一个非常有用的函数 reshape ，它可以将一个m x n 矩阵重塑为另一个大小不同（r x c）的新矩阵，但保留其原始数据。
 * 给你一个由二维数组 mat 表示的m x n 矩阵，以及两个正整数 r 和 c ，分别表示想要的重构的矩阵的行数和列数。
 * 重构后的矩阵需要将原始矩阵的所有元素以相同的 行遍历顺序 填充。
 * 如果具有给定参数的 reshape 操作是可行且合理的，则输出新的重塑矩阵；否则，输出原始矩阵。
 * @author sxx_27
 * @create 2022-04-05 19:33
 */
public class Test566 {

    public static void main(String[] args) {
        int mat[][] = {{1,2},{3,4}};
        int[][] ints = new Solution().matrixReshape(mat, 1, 4);
        for (int[] a : ints)
        {
            System.out.println(Arrays.toString(a));
        }

    }
}
class Solution {
    public int[][] matrixReshape(int[][] mat, int r, int c) {
        int row = mat.length;
        int cul = mat[0].length;
        if (row * cul != r * c)
        {
            return mat;
        }
        int res[][] = new int[r][c];
        for (int i = 0; i < r * c; i++) {
            res[i / c][i % c] = mat[i / cul][i % cul];
        }
        return res;
    }
    public int[][] matrixReshape0(int[][] mat, int r, int c) {
        int row = mat.length;
        int cul = mat[0].length;
        if (row * cul != r * c)
        {
            return mat;
        }
        int res[][] = new int[r][c];
        int r1 = 0 , r2 = 0 , c1 = 0 , c2 = 0;
        while (true)
        {
            if (r1 == r - 1 && c1 == c)
            {
                break;
            }
            if (c1 == c)
            {
                r1++;
                c1 = 0;
            }
            if (c2 == cul)
            {
                c2 = 0;
                r2++;
            }
            res[r1][c1++] = mat[r2][c2++];
        }
        return res;
    }
}