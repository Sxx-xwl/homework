package top.top207;

import java.util.*;

/**
 * 你这个学期必须选修 numCourses 门课程，记为0到numCourses - 1 。
 * 在选修某些课程之前需要一些先修课程。 先修课程按数组prerequisites 给出，
 * 其中prerequisites[i] = [ai, bi] ，表示如果要学习课程ai 则 必须 先学习课程bi 。
 * 例如，先修课程对[0, 1] 表示：想要学习课程 0 ，你需要先完成课程 1 。
 * 请你判断是否可能完成所有课程的学习？如果可以，返回 true ；否则，返回 false
 *
 * @author sxx_xwl
 * @version 1.0.0
 * @className top.top207
 * @create 2022-08-23-11:58
 */
public class Top207 {
    public static void main(String[] args) {
        System.out.println(new Solution().canFinish(2, new int[][]{{1, 0}, {0, 1}}));
    }

}

class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> edges = new ArrayList<>();
        int[] indeg = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            edges.add(new ArrayList<Integer>());
        }
        for(int[] info : prerequisites){
            //以每节课的基础课为编号存入他的高阶课
            edges.get(info[1]).add(info[0]);
            //计算每个高阶课的入度
            indeg[info[0]]++;
        }
        Queue<Integer> queue = new LinkedList<>();
        //寻找基础课
        for (int i = 0; i < numCourses; i++) {
            if (indeg[i]==0){
                queue.add(i);
            }
        }
        int visited = 0 ;
        //判断是否有基础课
        while (!queue.isEmpty()){
            visited++;
            //将基础课弹出
            int value = queue.poll();
            //寻找该基础课的高阶课
            for (int a : edges.get(value)){
                //令该高阶课的入度减一
                indeg[a]--;
                //如果入度为0则该课为基础课
                if (indeg[a] == 0){
                    queue.add(a);
                }
            }
        }
        //判断是否所有课都可学
        return visited==numCourses;
    }
}