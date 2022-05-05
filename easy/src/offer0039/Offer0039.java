package offer0039;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * 数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。
 *
 * @author sxx_27
 * @create 2022-05-02 17:14
 */
public class Offer0039 {

    public static void main(String[] args) {

        System.out.println(new Solution().majorityElement(new int[]{3, 2, 3}));
    }
}

class Solution {
    public int majorityElement(int[] nums) {
        int count =0;
        Integer card = null;
        for (int num : nums){
            if (count == 0){
                card = num;
            }
            count += card==num?1:-1;
        }
        return card;
    }
}