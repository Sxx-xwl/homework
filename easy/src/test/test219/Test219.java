package test.test219;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 给你一个整数数组nums 和一个整数k ，
 * 判断数组中是否存在两个 不同的索引i和j ，
 * 满足 nums[i] == nums[j] 且 abs(i - j) <= k 。
 * 如果存在，返回 true ；否则，返回 false 。
 *
 * @author sxx_xwl
 * @version 1.0.0
 * @className test.test219
 * @create 2022-10-23-16:20
 */
public class Test219 {
    public static void main(String[] args) {

    }
}

class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (i > k) {
                set.remove(nums[i - k - 1]);
            }
            if (!set.add(nums[i])){
                return true;
            }
        }
        return false;
    }
}