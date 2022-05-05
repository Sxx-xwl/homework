package test0036;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 请你判断一个9 x 9 的数独是否有效。只需要 根据以下规则 ，验证已经填入的数字是否有效即可。
 * 数字1-9在每一行只能出现一次。
 * 数字1-9在每一列只能出现一次。
 * 数字1-9在每一个以粗实线分隔的3x3宫内只能出现一次。（请参考示例图）
 * 注意：
 * 一个有效的数独（部分已被填充）不一定是可解的。
 * 只需要根据以上规则，验证已经填入的数字是否有效即可。
 * 空白格用'.'表示
 *
 * @author sxx_27
 * @create 2022-04-05 19:55
 */
public class Test0036 {

    public static void main(String[] args) {

        char[][] cha = {{'.','.','.','.','5','.','.','1','.'},
                        {'.','4','.','3','.','.','.','.','.'},
                        {'.','.','.','.','.','3','.','.','1'},
                        {'8','.','.','.','.','.','.','2','.'},
                        {'.','.','2','.','7','.','.','.','.'},
                        {'.','1','5','.','.','.','.','.','.'},
                        {'.','.','.','.','.','2','.','.','.'},
                        {'.','2','.','9','.','.','.','.','.'},
                        {'.','.','4','.','.','.','.','.','.'}};
        boolean validSudoku = new Solution().isValidSudoku(cha);
        System.out.println(validSudoku);
    }
}

class Solution {
    public boolean isValidSudoku(char[][] board) {

        Map<Integer, Set<Integer>> map = new HashMap<>();
        Map<Integer, Set<Integer>> rmap = new HashMap<>();
        Map<Integer, Set<Integer>> cmap = new HashMap<>();
        int r = board.length;
        int c = board[0].length;
        for (int i = 0; i < 9; i++) {
            map.put(i, new HashSet<>());
            rmap.put(i, new HashSet<>());
            cmap.put(i, new HashSet<>());
        }
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                int cha = board[i][j];
                if (board[i][j] != '.')
                {
                    if (rmap.get(i).contains(cha) || cmap.get(j).contains(cha) || map.get(i / 3 * 3 + j / 3).contains(cha))
                    {
                        return false;
                    }
                    rmap.get(i).add(cha);
                    cmap.get(j).add(cha);
                    map.get(i / 3 * 3 + j / 3).add(cha);
                }
            }
        }
        return true;
    }
    public boolean isValidSudoku0(char[][] board) {

        Set<Character> set = new HashSet<>();
        Set<Character> rset = new HashSet<>();
        Set<Character> cset = new HashSet<>();
        int i = 0, row = 0, cul = 0;
        int r = board.length;
        int c = board[0].length;
        while (i < r * c)
        {
            if (i % 9 == 0)
            {
                rset.clear();
                cset.clear();
                set.clear();
            }
            if (board[i / c][i % c]!='.')
            {
                int l1 = rset.size();
                rset.add(board[i / c][i % c]);
                int l2 = rset.size();
                if (l1 == l2)
                {
                    return false;
                }
            }
            if (board[i % c][i / c]!='.')
            {
                int l3 = cset.size();
                cset.add(board[i % c][i / c]);
                int l4 = cset.size();
                if (l3 == l4)
                {
                    return false;
                }
            }
            row = i / 27;
            if (board[i / 3 - row * 9][i % 3 + row * 3]!='.')
            {
                int l5 = set.size();
                set.add(board[i / 3 - row * 9][i % 3 + row * 3]);
                int l6 = set.size();
                if (l5 == l6)
                {
                    return false;
                }
            }
            i++;
        }
        return true;
    }
}
