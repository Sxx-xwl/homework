package test.test1779;

/**
 * 给你两个整数 x 和 y ，表示你在一个笛卡尔坐标系下的 (x, y) 处。
 * 同时，在同一个坐标系下给你一个数组 points ，其中 points[i] = [ai, bi] 表示在 (ai, bi) 处有一个点。
 * 当一个点与你所在的位置有相同的 x 坐标或者相同的 y 坐标时，我们称这个点是 有效的 。
 * 请返回距离你当前位置 曼哈顿距离 最近的 有效 点的下标（下标从 0 开始）。
 * 如果有多个最近的有效点，请返回下标 最小 的一个。如果没有有效点，请返回 -1 。
 * 两个点 (x1, y1) 和 (x2, y2) 之间的 曼哈顿距离 为 abs(x1 - x2) + abs(y1 - y2) 。
 * https://leetcode.cn/problems/find-nearest-point-that-has-the-same-x-or-y-coordinate/description/
 *
 * @author sxx_xwl
 * @version 1.0.0
 * @className test.test1779
 * @create 2022-12-01-11:09
 */
public class Test1779 {
    public static void main(String[] args) {

    }
}

class Solution {
    public int nearestValidPoint(int x, int y, int[][] points) {
        int res = Integer.MAX_VALUE, min = Integer.MAX_VALUE;
        for (int i = 0; i < points.length; i++) {
            if (x == points[i][0] || y == points[i][1]) {
                int sum = Math.abs(points[i][0] - x) + Math.abs(points[i][1] - y);
                if (sum < min) {
                    min = sum;
                    res = i;
                }
            }
        }
        return res == Integer.MAX_VALUE ? -1 : res;
    }
}