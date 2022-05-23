package offer0045;

import java.util.*;

/**
 * 输入一个非负整数数组，
 * 把数组里所有数字拼接起来排成一个数，
 * 打印能拼接出的所有数字中最小的一个。
 *
 * @author sxx_27
 * @create 2022-05-23 10:17
 */
public class Offer0045 {

    public static void main(String[] args) {
        int[] nums = {3, 30, 34, 5, 9, 19};
        System.out.println(new Solution().minNumber(nums));
    }

}

class Solution {
    public String minNumber0(int[] nums) {
        Arrays.sort(nums);
        boolean flag = true;
        int len = nums.length;
        String[] strs = new String[len];
        for (int i = 0; i < len; i++) {
            strs[i] = String.valueOf(nums[i]);
        }
        while (true) {
            for (int i = 0; i < len - 1; i++) {
                if ((strs[i] + strs[i + 1]).compareTo(strs[i + 1] + strs[i]) > 0) {
                    String temp = strs[i];
                    strs[i] = strs[i + 1];
                    strs[i + 1] = temp;
                    flag = false;
                }
            }
            if (flag){
                break;
            }
            flag = true;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < len; i++) {
            sb.append(strs[i]);
        }
        return sb.toString();
    }

    public String minNumber(int[] nums) {
        Arrays.sort(nums);
        int len = nums.length;
        List<String> list = new ArrayList<>();
        for (int i = 0; i < len; i++) {
            list.add(String.valueOf(nums[i]));
        }
        list.sort((o1, o2) -> (o1+o2).compareTo(o2+o1));
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < len; i++) {
            sb.append(list.get(i));
        }
        return sb.toString();
    }
}
