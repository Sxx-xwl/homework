import java.util.*;

/**
 * @Classname M
 * @Version 1.0.0
 * @Date 2022/7/6 19:12
 * @Created by sxx_xwl
 */
public class M {
    public static void main(String[] args) {

    }

}
//
//class Solution {
//    public TreeNode oneSide(List<Integer> preorder, List<Integer> inorder) {
//        if (preorder.isEmpty() || inorder.isEmpty()) {
//            return null;
//        }
//        TreeNode r = new TreeNode(preorder.get(0));
//        List<Integer> leftIn = new LinkedList<>();
//        while (!inorder.isEmpty()) {
//            if (Objects.equals(preorder.get(0), inorder.get(0))) {
//                inorder.remove(0);
//                break;
//            }
//            leftIn.add(inorder.remove(0));
//        }
//        preorder.remove(0);
//        r.left = oneSide(preorder, leftIn);
//        r.right = oneSide(preorder, inorder);
//        return r;
//    }
//
//    public TreeNode buildTree(int[] preorder, int[] inorder) {
//        List<Integer> p = new LinkedList<>();
//        List<Integer> i = new LinkedList<>();
//        for (int num : preorder) {
//            p.add(num);
//        }
//        for (int num : inorder) {
//            i.add(num);
//        }
//        return oneSide(p, i);
//    }
//}
