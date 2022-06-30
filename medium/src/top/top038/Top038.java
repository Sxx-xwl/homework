package top.top038;

/**
 * 给定一个正整数 n ，输出外观数列的第 n 项。
 * 「外观数列」是一个整数序列，从数字 1 开始，序列中的每一项都是对前一项的描述。
 * 你可以将其视作是由递归公式定义的数字字符串序列：
 * countAndSay(1) = "1"
 * countAndSay(n) 是对 countAndSay(n-1) 的描述，然后转换成另一个数字字符串。
 * 前五项如下：
 * 1.     1
 * 2.     11
 * 3.     21
 * 4.     1211
 * 5.     111221
 * 第一项是数字 1
 * 描述前一项，这个数是 1 即 “ 一 个 1 ”，记作 "11"
 * 描述前一项，这个数是 11 即 “ 二 个 1 ” ，记作 "21"
 * 描述前一项，这个数是 21 即 “ 一 个 2 + 一 个 1 ” ，记作 "1211"
 * 描述前一项，这个数是 1211 即 “ 一 个 1 + 一 个 2 + 二 个 1 ” ，记作 "111221"
 *
 * @Classname Top038
 * @Version 1.0.0
 * @Date 2022/6/29 17:22
 * @Created by sxx_xwl
 */
public class Top038 {
    public static void main(String[] args) {
        System.out.println(new Solution().countAndSay(4));
    }
}

class Solution {
    StringBuilder sb;

    public String countAndSay(int n) {
        return search("1", n);
    }

    private String search(String str, int n) {
        if (n <= 1) {
            return sb.toString();
        }
        sb = new StringBuilder();
        int l = str.length() - 1;
        int r = str.length() - 1;
        while (l >= 0) {
            if (str.charAt(l) != str.charAt(r)) {
                sb.append(str.charAt(r));
                sb.append(r - l);
                r = l;
            }
            l--;
        }
        sb.append(str.charAt(r));
        sb.append(r - l);
        return search(sb.reverse().toString(),n-1);
    }
}