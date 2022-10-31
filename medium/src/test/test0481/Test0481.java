package test.test0481;

/**
 * 神奇字符串 s 仅由 '1' 和 '2' 组成，并需要遵守下面的规则：
 * 神奇字符串 s 的神奇之处在于，串联字符串中 '1' 和 '2' 的连续出现次数可以生成该字符串。
 * s 的前几个元素是 s = "1221121221221121122……" 。
 * 如果将 s 中连续的若干 1 和 2 进行分组，
 * 可以得到 "1 22 11 2 1 22 1 22 11 2 11 22 ......" 。
 * 每组中 1 或者 2 的出现次数分别是 "1 2 2 1 1 2 1 2 2 1 2 2 ......" 。
 * 上面的出现次数正是 s 自身。
 * 给你一个整数 n ，返回在神奇字符串 s 的前 n 个数字中 1 的数目。
 *
 * @author sxx_xwl
 * @version 1.0.0
 * @className test.test0481
 * @create 2022-10-31-11:37
 */
public class Test0481 {
    public static void main(String[] args) {
        System.out.println(new Solution().magicalString(4));
    }
}

class Solution {
    public int magicalString(int n) {
        if (n < 4) {
            return 1;
        }
        char[] chars = new char[n];
        chars[0] = '1';
        chars[1] = '2';
        chars[2] = '2';
        char c = '1';
        int res = 1, index = 2, cur = 3;
        while (cur < n) {
            int times = chars[index++] - '0';
            for (int i = 0; i < times && cur < n; i++) {
                chars[cur++] = c;
                res += c == '1' ? 1 : 0;
            }
            c ^= 3;
        }
        return res;
    }
}