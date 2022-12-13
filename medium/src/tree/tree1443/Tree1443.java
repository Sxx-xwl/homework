package tree.tree1443;

import java.util.ArrayList;
import java.util.List;

/**
 * 给你一棵有 n 个节点的无向树，节点编号为 0 到 n-1 ，
 * 它们中有一些节点有苹果。通过树上的一条边，需要花费 1 秒钟。
 * 你从 节点 0 出发，请你返回最少需要多少秒，可以收集到所有苹果，并回到节点 0 。
 * 无向树的边由 edges 给出，其中 edges[i] = [fromi, toi] ，
 * 表示有一条边连接 from 和 toi 。除此以外，还有一个布尔数组 hasApple
 * ，其中 hasApple[i] = true 代表节点 i 有一个苹果，否则，节点 i 没有苹果。
 * https://leetcode.cn/problems/minimum-time-to-collect-all-apples-in-a-tree/
 *
 * @author sxx_xwl
 * @version 1.0.0
 * @className tree.tree1443
 * @create 2022-12-13-20:46
 */
public class Tree1443 {
    public static void main(String[] args) {

    }
}

class Solution {
    //我这是重复计算了，难受
    List<Integer>[] list;
    List<Boolean> hasApple;
    public int minTime(int n, int[][] edges, List<Boolean> hasApple) {
        list = new ArrayList[n];
        this.hasApple = hasApple;
        boolean[] visit = new boolean[n];
        visit[0] = true;
        for(int i = 0; i < n; i++) list[i] = new ArrayList<>();
        for(int[] edge: edges) {
            list[edge[0]].add(edge[1]);
            list[edge[1]].add(edge[0]);
        }
        return dfs(visit, 0)*2;
    }
    //所以说dp跟dfs感觉思想是一致的
    public int dfs(boolean[] visit, int ind) {
        List<Integer> next = list[ind];
        int total = 0;
        for(int i = 0; i < next.size(); i++) {
            int leaf = next.get(i);
            if(!visit[leaf]) {
                visit[leaf] = true;
                int x = dfs(visit, leaf);
                total += x + ((x != 0 ||hasApple.get(leaf)) ? 1 : 0);
            }
        }
        return total;
    }
}