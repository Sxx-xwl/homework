package tree.tree0623;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

/**
 * 给定一个二叉树的根 root 和两个整数 val 和 depth ，
 * 在给定的深度 depth 处添加一个值为 val 的节点行。
 * 注意，根节点 root 位于深度 1 。
 * 加法规则如下:
 * 给定整数 depth，对于深度为 depth - 1 的每个非空树节点 cur ，
 * 创建两个值为 val 的树节点作为 cur 的左子树根和右子树根。
 * cur 原来的左子树应该是新的左子树根的左子树。
 * cur 原来的右子树应该是新的右子树根的右子树。
 * 如果 depth == 1 意味着 depth - 1 根本没有深度，
 * 那么创建一个树节点，值 val 作为整个原始树的新根，而原始树就是新根的左子树。
 * https://leetcode.cn/problems/add-one-row-to-tree/
 *
 * @author sxx_xwl
 * @version 1.0.0
 * @className tree.tree0623
 * @create 2022-11-19-14:53
 */
public class Tree0623 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(4,
                new TreeNode(2,
                        new TreeNode(3), new TreeNode(1)), null);
        System.out.println(new Solution().addOneRow(root, 1, 3));
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
    private Queue<TreeNode> queue;
    private int depth;

    public TreeNode addOneRow(TreeNode root, int val, int depth) {
        if (depth == 1) {
            TreeNode cur = new TreeNode(val);
            cur.left = root;
            return cur;
        } else {
            queue = new LinkedList<>();
            this.depth = depth;
            addOneRow(root, 2);
            while (!queue.isEmpty()) {
                TreeNode poll = queue.poll();
                TreeNode temp = poll.left;
                poll.left = new TreeNode(val);
                poll.left.left = temp;
                temp = poll.right;
                poll.right = new TreeNode(val);
                poll.right.right = temp;
            }
            return root;
        }
    }

    private void addOneRow(TreeNode root, int flag) {
        if (root == null || flag > depth) {
            return;
        }
        addOneRow(root.left, flag + 1);
        if (flag == depth) {
            queue.offer(root);
        }
        addOneRow(root.right, flag + 1);
    }
}