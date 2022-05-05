package test118;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**给定一个非负整数 numRows，生成「杨辉三角」的前 numRows 行。
 在「杨辉三角」中，每个数是它左上方和右上方的数的和。
 * @author sxx_27
 * @create 2022-04-04 21:49
 */
public class Test118 {

    public static void main(String[] args) {

        Solution s = new Solution();
        List<List<Integer>> generate = s.generate(5);
        for(List<Integer> i : generate)
        {
            System.out.println(i.toString());
        }
    }
}

class Solution {
    public List<List<Integer>> generate(int numRows) {

        List<Integer> list = new ArrayList<>();
        list.add(1);
        List<List<Integer>> listList = new ArrayList<>();
        listList.add(new ArrayList<>(list));
        if (numRows == 1) {
            return listList;
        }
        list.add(1);
        listList.add(new ArrayList<>(list));
        if (numRows == 2) {
            return listList;
        }

        for (int i = 3; i <= numRows; i++) {

            list.clear();
            for (int j = 0; j < i; j++) {
                if (j == 0 || j == i - 1) {
                    list.add(1);
                } else {
                    int sum = listList.get(i - 2).get(j - 1) + listList.get(i - 2).get(j);
                    list.add(sum);
                }
            }
            listList.add(new ArrayList<>(list));
        }
        return listList;
    }
}