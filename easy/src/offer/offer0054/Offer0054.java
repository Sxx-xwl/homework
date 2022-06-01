package offer.offer0054;

import java.util.List;

/**
 * 给定一棵二叉搜索树，请找出其中第 k 大的节点的值
 *
 * @author sxx_27
 * @create 2022-05-06 17:00
 */
public class Offer0054 {
    public static void main(String[] args) {

        TreeNode root = new TreeNode(5, new TreeNode(3, new TreeNode(2, new TreeNode(1), null), new TreeNode(4)), new TreeNode(6));
//        TreeNode root = new TreeNode(5, new TreeNode(3), new TreeNode(4));
        int i = new Solution().kthLargest(root, 3);
        System.out.println(i);

    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    TreeNode(int x) {
        val = x;
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
    int res;
    int index = 0;

    public int kthLargest(TreeNode root, int k) {
//        List<Integer> list = new ArrayList<>();
//        search0(root, list);
//        int size = list.size();
//        int target = size - k;
//        return list.get(target);


//        res = new int[k];
//        search(root, k);
//        Arrays.sort(res);
//        return res[0];
        search(root, k);
        return res;
    }

    private void search0(TreeNode root, List<Integer> list) {
        if (root == null) {
            return;
        }
        search0(root.left, list);
        list.add(root.val);
        search0(root.right, list);
    }

    private void search1(TreeNode root, int k) {
        if (root == null) {
            return;
        }
        search1(root.left, k);
//        res[index % k] = root.val;
        index++;
        search1(root.right, k);
    }

    private void search(TreeNode root, int k) {
        if (root.right != null && index < k) search(root.right, k);

        if (++index == k) {
            res = root.val;
            return;
        }

        if (root.left != null && index < k) search(root.left, k);
    }
}