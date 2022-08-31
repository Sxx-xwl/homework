package top.top230;

import com.sun.source.tree.IfTree;

import java.util.ArrayDeque;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * 给定一个二叉搜索树的根节点 root ，和一个整数 k ，请你设计一个算法查找其中第 k 个最小元素（从 1 开始计数）。
 *
 * @author sxx_xwl
 * @version 1.0.0
 * @className top.top230
 * @create 2022-08-31-20:58
 */
public class Top230 {
    public static void main(String[] args) {
        TreeNode root =
                new TreeNode(5,
                        new TreeNode(3,
                                new TreeNode(2,new TreeNode(1),null),
                                new TreeNode(4)),
                        new TreeNode(6));
        System.out.println(new Solution().kthSmallest(root, 3));
    }
}
//复习一下堆

/**
 * class Solution {
 * Queue<TreeNode> queue;
 * <p>
 * public int kthSmallest(TreeNode root, int k) {
 * queue = new PriorityQueue<>((o1, o2) -> o2.val - o1.val);
 * search(root, k);
 * return queue.poll().val;
 * }
 * <p>
 * private void search(TreeNode root, int k) {
 * if (root == null) {
 * return;
 * }
 * queue.add(root);
 * if (queue.size() > k) {
 * queue.poll();
 * }
 * search(root.left,k);
 * search(root.right,k);
 * }
 * }
 */

//中序遍历
class Solution {
    int times = 0;
    int res = 0;

    public int kthSmallest(TreeNode root, int k) {
        search(root, k);
        return res;
    }

    private void search(TreeNode root, int k) {
        if (root == null) {
            return;
        }
        search(root.left, k);
        if (times==k){
            return;
        }else {
            times++;
        }
        res = root.val;
        search(root.right, k);
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    public int getVal() {
        return val;
    }

    public void setVal(int val) {
        this.val = val;
    }

    public TreeNode getLeft() {
        return left;
    }

    public void setLeft(TreeNode left) {
        this.left = left;
    }

    public TreeNode getRight() {
        return right;
    }

    public void setRight(TreeNode right) {
        this.right = right;
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