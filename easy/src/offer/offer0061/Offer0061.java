package offer.offer0061;

import sun.plugin2.util.BrowserType;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.TransferQueue;

/**
 * 从若干副扑克牌中随机抽 5 张牌，
 * 判断是不是一个顺子，
 * 即这5张牌是不是连续的。2～10为数字本身，
 * A为1，J为11，Q为12，K为13，
 * 而大、小王为 0 ，可以看成任意数字。
 * A 不能视为 14。
 *
 * @author sxx_27
 * @create 2022-05-09 14:27
 */
public class Offer0061 {
    public static void main(String[] args) {

    }
}

class Solution {
    public boolean isStraight1(int[] nums) {
//        Arrays.sort(nums);
        Set<Integer> set = new HashSet<>();
        int max = nums[0];
        int min = Integer.MAX_VALUE;
        if (nums[0] != 0) {
            set.add(nums[0]);
            min = nums[0];
        }
        for (int i = 1; i < nums.length; i++) {
            int len1 = set.size();
            if (nums[i] != 0) {
                set.add(nums[i]);
                min = nums[i] > min ? min : nums[i];
                max = nums[i] > max ? nums[i] : max;
                if (set.size() == len1) {
                    return false;
                }
            }
        }
        return max - min <= 4;
    }

    public boolean isStraight(int[] nums) {
        Arrays.sort(nums);
        int min = 14;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] != 0) {
                min = nums[i] < min? nums[i] : min;
                if (nums[i] == nums[i + 1]) {
                    return false;
                }
            }
        }
        return nums[4] - min <= 4;
    }
}