package top.top344;

/**
 * 编写一个函数，其作用是将输入的字符串反转过来。
 * 输入字符串以字符数组 s 的形式给出。
 * 不要给另外的数组分配额外的空间，
 * 你必须原地修改输入数组、使用 O(1) 的额外空间解决这一问题。
 *
 * @author sxx_xwl
 * @create 2022-06-21-17:14
 */
public class Top344 {
    public static void main(String[] args) {
        System.out.println(5 / 2);
    }
}

class Solution {
    public void reverseString(char[] s) {
        char temp;
        for (int i = 0; i <= (s.length - 1) / 2; i++) {
            temp = s[s.length - i - 1];
            s[s.length - i - 1] = s[i];
            s[i] = temp;
        }
    }
}