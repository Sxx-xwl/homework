package test.test1472;

import java.util.HashMap;
import java.util.Map;

/**
 * 你在一家生产小球的玩具厂工作，有 n 个小球，编号从 lowLimit 开始，到 highLimit 结束（包括 lowLimit 和 highLimit ，
 * 即 n == highLimit - lowLimit + 1）。另有无限数量的盒子，编号从 1 到 infinity 。
 * 你的工作是将每个小球放入盒子中，其中盒子的编号应当等于小球编号上每位数字的和。
 * 例如，编号 321 的小球应当放入编号 3 + 2 + 1 = 6 的盒子，而编号 10 的小球应当放入编号 1 + 0 = 1 的盒子。
 * 给你两个整数 lowLimit 和 highLimit ，返回放有最多小球的盒子中的小球数量。如果有多个盒子都满足放有最多小球，只需返回其中任一盒子的小球数量。
 * https://leetcode.cn/problems/maximum-number-of-balls-in-a-box/
 *
 * @author sxx_xwl
 * @version 1.0.0
 * @className test.test1472
 * @create 2022-11-23-15:09
 */
public class Test1472 {
    public static void main(String[] args) {

    }
}

class Solution {
    public int countBalls(int lowLimit, int highLimit) {
        int[] arr = new int[46];
        int res = 0;
        while (lowLimit <= highLimit) {
            int sum = 0, temp = lowLimit;
            while (temp != 0) {
                sum += temp % 10;
                temp /= 10;
            }
            arr[sum]++;
            lowLimit++;
            res = Math.max(arr[sum], res);
        }
        return res;
    }
}