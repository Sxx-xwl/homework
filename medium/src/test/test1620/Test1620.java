package test.test1620;

/**
 * 给你一个数组 towers和一个整数 radius 。
 * 数组 towers 中包含一些网络信号塔，
 * 其中towers[i] = [xi, yi, qi]表示第i个网络信号塔的坐标是(xi, yi)且信号强度参数为qi。
 * 所有坐标都是在 X-Y 坐标系内的整数坐标。两个坐标之间的距离用 欧几里得距离计算。
 * 整数radius表示一个塔 能到达的 最远距离。
 * 如果一个坐标跟塔的距离在 radius以内，
 * 那么该塔的信号可以到达该坐标。在这个范围以外信号会很微弱，
 * 所以 radius以外的距离该塔是 不能到达的。
 * 如果第 i个塔能到达 (x, y)，那么该塔在此处的信号为⌊qi / (1 + d)⌋，其中d是塔跟此坐标的距离。
 * 一个坐标的 信号强度 是所有 能到达该坐标的塔的信号强度之和。
 * 请你返回数组 [cx, cy] ，表示 信号强度 最大的 整数 坐标点(cx, cy) 。
 * 如果有多个坐标网络信号一样大，请你返回字典序最小的 非负 坐标。
 * 注意：
 * 坐标(x1, y1)字典序比另一个坐标(x2, y2) 小，需满足以下条件之一：
 * 要么x1 < x2，
 * 要么x1 == x2 且y1 < y2。
 * ⌊val⌋表示小于等于val的最大整数（向下取整函数）。
 *
 * @author sxx_xwl
 * @version 1.0.0
 * @className test.test1620
 * @create 2022-11-02-13:12
 */
public class Test1620 {
    public static void main(String[] args) {

    }
}

class Solution {
    public int[] bestCoordinate(int[][] towers, int radius) {
        int x = 0, y = 0, val = 0;
        int[][] g = new int[51][51];
        for (int[] tower : towers) {
            int a = tower[0], b = tower[1], c = tower[2];
            for (int i = Math.max(0, a - radius); i <= a + radius && i < 51; i++) {
                for (int j = Math.max(0, b - radius); j <= b + radius && j < 51; j++) {
                    double temp = Math.sqrt((a - i) * (a - i) + (b - j) * (b - j));
                    if (temp > radius) continue;
                    g[i][j] += Math.floor(c / (1 + temp));
                    if (g[i][j] > val) {
                        val = g[i][j];
                        x = i;
                        y = j;
                    } else if (g[i][j] == val && (i < x || (i == x && j < y))) {
                        x = i;
                        y = j;
                    }
                }
            }
        }
        return new int[]{x, y};
    }
}