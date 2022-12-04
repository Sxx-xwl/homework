package test.test1774;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * 你打算做甜点，现在需要购买配料。
 * 目前共有 n 种冰激凌基料和 m 种配料可供选购。而制作甜点需要遵循以下几条规则：
 * 必须选择 一种 冰激凌基料。
 * 可以添加 一种或多种 配料，也可以不添加任何配料。
 * 每种类型的配料 最多两份 。
 * 给你以下三个输入：
 * baseCosts ，一个长度为 n 的整数数组，其中每个 baseCosts[i] 表示第 i 种冰激凌基料的价格。
 * toppingCosts，一个长度为 m 的整数数组，其中每个 toppingCosts[i] 表示 一份 第 i 种冰激凌配料的价格。
 * target ，一个整数，表示你制作甜点的目标价格。
 * 你希望自己做的甜点总成本尽可能接近目标价格 target 。
 * 返回最接近 target 的甜点成本。如果有多种方案，返回 成本相对较低 的一种。
 * https://leetcode.cn/problems/closest-dessert-cost/
 *
 * @author sxx_xwl
 * @version 1.0.0
 * @className test.test1774
 * @create 2022-12-04-11:25
 */
public class Test1774 {
    public static void main(String[] args) {
        System.out.println(new Solution().closestCost(new int[]{3, 10}, new int[]{2, 5}, 9));
    }
}

class Solution {
    int ans = 10001;

    public int closestCost(int[] base, int[] top, int target) {
        for (int x : base) dfs(0, x, target, top);
        return ans;
    }

    void dfs(int x, int sum, int target, int[] top) {
        int a = Math.abs(target - sum), b = Math.abs(target - ans);
        if (a < b) ans = sum;
        if (a == b && sum < ans) ans = sum;
        if (sum > target) return;
        for (int i = x; i < top.length; i++) {
            dfs(i + 1, sum + top[i], target, top);
            dfs(i + 1, sum + 2 * top[i], target, top);
        }
    }
}