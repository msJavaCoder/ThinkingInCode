import java.util.Stack;

/**
 * msJava
 *
 * @Description 剑指 Offer 09. 用两个栈实现队列
 * @Date 2021-02-28
 */
public class Offer09 {

    Stack<Integer> stack1;
    Stack<Integer> stack2;

    public Offer09() {
        stack1=new Stack<Integer>();
        stack2=new Stack<Integer>();
    }

    /**
     * 入队操作
     * @param value
     */
    public void appendTail(int value) {
         stack1.push(value);
    }

    /**
     * 出队操作
     * @return
     */
    public int deleteHead() {
         if(stack2.isEmpty()){
             while (!stack1.isEmpty()){
                 stack2.push(stack1.pop());
             }
         }
         // 两个栈都为空  直接返回-1
         if(stack2.isEmpty()){
             return -1;
         }
         return stack2.pop();
    }

}
