package cn.msjava.coding;

/**
 * msJava
 *
 * @Description
 * @Date 2021-03-15
 */
public class ReverseList {

    public Node reverseList(Node head) {
        // 建立一个新的带假头的新链表
        Node dummy = new Node();
        // 开始遍历旧链表
        while (head != null) {
            Node tmp = head.next;
            // 把旧链表中的结点取出来，采用头部插入的方法添加到新链表中
            head.next = dummy.next;
            dummy.next = head;
            head = tmp;
        }
        // 返回新链表的头，注意，不要返回dummy!!
        return dummy.next;
    }
}
