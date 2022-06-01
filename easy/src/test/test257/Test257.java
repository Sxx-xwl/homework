package test.test257;

import java.util.ArrayList;
import java.util.List;

/**给你一个二叉树的根节点 root ，按 任意顺序 ，返回所有从根节点到叶子节点的路径。
 叶子节点 是指没有子节点的节点。
 * @author sxx_27
 * @create 2022-03-20 21:15
 */
public class Test257 {

    public static void main(String[] args) {

//[37,-34,-48,null,-100,-100,48,null,null,null,null,-54,null,-71,-22,null,null,null,8]
        Solution s = new Solution();
        TreeNode root = new TreeNode(1, new TreeNode(2, null, new TreeNode(5)), new TreeNode(3));
        List<String> strings = s.binaryTreePaths(root);
        strings.forEach(System.out::println);

    }

}

class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }

class Solution {
    StringBuilder sb = new StringBuilder();
    List<String> list = new ArrayList<>();

    public List<String> binaryTreePaths(TreeNode root) {

        backtracking(root, sb);

//        dfs(root, sb);

        return list;
    }

    public void backtracking(TreeNode root, StringBuilder sb){

        if (root.left == null && root.right == null)
        {
            sb.append(root.val);
            list.add(sb.toString());
            return;
        }

        sb.append(root.val + "->");
        if (root.left!=null) {
            backtracking(root.left, new StringBuilder(sb));
        }
        if (root.right!=null) {
            backtracking(root.right, new StringBuilder(sb));
        }

    }    //3.24复习
    public void backtracking0(TreeNode root, StringBuilder sb) {

        if (root.left == null && root.right == null) {
            sb.append(root.val);
            list.add(sb.toString());
            return;
        }
        sb.append(root.val);
        sb.append("->");
        if (root.left != null) {
            backtracking(root.left, new StringBuilder(sb));
        }
        if (root.right != null) {
            backtracking(root.right, new StringBuilder(sb));
        }
    }
    private void dfs(TreeNode root,StringBuilder sb){
        sb.append(root.val);
        if(root.left==null&&root.right==null){
            list.add(sb.toString());
            return;
        }
        if(root.left!=null) {
            dfs(root.left,new StringBuilder(sb).append("->"));
        }
        if(root.right!=null) {
            dfs(root.right,new StringBuilder(sb).append("->"));
        }
    }
}