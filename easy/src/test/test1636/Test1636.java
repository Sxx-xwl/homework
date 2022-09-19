package test.test1636;

import java.util.*;

/**
 * 给你一个整数数组 nums ，
 * 请你将数组按照每个值的频率 升序 排序。
 * 如果有多个值的频率相同，请你按照数值本身将它们 降序 排序。
 * 请你返回排序后的数组。
 *
 * @author sxx_xwl
 * @version 1.0.0
 * @className test.test1636
 * @create 2022-09-19-23:54
 */
public class Test1636 {
    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3, -1, -2, -3, -3, 2};
        int[] ints = new Solution().frequencySort1(nums);
        System.out.println(Arrays.toString(ints));
    }
}

class Solution {
    public int[] frequencySort1(int[] nums) {
        // 根据范围，把所有值都➕100，转换到正数区间
        int[] cnt = new int[210];
        for (int n : nums) {
            cnt[n + 100]++;
        }
        for (int i = 0; i < nums.length; i++) {
            // 10000 ✖️ 权重 ➕ 取反后的结果
            nums[i] = 10000 * cnt[nums[i] + 100] + (100 - nums[i]);
        }
        // 排序
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            // 取模后再次取反即可还原
            nums[i] = 100 - nums[i] % 10000;
        }
        return nums;
    }


    public int[] frequencySort(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            list.add(nums[i]);
            if (!map.containsKey(nums[i])) {
                map.put(nums[i], 1);
            } else {
                map.put(nums[i], map.get(nums[i]) + 1);
            }
        }

        list.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer count1, Integer count2) {
                int a = map.get(count1);
                int b = map.get(count2);
                if (a == b) {
                    return count2 - count1;
                }
                return a - b;
            }
        });

        return list.stream().mapToInt(Integer::intValue).toArray();
    }
}