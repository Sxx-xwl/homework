package test.test1812;

/**
 * 给你一个坐标 coordinates ，它是一个字符串，
 * 表示国际象棋棋盘中一个格子的坐标。下图是国际象棋棋盘示意图。
 * 如果所给格子的颜色是白色，请你返回 true，如果是黑色，请返回 false 。
 * 给定坐标一定代表国际象棋棋盘上一个存在的格子。坐标第一个字符是字母，第二个字符是数字。
 *
 * @author sxx_xwl
 * @version 1.0.0
 * @className test.test1812
 * @create 2022-12-08-11:32
 */
public class Test1812 {
    public static void main(String[] args) {

    }
}

class Solution {
    public boolean squareIsWhite(String coordinates) {
        return (coordinates.charAt(0) - 'a' + coordinates.charAt(1) - '0') % 2 == 0;
    }
}