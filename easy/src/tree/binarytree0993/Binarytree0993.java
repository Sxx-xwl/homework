package tree.binarytree0993;

/**
 * 在二叉树中，根节点位于深度 0 处，每个深度为 k 的节点的子节点位于深度 k+1 处。
 * 如果二叉树的两个节点深度相同，但 父节点不同 ，则它们是一对堂兄弟节点。
 * 我们给出了具有唯一值的二叉树的根节点 root ，以及树中两个不同节点的值 x 和 y 。
 * 只有与值 x 和 y 对应的节点是堂兄弟节点时，才返回 true 。否则，返回 false。
 *
 * @author sxx_xwl
 * @version 1.0.0
 * @className tree.binarytree0993
 * @create 2022-10-10-13:33
 */
public class Binarytree0993 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1,
                new TreeNode(2, new TreeNode(5), new TreeNode(3)),
                new TreeNode(4));
        System.out.println(new Solution().isCousins(root, 4, 5));
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

class Solution {
    int xDep, yDep, xPre, yPre;

    public boolean isCousins(TreeNode root, int x, int y) {
        if(root.val == x|| root.val ==y)return false;
        searchDep(root.left, x, y, 0, root.val);
        searchDep(root.right, x, y, 0, root.val);
        return (xDep == yDep) && (xPre != yPre);
    }

    private void searchDep(TreeNode root, int x, int y, int dep, int preVal) {
        if (root == null) {
            return;
        }
        if (root.val == x) {
            xDep = dep;
            xPre = preVal;
        } else if (root.val == y) {
            yDep = dep;
            yPre = preVal;
        }
        searchDep(root.left, x, y, dep + 1, root.val);
        searchDep(root.right, x, y, dep + 1, root.val);
    }
}