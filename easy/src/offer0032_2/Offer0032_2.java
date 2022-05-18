package offer0032_2;

import java.util.ArrayList;
import java.util.List;

/**
 * 从上到下按层打印二叉树，同一层的节点按从左到右的顺序打印，每一层打印到一行。
 *
 * @author sxx_27
 * @create 2022-05-02 16:40
 */
public class Offer0032_2 {

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
    List<List<Integer>> lists = new ArrayList<>();

    public List<List<Integer>> levelOrder(TreeNode root) {

        traverse(root, 0);
        return lists;
    }

    private void traverse(TreeNode root,int index){
        if (root!=null){
            if (lists.size()<=index) {
                lists.add(new ArrayList<Integer>());
            }
            lists.get(index).add(root.val);
            traverse(root.left, index+1);
            traverse(root.right, index+1);
        }
    }
}