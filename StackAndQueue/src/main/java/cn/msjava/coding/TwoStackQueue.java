package cn.msjava.coding;

import java.util.Stack;

/**
 * msJava
 * @Title   题目要求：编写一个类，用两个栈实现队列，支持队列的基本操作（add,poll,peek)
 * @Description 利用栈的特性：先进后出，两个栈实现一个队列功能的先进先出，
 *              关键就在于，在添加元素之后，一定要保证一次将将stackPush中的元素倒入stackPop中，实现逆序
 *              出队操作就等于stackPop栈中的元素出战。
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
