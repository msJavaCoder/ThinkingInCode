import cn.msjava.coding.ListNode;

import java.util.ArrayList;
import java.util.Stack;

/**
 * msJava 剑指 Offer 06. 从尾到头打印链表
 *
 * @Description
 * @Date 2021-02-28
 */
public class Offer06 {

    ArrayList<Integer> temp = new ArrayList<Integer>();

    /**
     * 利用栈 先进后出的特性
     * @param head
     * @return
     */
    public int[] reversePrint_01(ListNode head) {
        Stack<ListNode> stack = new Stack<ListNode>();
        ListNode temp = head;
        // 链表元素入栈操作
        while (temp != null) {
            stack.push(temp);
            temp = temp.next;
        }
        int size = stack.size();
        int[] array = new int[size];
        for (int i = 0; i < size; i++) {
            array[i] = stack.pop().val;
        }
        return array;
    }

    /**
     * 递归思想
     * @param head
     * @return
     */
    public int[] reversePrint_02(ListNode head) {
        recur(head);
        int[] res = new int[temp.size()];
        for(int i = 0; i < res.length; i++) {
            res[i] = temp.get(i);
        }
        return res;
    }

    private void recur(ListNode head) {
        if(head == null) {
            return;
        }
        recur(head.next);
        temp.add(head.val);
    }

}
