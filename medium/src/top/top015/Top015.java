package top.top015;

import java.util.*;

/**
 * 给你一个包含 n 个整数的数组nums，判断nums中是否存在三个元素 a，b，c ，
 * 使得a + b + c = 0 ？请你找出所有和为 0 且不重复的三元组。
 * 注意：答案中不可以包含重复的三元组。
 *
 * @Classname Top015
 * @Version 1.0.0
 * @Date 2022/6/26 19:15
 * @Created by sxx_xwl
 */
public class Top015 {
    public static void main(String[] args) {
        int[] arr = {0, 0, 0, 0};
        int[] arr1 = {-1,0,1,2,-1,-4,-1,-1,-1};
        System.out.println(new Solution().threeSum(arr1));
    }
}

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> listList = new ArrayList<>();
        Arrays.sort(nums);
        int len = nums.length;
        if (len < 3 || nums[0] > 0 || nums[len - 1] < 0) {
            return listList;
        }
        if (nums[0] == nums[len - 1] && nums[0] == 0) {
            List<Integer> list = new ArrayList<>();
            list.add(0);
            list.add(0);
            list.add(0);
            listList.add(new ArrayList<>(list));
            return listList;
        }
        int res, a, b;
        for (int i = 0; i < len - 2; i++) {
            res = -nums[i];
            a = i + 1;
            b = len - 1;
            if (nums[a] > res) {
                return listList;
            } else if (i > 0 && nums[i - 1] == nums[i]) {
                continue;
            }
            while (a < b) {
                if (nums[a] + nums[b] == res) {
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[a]);
                    list.add(nums[b]);
                    list.add(-res);
                    listList.add(new ArrayList<>(list));
                    while (a < b && nums[b-1]==nums[b--]){
                        b--;
                    };
                } else if (nums[a] + nums[b] < res) {
                    a++;
                } else {
                    b--;
                }
            }
        }
        return listList;
    }
}