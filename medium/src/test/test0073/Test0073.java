package test.test0073;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给定一个 m x n 的矩阵，
 * 如果一个元素为 0 ，则将其所在行和列的所有元素都设为 0 。
 * 请使用 原地 算法。
 * @author sxx_27
 * @create 2022-04-05 20:45
 */
public class Test0073 {

    public static void main(String[] args) {
        int[][] arr = {{1,1,1},{1,0,1},{1,1,1}};
        new Solution().setZeroes(arr);
        for (int[] a : arr)
        {
            System.out.println(Arrays.toString(a));
        }
    }
}
class Solution {
    public void setZeroes(int[][] matrix) {

        int r = matrix.length;
        int c = matrix[0].length;
        List<Integer> rlist = new ArrayList();
        List<Integer> clist = new ArrayList();
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (matrix[i][j] == 0) {
                    clist.add(j);
                    rlist.add(i);
                }
            }
        }
        for (int i = 0; i < clist.size(); i++) {
            for (int k = 0; k < r; k++) {
                matrix[k][clist.get(i)] = 0;
            }
            for (int k = 0; k < c; k++) {
                matrix[rlist.get(i)][k] = 0;
            }
        }
    }
}