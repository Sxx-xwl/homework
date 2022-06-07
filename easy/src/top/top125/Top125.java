package top.top125;

/**
 * 给定一个字符串，验证它是否是回文串，
 * 只考虑字母和数字字符，可以忽略字母的大小写。
 * 说明：本题中，我们将空字符串定义为有效的回文串。
 *
 * @author sxx_27
 * @create 2022-06-07 10:34
 */
public class Top125 {
    public static void main(String[] args) {
        System.out.println(new Solution().isPalindrome("0P"));
    }
}

class Solution {
    public boolean isPalindrome(String s) {
        s = s.trim();
        if (s.isEmpty()) {
            return true;
        }
        int left, right;
        left = 0;
        right = s.length() - 1;
        s = s.toLowerCase();
        while (left <= right && left < s.length() && right >= 0) {
            char lchar = s.charAt(left);
            char rchar = s.charAt(right);

            while (lchar > 'z' || lchar < 'a' && lchar > '9' || lchar < '0' && left < right) {
                left++;
                if (left > right) {
                    break;
                }
                lchar = s.charAt(left);
            }
            while (rchar > 'z' || rchar < 'a' && rchar > '9' || rchar < '0' && left < right) {
                right--;
                if (left > right) {
                    break;
                }
                rchar = s.charAt(right);
            }
            if (left > right) {
                break;
            } else {
                if (lchar == rchar) {
                    left++;
                    right--;
                } else {
                    return false;
                }
            }
        }
        return true;
    }
}