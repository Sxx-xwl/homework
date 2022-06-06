package top.top101;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 给你一个二叉树的根节点 root
 * 检查它是否轴对称。
 *
 * @author sxx_27
 * @create 2022-06-06 12:59
 */
public class Top101 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1, new TreeNode(2, new TreeNode(3), new TreeNode(4)),
                new TreeNode(2, new TreeNode(3), new TreeNode(4)));
        System.out.println(new Solution().isSymmetric(root));
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    @Override
    public String toString() {
        return "TreeNode{" +
                "val=" + val +
                ", left=" + left +
                ", right=" + right +
                '}';
    }
}

class Solution {
    public boolean isSymmetric(TreeNode root) {

        Queue<TreeNode> queue =new LinkedList<>();
        queue.offer(root.left);
        queue.offer(root.right);
        while (!queue.isEmpty()){
            TreeNode node1 = queue.poll();
            TreeNode node2 = queue.poll();
            if (node1==null&&node2==null){
                continue;
            }
            if (node1==null||node2==null||node2.val!= node1.val){
                return false;
            }
            queue.offer(node1.left);
            queue.offer(node2.right);
            queue.offer(node1.right);
            queue.offer(node2.left);
        }
        return true;
//        return search(root.left, root.right);
    }

    private boolean search(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true;
        }
        if (right == null || left == null) {
            return false;
        }
        if (left.val != right.val) {
            return false;
        }
        return search(left.left, right.right) && search(left.right, right.left);
    }
}