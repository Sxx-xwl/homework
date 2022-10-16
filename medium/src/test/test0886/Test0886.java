package test.test0886;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一组n人（编号为1, 2, ..., n），
 * 我们想把每个人分进任意大小的两组。
 * 每个人都可能不喜欢其他人，那么他们不应该属于同一组。
 * 给定整数 n和数组 dislikes，
 * 其中dislikes[i] = [ai, bi]，
 * 表示不允许将编号为 ai和bi的人归入同一组。
 * 当可以用这种方法将所有人分进两组时，返回 true；否则返回 false。
 *
 * @author sxx_xwl
 * @version 1.0.0
 * @className test.test0886
 * @create 2022-10-16-11:29
 */
public class Test0886 {
    public static void main(String[] args) {
        int[][] dislikes = new int[][]{{1, 2}, {3, 4}, {5, 6}, {6, 7}, {8, 9}, {7, 8}};
        System.out.println(new Solution().possibleBipartition(10, dislikes));
    }
}

class Solution {
    private static final int UNCOLORED = 0;
    private static final int RED = 1;
    private static final int GREEN = 2;
    private boolean valid;
    private int[] colors;

    public boolean possibleBipartition(int n, int[][] dislikes) {
        colors = new int[n + 1];
        valid = true;
        List<Integer>[] list = new ArrayList[n + 1];
        for (int i = 0; i <= n; i++) {
            list[i] = new ArrayList<>();
        }
        for (int[] p : dislikes) {
            list[p[0]].add(p[1]);
            list[p[1]].add(p[0]);
        }
        for (int i = 1; i <= n && valid; i++) {
            if (colors[i] == UNCOLORED) {
                dfs(i, RED, list);
            }
        }
        return valid;
    }

    private void dfs(int i, int color, List<Integer>[] list) {
        colors[i] = color;
        int neiColor = color == RED ? GREEN : RED;
        for (int j = 0; j < list[i].size(); j++) {
            int num = list[i].get(j);
            if (!valid) {
                return;
            }
            if (colors[num] != UNCOLORED && colors[i] == colors[num]) {
                valid = false;
                return;
            }
            if (colors[num] == UNCOLORED) {
                dfs(num, neiColor, list);
            }
        }
    }
}
//class Solution {
//    private static final int UNCOLORED = 0;
//    private static final int RED = 1;
//    private static final int GREEN = 2;
//    private boolean valid;
//    private int[] colors;
//
//    public boolean possibleBipartition(int n, int[][] dislikes) {
//        colors = new int[n];
//        valid = true;
//        for (int i = 0; i < dislikes.length && valid; i++) {
//            if (colors[dislikes[i][0]] == UNCOLORED) {
//                dfs(dislikes, i, RED);
//            }
//        }
//        return valid;
//    }
//
//    private void dfs(int[][] dislikes, int index, int color) {
//        colors[dislikes[index][0]] = color;
//        int neiColor = color == RED ? GREEN : RED;
//        for (int i = 1; i < dislikes[index].length && valid; i++) {
//            int neighbor = dislikes[index][i];
//            if (neighbor == UNCOLORED) {
//                dfs(dislikes, neighbor, neiColor);
//            } else if (colors[neighbor] != neiColor) {
//                valid = false;
//                return;
//            }
//        }
//    }
//}