package test.test1694;

/**
 * 给你一个字符串形式的电话号码 number 。number 由数字、空格 ' '、和破折号 '-' 组成。
 * 请你按下述方式重新格式化电话号码。
 * 首先，删除 所有的空格和破折号。
 * 其次，将数组从左到右 每 3 个一组 分块，直到 剩下 4 个或更少数字。剩下的数字将按下述规定再分块：
 * 2 个数字：单个含 2 个数字的块。
 * 3 个数字：单个含 3 个数字的块。
 * 4 个数字：两个分别含 2 个数字的块。
 * 最后用破折号将这些块连接起来。注意，重新格式化过程中 不应该 生成仅含 1 个数字的块，并且 最多 生成两个含 2 个数字的块。
 * 返回格式化后的电话号码。
 *
 * @author sxx_xwl
 * @version 1.0.0
 * @className test.test1694
 * @create 2022-10-01-22:03
 */
public class Test1694 {
    public static void main(String[] args) {
        System.out.println(new Solution().reformatNumber("213-412-v12-4"));
    }
}

class Solution {
    public String reformatNumber(String number) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < number.length(); i++) {
            char c = number.charAt(i);
            if (c <= '9' && c >= '0') {
                sb.append(c);
            }
        }
        number = sb.toString();
        sb = new StringBuilder();
        int index = 0, len = number.length();
        while (len - index > 4) {
            sb.append(number.substring(index, index + 3));
            index += 3;
            sb.append('-');
        }
        if (len - index == 4) {
            for (int i = 0; i < 4; i++) {
                if (i == 2) sb.append('-');
                sb.append(number.charAt(index++));
            }
        } else {
            sb.append(number.substring(index));
        }
        return sb.toString();
    }
}