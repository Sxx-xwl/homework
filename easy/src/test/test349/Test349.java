package test.test349;

import java.util.*;

/**
 * 给定两个数组 nums1 和 nums2 ，返回 它们的交集 。
 * 输出结果中的每个元素一定是 唯一 的。我们可以 不考虑输出结果的顺序 。
 *
 * @author sxx_xwl
 * @version 1.0.0
 * @className test.test349
 * @create 2022-11-04-17:02
 */
public class Test349 {
    public static void main(String[] args) {

    }
}

class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set = new HashSet<>();
        int[] map = new int[1001];
        for (int num : nums1) {
            map[num]++;
        }
        for (int num : nums2) {
            if (map[num] > 0) {
                set.add(num);
            }
        }
        int[] res = new int[set.size()];
        int index = 0;
        for (int temp : set) {
            res[index++] = temp;
        }
        return res;
    }
}
