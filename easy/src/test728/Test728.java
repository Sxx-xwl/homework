package test728;

import java.util.ArrayList;
import java.util.List;

/**自除数是指可以被它包含的每一位数整除的数。
 例如，128 是一个 自除数 ，因为128 % 1 == 0，128 % 2 == 0，128 % 8 == 0。
 自除数 不允许包含 0 。
 给定两个整数left和right ，返回一个列表，列表的元素是范围[left, right]内所有的 自除数 。
 * @author sxx_27
 * @create 2022-03-31 9:53
 */
public class Test728 {

    public static void main(String[] args) {

        Solution s = new Solution();
        List<Integer> list = s.selfDividingNumbers(66, 702);
        list.forEach(System.out::println);

    }

}

class Solution {
    public List<Integer> selfDividingNumbers(int left, int right) {

        List<Integer> list = new ArrayList<>();

        for (int i = left; i < right + 1; i++) {
            if (isSelfDiv(i))
            {
                list.add(i);
            }
        }
        return list;
    }

    public boolean isSelfDiv(int i){
        if (i < 10) {
            return true;
        }
        int temp = i;
        while (temp != 0) {
            if (temp % 10 == 0 || i % (temp % 10) != 0) {
                return false;
            }
            temp /= 10;
        }
        return true;
    }
}