package offer.offer0031;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 输入两个整数序列，第一个序列表示栈的压入顺序，
 * 请判断第二个序列是否为该栈的弹出顺序。
 * 假设压入栈的所有数字均不相等。
 * 例如，序列 {1,2,3,4,5} 是某栈的压栈序列，
 * 序列 {4,5,3,2,1} 是该压栈序列对应的一个弹出序列，
 * 但 {4,3,5,1,2} 就不可能是该压栈序列的弹出序列。
 *
 * @author sxx_27
 * @create 2022-05-15 19:16
 */
public class Offer0031 {
    public static void main(String[] args) {
        int[] pushed = {1, 2, 3, 4, 5};
        int[] popped = {4, 3, 5, 1, 2};
        System.out.println(new Solution().validateStackSequences(pushed, popped));
    }
}

class Solution {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        if (pushed.length == 0) {
            return true;
        }
        Deque<Integer> stack1 = new ArrayDeque<>();
        int index = 0;
        for (int i = 0; i < pushed.length; i++) {
            stack1.push(pushed[i]);
            while (!stack1.isEmpty()) {
                if (stack1.peek() == popped[index]) {
                    stack1.pop();
                    index++;
                } else {
                    break;
                }
            }
        }
        return stack1.isEmpty();
    }
}