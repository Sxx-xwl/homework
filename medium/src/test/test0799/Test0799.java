package test.test0799;

/**
 * 我们把玻璃杯摆成金字塔的形状，其中 第一层 有 1 个玻璃杯，
 * 第二层 有 2 个，依次类推到第 100 层，每个玻璃杯 (250ml) 将盛有香槟。
 * 从顶层的第一个玻璃杯开始倾倒一些香槟，当顶层的杯子满了，
 * 任何溢出的香槟都会立刻等流量的流向左右两侧的玻璃杯。
 * 当左右两边的杯子也满了，就会等流量的流向它们左右两边的杯子，
 * 依次类推。（当最底层的玻璃杯满了，香槟会流到地板上）
 * 例如，在倾倒一杯香槟后，最顶层的玻璃杯满了。
 * 倾倒了两杯香槟后，第二层的两个玻璃杯各自盛放一半的香槟。
 * 在倒三杯香槟后，第二层的香槟满了 - 此时总共有三个满的玻璃杯。
 * 在倒第四杯后，第三层中间的玻璃杯盛放了一半的香槟，
 * 他两边的玻璃杯各自盛放了四分之一的香槟，如下图所示。
 * 现在当倾倒了非负整数杯香槟后，
 * 返回第 i 行 j 个玻璃杯所盛放的香槟占玻璃杯容积的比例（ i 和 j 都从0开始）。
 * https://leetcode.cn/problems/champagne-tower/
 *
 * @author sxx_xwl
 * @version 1.0.0
 * @className test.test0799
 * @create 2022-11-20-14:55
 */
public class Test0799 {
    public static void main(String[] args) {

    }
}

class Solution {
    public double champagneTower(int poured, int query_row, int query_glass) {
        if (query_row * query_row <= poured) {
            return 1.0;
        }
        double[][] res = new double[101][101];
        res[0][0] = poured;
        for (int i = 0; i <= query_row; i++) {
            for (int j = 0; j <= i; j++) {
                if (res[i][j] > 1) {
                    double remain = res[i][j] - 1;
                    res[i][j] = 1;
                    res[i + 1][j] = remain / 2;
                    res[i + 1][j + 1] = remain / 2;
                }
            }
        }
        return res[query_row][query_glass];
    }
}