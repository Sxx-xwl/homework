package test.test0779;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 我们构建了一个包含 n 行(索引从 1 开始)的表。首先在第一行我们写上一个 0。
 * 接下来的每一行，将前一行中的0替换为01，1替换为10。
 * 例如，对于 n = 3 ，第 1 行是 0 ，第 2 行是 01 ，第3行是 0110 。
 * 给定行数n和序数 k，返回第 n 行中第 k个字符。（k从索引 1 开始）
 *
 * @author sxx_xwl
 * @version 1.0.0
 * @className test.test0779
 * @create 2022-10-20-9:56
 */
public class Test0779 {
    public static void main(String[] args) {

    }
}

class Solution {
    public int kthGrammar(int n, int k) {
        if (n == 1) {
            return 0;
        }
        if (k <= (1 << (n - 2))) {
            return kthGrammar(n - 1, k);
        } else {
            return kthGrammar(n - 1, k - (1 << (n - 2))) ^ 1;
        }
    }
}