package cn.msjava.code;

import java.util.Stack;

/**
 * msJava
 *
 * @Title 仅采用递归思想和栈操作逆序一个栈
 * @Description
 * @Date 2020-10-01
 */
public class RecursiveReverseStack {


    /**
     * 逆序一个栈
     *
     * @param stack
     */
    public static void reverse(Stack<Integer> stack) {
        if (stack.isEmpty()) {
            return;
        }
        int element = getAndRemoveLastElement(stack);
        reverse(stack);
        stack.push(element);
    }

    /**
     * 将栈的栈底元素返回并移除
     *
     * @param stack
     * @return
     */
    public static int getAndRemoveLastElement(Stack<Integer> stack) {
        int result = stack.pop();
        if (stack.isEmpty()) {
            return result;
        } else {
            int lastElement = getAndRemoveLastElement(stack);
            stack.push(result);
            return lastElement;
        }


    }

}
