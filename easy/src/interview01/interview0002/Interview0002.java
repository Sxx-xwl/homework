package interview01.interview0002;

/**
 * 给定两个字符串 s1 和 s2，请编写一个程序，
 * 确定其中一个字符串的字符重新排列后，
 * 能否变成另一个字符串。
 *
 * @author sxx_xwl
 * @version 1.0.0
 * @className interview01.interview0002
 * @create 2022-09-27-11:22
 */
public class Interview0002 {
    public static void main(String[] args) {

    }
}

class Solution {
    public boolean CheckPermutation(String s1, String s2) {
        int len1 = s1.length(), len2 = s2.length();
        if (len1 != len2) return false;
        int[] arr = new int[58];
        for (int i = 0; i < len1; i++) {
            arr[s1.charAt(i) - 'A']++;
            arr[s2.charAt(i) - 'A']--;
        }
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != 0) return false;
        }
        return true;
    }
}