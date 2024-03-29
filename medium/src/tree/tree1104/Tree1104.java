package tree.tree1104;

import java.util.ArrayList;
import java.util.List;

/**
 * 在一棵无限的二叉树上，每个节点都有两个子节点，树中的节点 逐行 依次按 “之” 字形进行标记。
 * 如下图所示，在奇数行（即，第一行、第三行、第五行……）中，按从左到右的顺序进行标记；
 * 而偶数行（即，第二行、第四行、第六行……）中，按从右到左的顺序进行标记。
 * 给你树上某一个节点的标号 label，请你返回从根节点到该标号为 label 节点的路径，该路径是由途经的节点标号所组成的。
 * https://leetcode.cn/problems/path-in-zigzag-labelled-binary-tree/
 *
 * @author sxx_xwl
 * @version 1.0.0
 * @className tree.tree1104
 * @create 2022-12-06-13:26
 */
public class Tree1104 {
    public static void main(String[] args) {
        System.out.println(new Solution().pathInZigZagTree(26));
    }
}

class Solution {
    public List<Integer> pathInZigZagTree(int label) {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        int heigh = 2, time = 1;
        while (heigh <= label) {
            heigh = heigh << 1;
            time++;
            list.add(1);
        }
        int index = list.size() - 1, temp;
        if (time % 2 == 0) {
            temp = heigh - label - 1;
        } else {
            temp = label - heigh / 2;
        }
        list.set(index--, label);
        time--;
        while (index > 0) {
            temp /= 2;
            heigh /= 2;
            if (time-- % 2 == 0) {
                list.set(index--, heigh - temp - 1);
            } else {
                list.set(index--, heigh/2 + temp);
            }
        }
        return list;
    }
}