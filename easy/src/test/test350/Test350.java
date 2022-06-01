package test.test350;

import java.util.*;

/**
 * 给你两个整数数组nums1 和 nums2 ，
 * 请你以数组形式返回两数组的交集。
 * 返回结果中每个元素出现的次数，
 * 应与元素在两个数组中都出现的次数一致（如果出现次数不一致，则考虑取较小值）。
 * 可以不考虑输出结果的顺序。
 * @author sxx_27
 * @create 2022-04-04 21:02
 */
public class Test350 {

    public static void main(String[] args) {

        Solution s = new Solution();
        int[] arr1 = {4,9,5};
        int[] arr2 = {9,4,9,8,4};
        int[] intersect = s.intersect(arr1, arr2);
        System.out.println(Arrays.toString(intersect));
    }
}
class Solution {
    public int[] intersect(int[] nums1, int[] nums2){
        Map<Integer , Integer> map = new HashMap<>();

        for (int i = 0; i < nums1.length; i++) {
            if (!map.containsKey(nums1[i]))
            {
                map.put(nums1[i], 1);
            }else
            {
                map.replace(nums1[i],map.get(nums1[i])+1 );
            }
        }
        int temp[] = new int[nums1.length < nums2.length ? nums1.length : nums2.length];
        int count = 0;
        for (int i = 0; i < nums2.length; i++) {
            if (map.containsKey(nums2[i]) && map.get(nums2[i]) > 0)
            {
                temp[count++] = nums2[i];
                map.replace(nums2[i],map.get(nums2[i])-1);
            }
        }
        return Arrays.copyOfRange(temp, 0, count);
    }
    public int[] intersect0(int[] nums1, int[] nums2) {
        int min = nums1.length < nums2.length ? nums1.length : nums2.length;
        int temp[] = new int[min];
        Arrays.sort(nums1);
        Arrays.sort(nums2);

        int up = 0;
        int down = 0;
        int count = 0;
        while (true)
        {
            if (nums1[up] == nums2[down])
            {
                temp[count++] = nums1[up++];
                down++;
            }else if (nums1[up] > nums2[down])
            {
                down++;
            }else
            {
                up++;
            }

            if (up >= nums1.length || down >= nums2.length)
            {
                break;
            }
        }
        int arr[] = new int[count];
        for (int i = 0; i < count; i++) {
            arr[i] = temp[i];
        }
        return arr;
    }
}