package top.top054;

import java.util.ArrayList;
import java.util.List;

/**
 * 给你一个 m 行 n 列的矩阵 matrix ，
 * 请按照 顺时针螺旋顺序 ，返回矩阵中的所有元素。
 *
 * @Classname Top054
 * @Version 1.0.0
 * @Date 2022/7/4 10:50
 * @Created by sxx_xwl
 */
public class Top054 {
    public static void main(String[] args) {
        int[][] matrix = {{1, 2, 3}, {4, 5, 6,}, {7, 8, 9}};
        System.out.println(new Solution().spiralOrder(matrix));
    }
}

class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        int row = 0, clo = 0, times = 0;
        while (res.size() < matrix.length * matrix[0].length) {
            while (clo < matrix[0].length - times&&res.size() < matrix.length * matrix[0].length) {
                res.add(matrix[row][clo++]);
            }
            clo--;
            while (++row < matrix.length - times&&res.size() < matrix.length * matrix[0].length) {
                res.add(matrix[row][clo]);
            }
            row--;
            while (--clo >= times&&res.size() < matrix.length * matrix[0].length) {
                res.add(matrix[row][clo]);
            }
            clo++;
            times++;
            while (--row >= times&&res.size() < matrix.length * matrix[0].length) {
                res.add(matrix[row][clo]);
            }
            row++;
            clo++;
        }
        return res;
    }
}