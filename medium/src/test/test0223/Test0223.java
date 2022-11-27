package test.test0223;

/**
 * 给你 二维 平面上两个 由直线构成且边与坐标轴平行/垂直 的矩形，请你计算并返回两个矩形覆盖的总面积。
 * 每个矩形由其 左下 顶点和 右上 顶点坐标表示：
 * 第一个矩形由其左下顶点 (ax1, ay1) 和右上顶点 (ax2, ay2) 定义。
 * 第二个矩形由其左下顶点 (bx1, by1) 和右上顶点 (bx2, by2) 定义。
 * https://leetcode.cn/problems/rectangle-area/
 *
 * @author sxx_xwl
 * @version 1.0.0
 * @className test.test0223
 * @create 2022-11-27-11:11
 */
public class Test0223 {
    public static void main(String[] args) {

    }
}

class Solution {
    public int computeArea(int ax1, int ay1, int ax2, int ay2, int bx1, int by1, int bx2, int by2) {
        int l = Math.max(ax1, bx1), d = Math.max(ay1, by1);
        int r = Math.min(ax2, bx2), u = Math.min(ay2, by2);
        int res = (ax2 - ax1) * (ay2 - ay1) + (bx2 - bx1) * (by2 - by1);
        if (l < r && d < u) {
            return res - (r - l) * (u - d);
        } else {
            return res;
        }
    }
}
/**
 * ax1, ax2 大小未定的情况
 */
//class Solution {
//    public int computeArea(int ax1, int ay1, int ax2, int ay2, int bx1, int by1, int bx2, int by2) {
//        int res = Math.abs((ax1 - ax2) * (ay1 - ay2)) + Math.abs((bx1 - bx2) * (by1 - by2));
//        int x = getRange(ax1, ax2, bx1, bx2), y = getRange(ay1, ay2, by1, by2);
//        return res - x * y;
//    }
//
//    private boolean intoRange(int x, int a, int b) {
//        return x > Math.min(a, b) && x < Math.max(a, b);
//    }
//
//    private int getRange(int x1, int x2, int a, int b) {
//        int res = 0;
//        if (intoRange(x1, a, b) && intoRange(x2, a, b)) {
//            res = Math.abs(x1 - x2);
//        } else if (intoRange(x1, a, b)) {
//            if (x2 >= Math.max(a, b)) {
//                res = Math.max(a, b) - x1;
//            } else {
//                res = x1 - Math.min(a, b);
//            }
//        } else if (intoRange(x2, a, b)) {
//            if (x1 >= Math.max(a, b)) {
//                res = Math.max(a, b) - x2;
//            } else {
//                res = x2 - Math.min(a, b);
//            }
//        } else {
//            if (Math.min(x1, x2) <= Math.min(a, b) && Math.max(x1, x2) >= Math.max(a, b)) {
//                res = Math.abs(a - b);
//            }
//        }
//        return res;
//    }
//}