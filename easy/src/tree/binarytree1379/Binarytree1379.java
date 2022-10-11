package tree.binarytree1379;

/**
 * 给你两棵二叉树，原始树 original 和克隆树 cloned，以及一个位于原始树 original中的目标节点target。
 * 其中，克隆树 cloned是原始树 original的一个 副本 。
 * 请找出在树cloned中，与target相同的节点，并返回对该节点的引用（在 C/C++ 等有指针的语言中返回 节点指针，其他语言返回节点本身）。
 * 注意：你 不能 对两棵二叉树，以及 target节点进行更改。只能 返回对克隆树cloned中已有的节点的引用。
 *
 * @author sxx_xwl
 * @version 1.0.0
 * @className tree.binarytree1379
 * @create 2022-10-11-11:42
 */
public class Binarytree1379 {
    public static void main(String[] args) {

    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

class Solution {
    public final TreeNode getTargetCopy(final TreeNode original, final TreeNode cloned, final TreeNode target) {
        if (cloned == null) return null;
        if (cloned.val == target.val) return cloned;
        else {
            TreeNode l = getTargetCopy(original, cloned.right, target);
            TreeNode r = getTargetCopy(original, cloned.left, target);
            return l == null ? r : l;
        }
    }
}