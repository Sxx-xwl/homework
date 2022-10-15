package interview04.interview0002;

/**
 * 给定一个有序整数数组，
 * 元素各不相同且按升序排列，
 * 编写一个算法，创建一棵高度最小的二叉搜索树。
 *
 * @author sxx_xwl
 * @version 1.0.0
 * @className interview04.interview0002
 * @create 2022-10-15-10:35
 */
public class Interview0002 {
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
    public TreeNode sortedArrayToBST(int[] nums) {
        return helper(nums, 0, nums.length);
    }

    private TreeNode helper(int[] nums, int l, int r) {
        if (l == r) {
            return null;
        }
        int mid = l + (r - l) / 2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = helper(nums, l, mid);
        root.right = helper(nums, mid+1, r);
        return root;
    }
}