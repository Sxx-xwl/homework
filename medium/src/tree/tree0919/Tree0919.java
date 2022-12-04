package tree.tree0919;

import java.util.*;
import java.util.concurrent.DelayQueue;

/**
 * 完全二叉树 是每一层（除最后一层外）都是完全填充（即，节点数达到最大）的，并且所有的节点都尽可能地集中在左侧。
 * 设计一种算法，将一个新节点插入到一个完整的二叉树中，并在插入后保持其完整。
 * 实现 CBTInserter 类:
 * CBTInserter(TreeNode root) 使用头节点为 root 的给定树初始化该数据结构；
 * CBTInserter.insert(int v)  向树中插入一个值为 Node.val == val的新节点 TreeNode。
 * 使树保持完全二叉树的状态，并返回插入节点 TreeNode 的父节点的值；
 * CBTInserter.get_root() 将返回树的头节点
 * https://leetcode.cn/problems/complete-binary-tree-inserter/
 *
 * @author sxx_xwl
 * @version 1.0.0
 * @className tree.tree0919
 * @create 2022-12-04-12:27
 */
public class Tree0919 {
    public static void main(String[] args) {

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
}

class CBTInserter {
    TreeNode curRoot;
    Deque<TreeNode> deque;

    public CBTInserter(TreeNode root) {
        deque = new LinkedList<>();
        curRoot = root;
        deque.push(root);
        while (true) {
            TreeNode temp = deque.peekFirst();
            if (temp.left != null) {
                deque.addLast(temp.left);
            }
            if (temp.right != null) {
                deque.addLast(temp.right);
            }
            if (temp.left != null && temp.right != null) {
                deque.removeFirst();
            } else {
                break;
            }
        }
    }

    public int insert(int val) {
        TreeNode temp = deque.peekFirst();
        if (temp.left == null) {
            temp.left = new TreeNode(val);
            deque.addLast(temp.left);
            return temp.val;
        }
        temp.right = new TreeNode(val);
        deque.addLast(temp.right);
        deque.removeFirst();
        return temp.val;
    }

    public TreeNode get_root() {
        return curRoot;
    }
}