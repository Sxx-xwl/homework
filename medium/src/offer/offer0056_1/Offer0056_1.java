package offer.offer0056_1;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * 一个整型数组 nums 里除两个数字之外，
 * 其他数字都出现了两次。
 * 请写程序找出这两个只出现一次的数字。
 * 要求时间复杂度是O(n)，空间复杂度是O(1)。
 *
 * @author sxx_27
 * @create 2022-05-27 13:21
 */
public class Offer0056_1 {
    public static void main(String[] args) {
        int[] nums = {4, 4, 6, 6, 7, 5};
        System.out.println(Arrays.toString(new Solution().singleNumbers(nums)));
    }
}

class Solution {
    public int[] singleNumbers0(int[] nums) {
        if (nums.length == 2) {
            return nums;
        }
        Set<Integer> set = new HashSet<>();
        int i = 0;
        while (i < nums.length) {
            if (set.contains(nums[i])) {
                set.remove(nums[i]);
            } else {
                set.add(nums[i]);
            }
            i++;
        }
        Object[] objects = set.toArray();
        int index = 0;
        int[] res = new int[2];
        for (Object a : objects) {
            res[index++] = (int) a;
        }
        return res;
    }

    public int[] singleNumbers(int[] nums) {
        if (nums.length == 2) {
            return nums;
        }
        //^异或   2^2=0  2^0=2
        int flag = 1;  //划分数组的位
        int x = 0, a = 0, b = 0; //位运算  结果1 结果2
        for (int i = 0; i < nums.length; i++) {
            x ^= nums[i];
        }
        while ((flag&x)==0){
            flag<<=1;
        }
        for (int i = 0; i < nums.length; i++) {
            if ((flag&nums[i])==0){
                a = a^nums[i];
            }else {
                b = b^nums[i];
            }
        }
        return new int[]{a,b};
    }
}