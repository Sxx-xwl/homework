package test.test383;

/**
 * 给你两个字符串：ransomNote 和 magazine ，
 * 判断 ransomNote 能不能由 magazine 里面的字符构成。
 * 如果可以，返回 true ；否则返回 false 。
 * magazine 中的每个字符只能在 ransomNote 中使用一次。
 * @author sxx_27
 * @create 2022-04-07 21:14
 */
public class Test383 {

    public static void main(String[] args) {

        String ransomNote = "aa", magazine = "baa";
        boolean b = new Solution().canConstruct(ransomNote, magazine);
        System.out.println(b);
    }
}
class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {

        if (ransomNote.length() > magazine.length())
        {
            return false;
        }
        int arr[] = new int[26];
        for (int i = 0; i < magazine.length(); i++) {
            int a = magazine.charAt(i) - 'a';
            arr[a]++;
        };
        for (int i = 0; i < ransomNote.length(); i++) {
            int a = ransomNote.charAt(i) - 'a';
            arr[a]--;
            if (arr[a] < 0)
            {
                return false;
            }
        }
        return true;
    }
}