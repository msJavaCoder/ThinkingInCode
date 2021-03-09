package cn.msjava.coding;

import java.util.Stack;

/**
 * @author msJava
 * @Description: 1047. 删除字符串中的所有相邻重复项  简单
 */
public class RemoveDuplicates {
     public static void main(String[] args) {
          String s = removeDuplicates("abbaca");
          System.out.println(s);
     }



     public static String removeDuplicates(String s){
          Stack<Character> stack = new Stack<Character>();
          char[] array = s.toCharArray();
          for (char c : array) {
               if(stack.isEmpty() || stack.peek()!=c ){
                    stack.push(c);
               }else {
                    stack.pop();
               }
          }

          StringBuilder sb = new StringBuilder();

          for (Character c : stack) {
               sb.append(c);
          }
          return sb.toString();
     }

}
