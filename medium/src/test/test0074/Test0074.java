package test.test0074;

/**
 * 编写一个高效的算法来判断m x n矩阵中，
 * 是否存在一个目标值。该矩阵具有如下特性：
 * 每行中的整数从左到右按升序排列。
 * 每行的第一个整数大于前一行的最后一个整数。
 *
 * @author sxx_xwl
 * @version 1.0.0
 * @className test.test0074
 * @create 2022-09-04-20:03
 */
public class Test0074 {
    public static void main(String[] args) {

    }
}

class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int index = 0;
        for (int i = 0; i < matrix.length; i++) {
            if (matrix[i][matrix[0].length - 1] < target) {
                continue;
            } else {
                index = i;
                break;
            }
        }
        for (int i = 0; i < matrix[0].length; i++) {
            if (matrix[index][i] == target) {
                return true;
            } else if (matrix[index][i] > target) {
                return false;
            }
        }
        return false;
    }
}