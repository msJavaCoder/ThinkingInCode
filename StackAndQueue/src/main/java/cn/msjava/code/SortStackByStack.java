package cn.msjava.code;

import java.util.Stack;

/**
 * msJava
 *
 * @Title 用一个栈实现另一个栈的排序
 * @Description
 * @Date 2020-10-02
 */
public class SortStackByStack {

    public static  void sortStackByStack(Stack<Integer> stack){
        Stack<Integer> help = new Stack<Integer>();
        while (!stack.isEmpty()){
            int cur=stack.pop();
            while (!help.isEmpty() && help.peek()<cur){
                stack.push(help.pop());
            }
            help.push(cur);
        }
        while (!help.isEmpty()){
            stack.push(help.pop());
        }

    }
}
