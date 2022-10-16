package test.test0785;

/**
 * 存在一个 无向图 ，图中有 n 个节点。其中每个节点都有一个介于 0 到 n - 1 之间的唯一编号。
 * 给你一个二维数组 graph ，其中 graph[u] 是一个节点数组，由节点 u 的邻接节点组成。
 * 形式上，对于graph[u] 中的每个 v ，都存在一条位于节点 u 和节点 v 之间的无向边。
 * 该无向图同时具有以下属性：
 * 不存在自环（graph[u] 不包含 u）。
 * 不存在平行边（graph[u] 不包含重复值）。
 * 如果 v 在 graph[u] 内，那么 u 也应该在 graph[v] 内（该图是无向图）
 * 这个图可能不是连通图，也就是说两个节点 u 和 v 之间可能不存在一条连通彼此的路径。
 * 二分图 定义：如果能将一个图的节点集合分割成两个独立的子集 A 和 B ，
 * 并使图中的每一条边的两个节点一个来自 A 集合，一个来自 B 集合，就将这个图称为 二分图 。
 * 如果图是二分图，返回 true ；否则，返回 false
 *
 * @author sxx_xwl
 * @version 1.0.0
 * @className test.test0785
 * @create 2022-10-16-13:20
 */
public class Test0785 {
    public static void main(String[] args) {

    }
}

class Solution {
    private static final int UNCOLORED = 0;
    private static final int RED = 1;
    private static final int GREEN = 2;
    private boolean valid;
    private int[] colors;

    public boolean isBipartite(int[][] graph) {
        int len = graph.length;
        //定义对应的染色数组
        colors = new int[len];
        //判断是否是二分图
        valid = true;
        //从第一个节点开始循环遍历，如果遍历结束或者发现为非二分图节点则返回
        for (int i = 0; i < len && valid; i++) {
            //如果该节点为染色则进行染色
            if (colors[i] == UNCOLORED) {
                dfs(graph, i, RED);
            }
        }
        return valid;
    }

    private void dfs(int[][] graph, int index, int color) {
        //将该节点染色
        colors[index] = color;
        //定义相邻节点颜色
        int neiColor = color == RED ? GREEN : RED;
        //遍历相邻节点
        for (int neighbor : graph[index]) {
            //如果该节点为染色则进行染色
            if (colors[neighbor] == UNCOLORED) {
                //如果染色失败则结束遍历
                if (!valid) {
                    return;
                }
                dfs(graph, neighbor, neiColor);
                //如果下一个节点有颜色并且与待染颜色不同则失败 并返回
            } else if (colors[neighbor] != neiColor) {
                valid = false;
                return;
            }
        }
    }
}