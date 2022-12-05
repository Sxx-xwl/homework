package test.test599;

import java.util.HashMap;
import java.util.Map;

/**
 * 假设 Andy 和 Doris 想在晚餐时选择一家餐厅，
 * 并且他们都有一个表示最喜爱餐厅的列表，每个餐厅的名字用字符串表示。
 * 你需要帮助他们用最少的索引和找出他们共同喜爱的餐厅。
 * 如果答案不止一个，则输出所有答案并且不考虑顺序。 你可以假设答案总是存在。
 * https://leetcode.cn/problems/minimum-index-sum-of-two-lists/
 *
 * @author sxx_xwl
 * @version 1.0.0
 * @className test.test599
 * @create 2022-12-05-10:38
 */
public class Test599 {
    public static void main(String[] args) {

    }
}

class Solution {
    public String[] findRestaurant(String[] list1, String[] list2) {
        int indexSum = 2022;
        StringBuilder sb = new StringBuilder();
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < list1.length; i++) {
            map.put(list1[i], i);
        }
        for (int i = 0; i < list2.length && i <= indexSum; i++) {
            if (map.containsKey(list2[i])) {
                int temp = i + map.get(list2[i]);
                if (temp < indexSum) {
                    indexSum = temp;
                    sb.delete(0, sb.length());
                } else if (temp > indexSum) {
                    continue;
                }
                sb.append(list2[i]).append("!");
            }
        }
        return sb.toString().split("!");
    }
}