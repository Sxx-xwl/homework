package test.test606;

/**
 * @author sxx_27
 * @create 2022-03-19 20:30
 */
public class Test606 {

    public static void main(String[] args) {

        Solution s = new Solution();
        TreeNode root = new TreeNode(1,new TreeNode(2, null,new TreeNode(4, null, null)),new TreeNode(3, null, null));
        String s1 = s.tree2str(root);
        System.out.println(s1);

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
    public String tree2str(TreeNode root) {
        String str;
        StringBuffer sb = new StringBuffer();
        int letf = 0;

        preOrder(root, sb, letf);
        if (sb.length() > 1)
        {
            sb.delete(sb.length() - 1, sb.length());
        }
        str = String.valueOf(sb);
//        str = str.replace("()", "");
        return str;
    }

    public void preOrder(TreeNode root, StringBuffer sb, int left) {

        int flag = 0;
        //中间节点加入
        if (root != null) {
            sb.append(root.val);
        }
        //添加左节点
        if (root.left != null) {
            sb.append("(");
            left++;
            preOrder(root.left, sb, left);
        } else {
            flag++;
            sb.append("()");
        }
        //添加右节点
        if (root.right != null) {
            sb.append("(");
            left++;
            preOrder(root.right, sb, left);
        } else {
            flag++;
        }
        if (flag == 2) {
            sb.delete(sb.length() - 2, sb.length());
        }
        if (left > 0) {
            left--;
            sb.append(")");
        }
    }

    public void dfs(TreeNode root ,StringBuffer sb){

        sb.append("(");
        sb.append(root.val);
        if (root.left!=null) {
            dfs(root.left,sb);
        }else if (root.left==null&&root.right!=null)
        {
            sb.append("()");
        }
        if (root.right!=null)
        {
            dfs(root.right,sb);
        }
        sb.append(")");
    }

}