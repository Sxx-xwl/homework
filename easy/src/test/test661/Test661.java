package test.test661;

import java.util.Arrays;

/**
 * 图像平滑器 是大小为3 x 3 的过滤器，用于对图像的每个单元格平滑处理，平滑处理后单元格的值为该单元格的平均灰度。
 * 每个单元格的平均灰度 定义为：该单元格自身及其周围的 8 个单元格的平均值，结果需向下取整。（即，需要计算蓝色平滑器中 9 个单元格的平均值）。
 * 如果一个单元格周围存在单元格缺失的情况，则计算平均灰度时不考虑缺失的单元格（即，需要计算红色平滑器中 4 个单元格的平均值）。
 *
 * @author sxx_27
 * @create 2022-03-24 15:45
 */
public class Test661 {

    public static void main(String[] args) {

        Solution s = new Solution();
        int[][] arr = {{100, 200, 100}, {200, 50, 200}, {100, 200, 100}};
        int[][] ints = s.imageSmoother(arr);
        for (int i = 0; i < ints.length; i++) {
            System.out.println(Arrays.toString(ints[i]));
        }

    }

}

class Solution {
    public int[][] imageSmoother(int[][] img) {

        int row = img.length;
        int col = img[0].length;
        int sum = 0;
        int num = 0;

        if (row == 1 && col == 1) {
            return img;
        }

        int[][] sl = new int[row][col];
        for (int i = 0; i < row; i++) {

            for (int j = 0; j < col; j++) {

                for (int h = i - 1; h < i + 2; h++) {
                    if (h >= 0 && h <= row - 1) {
                        for (int k = j - 1; k < j + 2; k++) {
                            if (k >= 0 && k <= col - 1) {
                                sum += img[h][k];
                                num++;
                            }
                        }
                    }
                }
                sl[i][j] = sum / num;

            }
        }
        return sl;
    }
}