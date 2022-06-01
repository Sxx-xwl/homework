package test.test744;

/**
 * 给你一个排序后的字符列表 letters ，列表中只包含小写英文字母。另给出一个目标字母target，请你寻找在这一有序列表里比目标字母大的最小字母。
 * 在比较时，字母是依序循环出现的。举个例子：
 * 如果目标字母 target = 'z' 并且字符列表为letters = ['a', 'b']，则答案返回'a'
 * @author sxx_27
 * @create 2022-04-03 22:03
 */
public class Test744 {

    public static void main(String[] args) {

        Solution s = new Solution();
        char[] letters = {'c', 'f', 'j'};
        char results = s.nextGreatestLetter(letters, 'a');
        System.out.println(results);

    }

}

class Solution {
    public char nextGreatestLetter(char[] letters, char target) {

        int left = 0;
        int right = letters.length-1;
        if (target < letters[0] || target >= letters[letters.length-1])
        {
            return letters[0];
        }else {
            int mid = (left + right) >> 1;
            while (left <= right)
            {
                if (letters[mid] > target)
                {
                    right = mid - 1;
                }else
                {
                    left = mid + 1;
                }
                mid = (left + right) >> 1;
            }
        }
        return letters[left];
    }
}