package test.test0754;

/**
 * 在一根无限长的数轴上，你站在0的位置。终点在target的位置。
 * 你可以做一些数量的移动 numMoves :
 * 每次你可以选择向左或向右移动。
 * 第 i 次移动（从  i == 1 开始，到 i == numMoves ），在选择的方向上走 i 步。
 * 给定整数 target ，返回 到达目标所需的 最小 移动次数(即最小 numMoves ) 。
 *
 * @author sxx_xwl
 * @version 1.0.0
 * @className test.test0754
 * @create 2022-11-04-16:10
 */
public class Test0754 {
    public static void main(String[] args) {

    }
}

class Solution {
    public int reachNumber(int target) {
        target = target < 0 ? -target : target;
        int res = 0, cur = 1;
        while (res < target) {
            res += cur++;
        }
        if ((res - target) % 2 == 0) {
            return cur - 1;
        }
        int temp = res + cur - target;
        if (temp % 2 == 0) {
            return cur;
        }
        return cur + 1;
    }
}