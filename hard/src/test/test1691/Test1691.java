package test.test1691;

import java.util.Arrays;

/**
 * 给你 n 个长方体 cuboids ，
 * 其中第 i 个长方体的长宽高表示为 cuboids[i] = [widthi, lengthi, heighti]（下标从 0 开始）。
 * 请你从 cuboids 选出一个 子集 ，并将它们堆叠起来。
 * 如果 widthi <= widthj 且 lengthi <= lengthj 且 heighti <= heightj ，
 * 你就可以将长方体 i 堆叠在长方体 j 上。你可以通过旋转把长方体的长宽高重新排列，以将它放在另一个长方体上。
 * 返回 堆叠长方体 cuboids 可以得到的 最大高度 。
 * https://leetcode.cn/problems/maximum-height-by-stacking-cuboids/description/
 *
 * @author sxx_xwl
 * @version 1.0.0
 * @className test.test1691
 * @create 2022-12-10-14:57
 */
public class Test1691 {
    public static void main(String[] args) {

    }
}

class Solution {
    public int maxHeight(int[][] cuboids) {
        for (int[] c : cuboids) {
            Arrays.sort(c);
        }
        Arrays.sort(cuboids, (a, b) -> a[0] != b[0] ?
                a[0] - b[0] :
                a[1] != b[1] ? a[1] - b[1] :
                        a[2] - b[2]);
        int ans = 0, n = cuboids.length;
        int[] f = new int[n];
        for (int i = 0; i < n; ++i) {
            // 排序后，cuboids[j][0] <= cuboids[i][0] 恒成立
            for (int j = 0; j < i; ++j) {
                if (cuboids[j][1] <= cuboids[i][1] && cuboids[j][2] <= cuboids[i][2]) {
                    // cuboids[j] 可以堆在 cuboids[i] 上
                    f[i] = Math.max(f[i], f[j]);
                }
            }
            f[i] += cuboids[i][2];
            ans = Math.max(ans, f[i]);
        }
        return ans;
    }
}