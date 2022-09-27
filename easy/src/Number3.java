import java.util.*;

/**
 * @author sxx_xwl
 * @version 1.0.0
 * @className PACKAGE_NAME
 * @create 2022-09-27-21:38
 */
public class Number3 {
    static int reslut = Integer.MIN_VALUE;
    static int max = 0;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        // 注意 while 处理多个 case
        List<String> list = new ArrayList<>();
        while (in.hasNextLine()) {
            list.add(in.nextLine());
        }
        //得到节点个数
        String str = list.get(1);
        String[] s = str.split(" ");
        int[] values = new int[s.length];
        int index = 0;
        //得到节点值
        for (String cur : s) {
            values[index++] = Integer.parseInt(cur);
        }
        str = list.get(2);
        s = str.split(" ");
        int[] nums = new int[s.length];
        index = 0;
        //得到节点指针
        for (String cur : s) {
            nums[index++] = Integer.parseInt(cur);
        }
        Tree tree = createTree(values, nums);
        search(tree);
        System.out.println(reslut);
    }

    static private void search(Tree root) {
        if (root == null) {
            return;
        }
        search(root.getLeftTree());
        if (max + root.getValue() < 0) {
            reslut = Math.max(reslut, max);
            max = root.getValue();
        } else {
            max += root.getValue();
            reslut = Math.max(reslut, max);
        }
        search(root.getRightTree());
    }

    static private Tree createTree(int[] values, int[] nums) {
        Tree root = new Tree();
        List<Tree> treeList = new ArrayList<>();
        root.setValue(values[0]);
        treeList.add(root);
        int len = values.length;
        for (int i = 1; i < len; i++) {
            int num = nums[i] - 1;
            Tree tree = treeList.get(num);
            Tree temp = new Tree(values[i]);
            if (tree.getLeftTree() == null) {
                tree.setLeftTree(temp);
            } else {
                tree.setRightTree(temp);
            }
            treeList.add(temp);
        }
        return root;
    }
}

class Tree {
    private int value;
    private Tree leftTree;
    private Tree rightTree;

    public Tree() {
    }

    public Tree(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public Tree getLeftTree() {
        return leftTree;
    }

    public void setLeftTree(Tree leftTree) {
        this.leftTree = leftTree;
    }

    public Tree getRightTree() {
        return rightTree;
    }

    public void setRightTree(Tree rightTree) {
        this.rightTree = rightTree;
    }
}
