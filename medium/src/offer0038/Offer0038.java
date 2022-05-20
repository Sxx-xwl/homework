package offer0038;

import java.util.*;

/**
 * 输入一个字符串，
 * 打印出该字符串中字符的所有排列。
 * 你可以以任意顺序返回这个字符串数组，
 * 但里面不能有重复元素。
 *
 * @author sxx_27
 * @create 2022-05-20 10:45
 */
public class Offer0038 {
    public static void main(String[] args) {
        String[] abcs = new Solution().permutation("aab");
        System.out.println(Arrays.toString(abcs));
    }
}

class Solution0 {
    Set<String> str = new HashSet<>();
    StringBuilder sb = new StringBuilder();
    boolean[] flag;

    public String[] permutation(String s) {
        if (s.length() == 1) {
            return s.split("");
        }
        char[] chars = s.toCharArray();
        flag = new boolean[chars.length];
        add(chars);
        String[] strings = str.toArray(new String[str.size()]);
        return strings;
    }

    private void add(char[] chars) {
        if (sb.length() == chars.length) {
            str.add(sb.toString());
            return;
        }
        for (int i = 0; i < chars.length; i++) {
            char c = chars[i];
            if (flag[i]) {
                continue;
            } else {
                flag[i] = true;
            }
            sb.append(c);
            add(chars);
            sb.deleteCharAt(sb.length() - 1);
            flag[i] = false;
        }
    }
}

class Solution {
    List<String> list = new ArrayList<>();
    char[] chars;

    public String[] permutation(String s) {
        if (s.length() == 1) {
            return s.split("");
        }
        chars = s.toCharArray();
        add(0);
        return list.toArray(new String[list.size()]);
    }

    private void add(int index) {
        if (index == chars.length - 1) {
            list.add(String.valueOf(chars));
            return;
        }
        //为了防止同一层递归出现重复元素
        HashSet<Character> set = new HashSet<>();
        for (int i = index; i < chars.length; i++) {
            char c = chars[i];
            if (set.contains(c)) {
                continue;
            }
            set.add(c);
            swap(i, index);
            add(index + 1);
            swap(i, index);
        }
    }

    private void swap(int i, int x) {
        char temp = chars[i];
        chars[i] = chars[x];
        chars[x] = temp;
    }
}