package top.top075;

import java.time.temporal.Temporal;
import java.util.Arrays;

/**
 * 给定一个包含红色、白色和蓝色、共n 个元素的数组nums，
 * 原地对它们进行排序，使得相同颜色的元素相邻，
 * 并按照红色、白色、蓝色顺序排列。
 * 我们使用整数 0、1 和 2 分别表示红色、白色和蓝色。
 * 必须在不使用库的sort函数的情况下解决这个问题。
 *
 * @Classname Top075
 * @Version 1.0.0
 * @Date 2022/7/5 15:08
 * @Created by sxx_xwl
 */
public class Top075 {
    public static void main(String[] args) {
        int[] arr = {2, 0, 2, 1, 1, 0, 1, 2};
        new Solution()
                .sortColors1(arr);
        System.out.println(Arrays.toString(arr));
    }
}

class Solution {
    public void sortColors(int[] nums) {
        int start = 0;
        int end = nums.length - 1;
        for (int i = 0; i < nums.length; i++) {
            while (nums[i] == 0 && i > start) {
                int temp = nums[i];
                nums[i] = nums[start];
                nums[start++] = temp;
            }
            while (nums[i] == 2 && i < end) {
                int temp = nums[i];
                nums[i] = nums[end];
                nums[end--] = temp;
            }
            while (nums[i] == 0 && i > start) {
                int temp = nums[i];
                nums[i] = nums[start];
                nums[start++] = temp;
            }
        }
    }
    public void sortColors1(int[] nums) {
        int num0 = 0, num1 = 0;
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] == 0) {
                nums[i] = 2;
                nums[num1++] = 1;
                nums[num0++] = 0;
            }else if(nums[i] == 1) {
                nums[i] = 2;
                nums[num1++] = 1;
            }
        }
    }
}