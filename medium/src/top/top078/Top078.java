package top.top078;

import java.util.ArrayList;
import java.util.List;

/**
 * 给你一个整数数组 nums ，数组中的元素 互不相同 。
 * 返回该数组所有可能的子集（幂集）
 * 解集 不能 包含重复的子集。
 * 你可以按 任意顺序 返回解集。
 *
 * @Classname Top078
 * @Version 1.0.0
 * @Date 2022/7/6 13:14
 * @Created by sxx_xwl
 */
public class Top078 {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        System.out.println(new Solution().subsets(nums));
    }
}

class Solution {
    List<List<Integer>> listList = new ArrayList<>();
    List<Integer> list = new ArrayList<>();

    public List<List<Integer>> subsets(int[] nums) {
        listList.add(list);
        search(nums, 0);
        return listList;
    }

    private void search(int[] nums, int index) {
        if (index == nums.length) {
            return;
        }
        for (int i = index; i < nums.length; i++) {
            list.add(nums[i]);
            search(nums, i + 1);
            listList.add(new ArrayList<>(list));
            list.remove(list.size()-1);
        }
    }
}