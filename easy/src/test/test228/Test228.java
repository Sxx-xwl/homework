package test.test228;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个 无重复元素 的有序 整数数组 nums 。
 * 返回 恰好覆盖数组中所有数字 的 最小有序 区间范围列表。也就是说，
 * nums 的每个元素都恰好被某个区间范围所覆盖，
 * 并且不存在属于某个范围但不属于 nums 的数字 x 。
 * 列表中的每个区间范围 [a,b] 应该按如下格式输出：
 * "a->b" ，如果 a != b
 * "a" ，如果 a == b
 *
 * @author sxx_xwl
 * @version 1.0.0
 * @className test.test228
 * @create 2022-10-24-10:54
 */
public class Test228 {
    public static void main(String[] args) {

    }
}

class Solution {
    public List<String> summaryRanges(int[] nums) {
        List<String> res = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < nums.length - 1; i++) {
            if (i + 1 == nums.length || nums[i + 1] - nums[i] != 1) {
                if (sb.length() != 0) {
                    sb.append("->");
                }
                sb.append(nums[i]);
                res.add(sb.toString());
                sb = new StringBuilder();
            } else {
                if (sb.length() == 0) {
                    sb.append(nums[i]);
                }
            }
        }
        return res;
    }
}