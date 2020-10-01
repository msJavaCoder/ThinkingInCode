package cn.msjava.code;

import java.util.Stack;

/**
 * msJava
 *
 * @Description 有两个栈组成的队列，利用栈的特性：先进后出，两个栈实现一个队列功能的先进先出，
 *                        关键就在于，在添加元素之后，一定要保证一次将将stackPush中的元素倒入stackPop中，实现逆序
 *                        出队操作就等于stackPop栈中的元素出战。
 * @Date 2020-10-01 15:25
 */
public class TwoStackQueue<T> {
      private Stack<T> stackPush;
      private Stack<T> stackPop;

      public TwoStackQueue(){
          stackPush = new Stack<T>();
          stackPop = new Stack<T>();
      }

    /**
     * 将stackPush中的元素倒入stackPop中，实现逆序
     */
    public void pushToPop(){
          if(stackPop.isEmpty()){
              while (!stackPush.isEmpty()){
                  stackPop.push(stackPush.pop());
              }
          }
      }

      public void add(T pushInt){
          stackPush.push(pushInt);
          pushToPop();
      }

      public T poll(){
          if(stackPush.isEmpty()&&stackPop.isEmpty()){
              throw  new RuntimeException("队列为空！");
          }
          pushToPop();
          return stackPop.pop();
      }

      public T peek(){
          if(stackPush.isEmpty()&&stackPop.isEmpty()){
              throw  new RuntimeException("队列为空！");
          }
          pushToPop();
          return stackPop.peek();
      }




}
