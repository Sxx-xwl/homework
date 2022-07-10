/**
 * @Classname Node
 * @Version 1.0.0
 * @Date 2022/7/10 14:26
 * @Created by sxx_xwl
 */
public class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
