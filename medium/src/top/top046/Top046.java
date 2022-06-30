package top.top046;

import java.util.*;

/**
 * 给定一个不含重复数字的数组 nums ，
 * 返回其 所有可能的全排列 。你可以 按任意顺序 返回答案。
 *
 * @Classname Top046
 * @Version 1.0.0
 * @Date 2022/6/29 20:13
 * @Created by sxx_xwl
 */
public class Top046 {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3};
        System.out.println(new Solution().permute(arr));
    }
}

class Solution {
    List<List<Integer>> listList = new ArrayList<>();
    List<Integer> list = new ArrayList<>();
//    Set<Integer> set = new HashSet<>();

    public List<List<Integer>> permute(int[] nums) {
        if (nums.length == 1) {
            list.add(nums[0]);
            listList.add(list);
            return listList;
        }
        boolean[] flag = new boolean[nums.length];
        search(nums, 0, flag);
        return listList;
    }

    private void search(int[] nums, int index, boolean[] flag) {
        if (index == nums.length) {
            listList.add(new ArrayList<>(list));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
//            if (set.add(nums[i])) {
            if (!flag[i]) {
                list.add(nums[i]);
                flag[i] = true;
                search(nums, index + 1, flag);
                list.remove(list.size() - 1);
                flag[i] = false;
//                set.remove(nums[i]);
//            }
            }
        }
    }
}