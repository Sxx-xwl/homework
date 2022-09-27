package interview17.interview0019;


import java.util.Arrays;

/**
 * 给定一个数组，包含从 1 到 N 所有的整数，
 * 但其中缺了两个数字。
 * 你能在 O(N) 时间内只用 O(1) 的空间找到它们吗？
 * 以任意顺序返回这两个数字均可。
 *
 * @author sxx_xwl
 * @version 1.0.0
 * @className interview17.interview0019
 * @create 2022-09-26-21:27
 */
public class Interview0019 {
    public static void main(String[] args) {
        int[] arr = new int[9];
        int index = 0;
        for (int i = 1; i <= arr.length + 2; i++) {
            if (i != 6 && i != 10)
                arr[index++] = i;
        }
        System.out.println(Arrays.toString(new Solution().missingTwo(arr)));
    }
}

class Solution0 {
    public int[] missingTwo(int[] nums) {
        int n = nums.length;
        int[] res = new int[2];
        int index = 0, temp = 0;
        for (int i = 0; i < n; i++) {
            while (nums[i] - 1 < n && nums[i] != nums[nums[i] - 1]) {
                swap(nums, i, nums[i] - 1);
            }
        }
        for (int i = 0; i < n; i++) {
            if (nums[i] != i + 1) {
                res[index++] = i + 1;
                temp = nums[i];
            }
        }
        if (temp == n + 1) {
            n++;
        }
        while (index < 2) {
            res[index++] = ++n;
        }
        return res;
    }

    private void swap(int[] nums, int a, int b) {
        nums[a] = nums[a] ^ nums[b];
        nums[b] = nums[a] ^ nums[b];
        nums[a] = nums[a] ^ nums[b];
    }
}

class Solution {
    public int[] missingTwo(int[] nums) {
        int n = nums.length;
        int sum = (n + 1) ^ (n + 2);
        for (int i = 1; i <= n; i++) {
            sum ^= i;
            sum ^= nums[i - 1];
        }
        int lowbit = sum & (-sum);
        int x = 0, y = 0;
        for (int i = 1; i <= n + 2; i++) {
            if ((i & lowbit) != 0) {
                x ^= i;
            } else {
                y ^= i;
            }
        }
        for (int i = 0; i < n; i++) {
            if ((nums[i] & lowbit) != 0) {
                x ^= nums[i];
            } else {
                y ^= nums[i];
            }
        }
        return new int[]{x, y};
    }

}