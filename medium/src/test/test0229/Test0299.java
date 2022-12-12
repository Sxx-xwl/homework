package test.test0229;

import java.util.*;

/**
 * 给定一个大小为 n 的整数数组，找出其中所有出现超过 ⌊ n/3 ⌋ 次的元素。
 * https://leetcode.cn/problems/majority-element-ii/
 *
 * @author sxx_xwl
 * @version 1.0.0
 * @className test.test0229
 * @create 2022-12-12-16:14
 */
public class Test0299 {
    public static void main(String[] args) {

    }
}

class Solution {
    public List<Integer> majorityElement(int[] nums) {
        int a = 0, b = 0, aa = 0, bb = 0, len = nums.length / 3;
        List<Integer> res = new ArrayList<>();
        for (int temp : nums) {
            if (a == temp) aa++;
            else if (b == temp) bb++;
            else {
                if (aa == 0) {
                    aa++;
                    a = temp;
                } else if (bb == 0) {
                    bb++;
                    b = temp;
                } else {
                    bb--;
                    aa--;
                }
            }
        }
        aa = 0;
        bb = 0;
        for (int num : nums) {
            if (a == num) aa++;
            else if (b == num) bb++;
        }
        if (aa > len) res.add(a);
        if (bb > len) res.add(b);
        return res;
    }
}