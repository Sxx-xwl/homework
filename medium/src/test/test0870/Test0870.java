package test.test0870;

import java.util.Arrays;

/**
 * 给定两个大小相等的数组nums1和nums2，
 * nums1相对于 nums的优势可以用满足nums1[i] > nums2[i]的索引 i的数目来描述。
 * 返回 nums1的任意排列，使其相对于 nums2的优势最大化。
 *
 * @author sxx_xwl
 * @version 1.0.0
 * @className test.test0870
 * @create 2022-10-08-12:32
 */
public class Test0870 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution().advantageCount(new int[]{12, 24, 8, 32}, new int[]{13, 32, 32, 11})));
    }
}

class Solution {
    public int[] advantageCount(int[] nums1, int[] nums2) {
        int len = nums2.length;
        //存储nums2的排序后的索引顺序
        Integer[] idx2 = new Integer[len];
        for (int i = 0; i < len; ++i) {
            idx2[i] = i;
        }
        Arrays.sort(nums1);
        //按照值的大小将索引排序
        Arrays.sort(idx2, (i, j) -> nums2[i] - nums2[j]);
        //nums2(索引)的左右指针
        int left = 0, right = len - 1;
        for (int i = 0; i < len; i++) {
            if (nums1[i] > nums2[idx2[left]]) {
                // 可以满足 nums1[i] > nums2[i]
                nums2[idx2[left]] = nums1[i];
                left++;
            } else {
                //丢到数组最后
                nums2[idx2[right]] = nums1[i];
                right--;
            }
        }
        return nums2;
    }
}