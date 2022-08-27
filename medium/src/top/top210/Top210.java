package top.top210;

import java.util.*;

/**
 * 现在你总共有 numCourses 门课需要选，记为0到numCourses - 1。
 * 给你一个数组prerequisites ，其中 prerequisites[i] = [ai, bi] ，
 * 表示在选修课程 ai 前 必须 先选修bi 。
 * 例如，想要学习课程 0 ，你需要先完成课程1 ，我们用一个匹配来表示：[0,1] 。
 * 返回你为了学完所有课程所安排的学习顺序。可能会有多个正确的顺序，你只要返回 任意一种 就可以了。如果不可能完成所有课程，返回 一个空数组 。
 *
 * @author sxx_xwl
 * @version 1.0.0
 * @className top.top210
 * @create 2022-08-27-13:21
 */
public class Top210 {
    public static void main(String[] args) {
        int[][] pre = {{1, 0}, {2, 0}, {3, 1}, {3, 2}};
        int[] order = new Solution().findOrder(4, pre);
        System.out.println(Arrays.toString(order));
    }
}

class Solution {
    int[] indege;
    List<List<Integer>> list;
    Queue<Integer> queue;
    int[] result;

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        queue = new LinkedList<>();
        indege = new int[numCourses];
        list = new ArrayList<>();
        for (int j = 0; j < numCourses; j++) {
            list.add(new ArrayList<>());
        }
        //分出所有基础课和高阶课 ，并计算高阶课的入度
        for (int[] pre : prerequisites) {
            list.get(pre[1]).add(pre[0]);
            indege[pre[0]]++;
        }
        //将入度为0的高阶课添加到队列中
        for (int i = 0; i < numCourses; i++) {
            if (indege[i] == 0) {
                queue.add(i);
            }
        }
        result = new int[numCourses];
        int index = 0;
        //将课程从队列中弹出，并将以该课为基础课的高阶课入度减一
        while (!queue.isEmpty()) {
            int classNum = queue.poll();
            result[index++] = classNum;
            List<Integer> li = list.get(classNum);
            if (li != null) {
                for (int num : li) {
                    indege[num]--;
                    if (indege[num] == 0) {
                        queue.add(num);
                    }
                }
            }
        }
        if (index == numCourses) {
            return result;
        } else {
            return new int[0];
        }
    }
}






