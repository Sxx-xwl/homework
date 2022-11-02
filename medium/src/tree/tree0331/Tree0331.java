package tree.tree0331;

import sun.security.util.Length;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 序列化二叉树的一种方法是使用 前序遍历 。
 * 当我们遇到一个非空节点时，我们可以记录下这个节点的值。
 * 如果它是一个空节点，我们可以使用一个标记值记录，例如 #。
 * 例如，上面的二叉树可以被序列化为字符串 "9,3,4,#,#,1,#,#,2,#,6,#,#"，
 * 其中 # 代表一个空节点。
 * 给定一串以逗号分隔的序列，验证它是否是正确的二叉树的前序序列化。
 * 编写一个在不重构树的条件下的可行算法。
 * 保证 每个以逗号分隔的字符或为一个整数或为一个表示 null 指针的 '#' 。
 * 你可以认为输入格式总是有效的
 * 例如它永远不会包含两个连续的逗号，比如"1,,3" 。
 * 注意：不允许重建树
 *
 * @author sxx_xwl
 * @version 1.0.0
 * @className tree.tree0331
 * @create 2022-11-02-19:13
 */
public class Tree0331 {
    public static void main(String[] args) {
        String s = "9,#,92,#,#";
        boolean validSerialization = new Solution().isValidSerialization(s);
        System.out.println(validSerialization);
    }
}

class Solution {
    public boolean isValidSerialization(String preorder) {
        int length = preorder.length(), index = 0, count = 1;
        while (index < length) {
            if (count == 0) {
                return false;
            }
            char cur = preorder.charAt(index++);
            if (cur == ',') {
            } else if (cur == '#') {
                count--;
            } else {
                count++;
                while (index < length && preorder.charAt(index) != ',') {
                    index++;
                }
            }
        }
        return count == 0;
    }
}