package test.test0769;

import java.util.Stack;

/**
 * 给定一个长度为 n 的整数数组 arr ，
 * 它表示在 [0, n - 1] 范围内的整数的排列。
 * 我们将 arr 分割成若干 块 (即分区)，
 * 并对每个块单独排序。将它们连接起来后，
 * 使得连接的结果和按升序排序后的原数组相同。
 * 返回数组能分成的最多块数量
 *
 * @author sxx_xwl
 * @version 1.0.0
 * @className test.test0769
 * @create 2022-10-13-10:56
 */
public class Test0769 {
    public static void main(String[] args) {

    }
}

class Solution {
    public int maxChunksToSorted(int[] arr) {
        int max = -1, count = 0;
        for (int i = 0; i < arr.length; i++) {
            max = Math.max(arr[i], max);
            if (max == i) count++;
        }
        return count;
    }
}