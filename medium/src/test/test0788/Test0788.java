package test.test0788;

import java.util.TreeMap;

/**
 * 我们称一个数 X 为好数, 如果它的每位数字逐个地被旋转 180 度后，
 * 我们仍可以得到一个有效的，且和 X 不同的数。要求每位数字都要被旋转。
 * 如果一个数的每位数字被旋转以后仍然还是一个数字，
 * 则这个数是有效的。0, 1, 和 8 被旋转后仍然是它们自己；
 * 2 和 5 可以互相旋转成对方（在这种情况下，它们以不同的方向旋转，
 * 换句话说，2 和 5 互为镜像）；6 和 9 同理，除了这些以外其他的数字旋转以后都不再是有效的数字。
 * 现在我们有一个正整数N, 计算从1 到N 中有多少个数X 是好数？
 *
 * @author sxx_xwl
 * @version 1.0.0
 * @className test.test0788
 * @create 2022-09-25-21:47
 */
public class Test0788 {
    public static void main(String[] args) {
        System.out.println(new Solution().rotatedDigits(20));
    }
}

class Solution {
    int[] nums = {0, 1, 2, 5, 6, 8, 9};  //累加数组
    int[] base = {1, 2, 5, 6, 8, 9};    //基础数组
    int count = 0, flag = 0;  //flag 是否有2，5，6，9

    public int rotatedDigits(int n) {
        for (int i = 0; i < base.length; i++) {
            flag = 0;
            //判断是否包含2，5，6，9
            if (base[i] != 0 && base[i] != 1 && base[i] != 8) {
                flag++;
            }
            isValid(n, base[i]);
        }
        return count;
    }

    //判断是否是好数
    private void isValid(int n, int cur) {
        //越界返回
        if (cur > n) {
            return;
        }
        //不包括2，5，6，9  不能计入
        if (flag != 0) {
            count++;
        }
        //和累加数组相加
        for (int i = 0; i < nums.length; i++) {
            boolean curFlag = false;
            //判断当前数是否是2，5，6，9
            if (nums[i] != 0 && nums[i] != 1 && nums[i] != 8) {
                curFlag = true;
            }
            //好数累加
            cur = cur * 10 + nums[i];
            //是否越界
            if (cur > n) {
                break;
            }
            if (curFlag) {
                flag++;
            }
            isValid(n, cur);
            if (curFlag) {
                flag--;
            }
            //将当前数回退到上一个数
            cur /= 10;
        }
    }
}

class Solution1 {
    public int rotatedDigits(int n) {
        int count = 0;
        for (int i = 1; i <= n; i++) {
            if (isValid(i)) {
                count++;
            }
        }
        return count;
    }

    public Boolean isValid(int n) {
        boolean flag = false;
        while (n != 0) {
            int num = n % 10;
            if (num == 2 || num == 5 || num == 6 || num == 9) {
                flag = true;
            } else if (num == 3 || num == 4 || num == 7) {
                return false;
            }
            n = n / 10;
        }
        return flag;
    }
}