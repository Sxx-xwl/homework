package top.top108;

/**
 * 给你一个整数数组 nums ，其中元素已经按 升序 排列，
 * 请你将其转换为一棵 高度平衡 二叉搜索树。
 * 高度平衡 二叉树是一棵满足「每个节点的左右两个子树的高度差的绝对值不超过 1 」的二叉树。
 *
 * @author sxx_27
 * @create 2022-06-07 10:02
 */
public class Top108 {
    public static void main(String[] args) {

        System.out.println(new Solution().sortedArrayToBST(new int[]{0, 1, 2, 3, 4, 5}));
    }
}

class Solution {
    public TreeNode sortedArrayToBST(int[] nums) {
        return  helper(nums, 0, nums.length-1);
    }
    private TreeNode helper(int[] nums , int left ,int right){
        if (left > right){
            return null;
        }
        int mid = (left + right) / 2 ;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = helper(nums, left, mid - 1);
        root.right = helper(nums, mid + 1, right);
        return root;
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
