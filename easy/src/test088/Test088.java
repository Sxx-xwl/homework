package test088;

import java.util.Arrays;

/**
 * 给你两个按 非递减顺序 排列的整数数组nums1 和 nums2，另有两个整数 m 和 n ，分别表示 nums1 和 nums2 中的元素数目。
 * 请你 合并 nums2 到 nums1 中，使合并后的数组同样按 非递减顺序 排列。
 * 注意：最终，合并后数组不应由函数返回，而是存储在数组 nums1 中。
 * 为了应对这种情况，nums1 的初始长度为 m + n，其中前 m 个元素表示应合并的元素，后 n 个元素为 0 ，应忽略。nums2 的长度为 n 。
 * @author sxx_27
 * @create 2022-04-02 15:04
 */
public class Test088 {

    public static void main(String[] args) {

        Solution s = new Solution();
        int arr1[] = {1,2,3,0,0,0};
        int arr2[] = {2,5,6};
        s.merge(arr1,3,arr2,3);
        System.out.println(Arrays.toString(arr1));
    }

}
class Solution {
    public void merge1(int[] nums1, int m, int[] nums2, int n) {
        for (int i = m; i < m + n; i++) {
            nums1[i] = nums2[i - m];
        }
        Arrays.sort(nums1);
    }

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] clone = nums1.clone();
        int i = 0 , i1 = 0 , i2 = 0;
        while (i < m+n)
        {
            if (i1 < m && i2 < n) {
                nums1[i++] = clone[i1] <= nums2[i2] ? clone[i1++] : nums2[i2++];
            }else if (i1 == m)
            {
                while (i2 < n)
                {
                    nums1[i++] = nums2[i2++];
                }
            }else
            {
                while (i1 < m)
                {
                    nums1[i++] = clone[i1++];
                }
            }
        }
    }
}