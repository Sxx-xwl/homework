package top.top240;

/**
 * 编写一个高效的算法来搜索mxn矩阵 matrix 中的一个目标值 target 。
 * 该矩阵具有以下特性：
 * 每行的元素从左到右升序排列。
 * 每列的元素从上到下升序排列。
 *
 * @author sxx_xwl
 * @version 1.0.0
 * @className top.top240
 * @create 2022-09-04-20:18
 */
public class Top240 {
    public static void main(String[] args) {

    }
}

class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int row = matrix.length - 1;
        int col = 0;
        while (col < matrix[0].length && row >= 0) {
            if (matrix[row][col] < target) {
                col++;
            } else if (matrix[row][col] > target) {
                row--;
            } else {
                return true;
            }
        }
        return false;
    }
}