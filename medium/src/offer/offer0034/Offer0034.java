package offer.offer0034;

import java.util.*;

/**
 * 给你二叉树的根节点 root 和一个整数目标和 targetSum ，
 * 找出所有 从根节点到叶子节点 路径总和等于给定目标和的路径。
 * 叶子节点 是指没有子节点的节点。
 *
 * @author sxx_27
 * @create 2022-05-19 13:04
 */
public class Offer0034 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(5, new TreeNode(4, new TreeNode(11,new TreeNode(7),new TreeNode(2)), null)
                , new TreeNode(8, new TreeNode(13), new TreeNode(4, new TreeNode(5), new TreeNode(1))));
        List<List<Integer>> listList = new Solution().pathSum(root, 22);
        for(List<Integer> list : listList){
            System.out.println(Arrays.toString(new List[]{list}));
        }
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
    List<List<Integer>> listList = new ArrayList<>();
    List<Integer> list = new ArrayList<>();

    List<List<Integer>> ret = new LinkedList<>();
    Deque<Integer> path = new LinkedList<>();

    public List<List<Integer>> pathSum(TreeNode root, int target) {
//        if (root == null) {
//            return listList;
//        }
//        search(root, target, 0);
//        return listList;
        if (root == null) {
            return ret;
        }
        dfs(root, target);
        return ret;
    }

    private void search0(TreeNode root, int target, int sum) {
        if (root == null) {
            return;
        }
        list.add(root.val);
        sum += root.val;
        if (root.left==null&&root.right==null&&sum == target){
            listList.add(new ArrayList<>(list));
        }
        search0(root.left, target, sum);
        search0(root.right, target, sum);
        list.remove(list.size()-1);
    }

    public void dfs(TreeNode root, int target) {
        if (root == null) {
            return;
        }
        path.offerLast(root.val);
        target -= root.val;
        if (root.left == null && root.right == null && target == 0) {
            ret.add(new LinkedList<>(path));
        }
        dfs(root.left, target);
        dfs(root.right, target);
        path.pollLast();
    }
}