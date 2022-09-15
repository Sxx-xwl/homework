package tree.binarytree0145;

import javax.swing.tree.TreeNode;
import java.util.ArrayList;
import java.util.List;

/**给你一棵二叉树的根节点 root ，返回其节点值的 后序遍历 。
 * @author sxx_xwl
 * @version 1.0.0
 * @className tree.binarytree0144
 * @create 2022-09-14-22:21
 */
public class Binarytree0145 {
    public static void main(String[] args) {

    }
}

class Solution {
    List<Integer> list = new ArrayList<>();
    public List<Integer> preorderTraversal(TreeNode root) {
        if (root==null) return null;
        list.add(root.val);
        preorderTraversal(root.left);
        preorderTraversal(root.right);
        return list;
    }
}