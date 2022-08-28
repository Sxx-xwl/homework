package top.top215;

import java.awt.font.TextAttribute;
import java.util.PriorityQueue;
import java.util.Random;

/**
 * 给定整数数组 nums 和整数 k，请返回数组中第 k 个最大的元素。
 * 请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。
 * 你必须设计并实现时间复杂度为 O(n) 的算法解决此问题。
 *
 * @author sxx_xwl
 * @version 1.0.0
 * @className top.top215
 * @create 2022-08-28-13:47
 */
public class Top215 {
    public static void main(String[] args) {

    }
}

class Solution {
    public int findKthLargest(int[] nums, int k) {
        int len = nums.length;
        int target = len - k;

        int left = 0;
        int right = len - 1;

        while (true) {
            int pivotIndex = partition(nums, left, right);
            if (pivotIndex == target) {
                return nums[pivotIndex];
            } else if (pivotIndex < target) {
                left = pivotIndex + 1;
            } else {
                right = pivotIndex - 1;
            }
        }
    }

    private int partition(int[] nums, int left, int right) {
        int randomIndex = left + new Random().nextInt(right - left + 1);
        swap(nums, randomIndex, left);

        int pivot = nums[left];

        int le = left + 1;
        int ge = right;
        while (true) {
            while (le <= ge && nums[le] < pivot) {
                le++;
            }
            while (le <= ge && nums[ge] > pivot) {
                ge--;
            }
            if (le >= ge) {
                break;
            }
            swap(nums, ge, le);
            le++;
            ge--;
        }
        swap(nums, ge, left);
        return ge;
    }

    private void swap(int[] nums, int a, int b) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }
}