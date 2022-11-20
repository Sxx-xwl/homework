package test.test1732;

/**
 * 有一个自行车手打算进行一场公路骑行，
 * 这条路线总共由 n + 1 个不同海拔的点组成。
 * 自行车手从海拔为 0 的点 0 开始骑行。
 * 给你一个长度为 n 的整数数组 gain ，
 * 其中 gain[i] 是点 i 和点 i + 1 的 净海拔高度差（0 <= i < n）。
 * 请你返回 最高点的海拔 。
 * https://leetcode.cn/problems/find-the-highest-altitude/
 *
 * @author sxx_xwl
 * @version 1.0.0
 * @className test.test1732
 * @create 2022-11-19-11:20
 */
public class Test1732 {
    public static void main(String[] args) {

    }
}

class Solution {
    public int largestAltitude(int[] gain) {
        int max = 0, res = 0;
        for (int i = 0; i < gain.length; i++) {
            max += gain[i];
            res = Math.max(max, res);
        }
        return res;
    }
}