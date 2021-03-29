package cn.msjava.coding;


import java.util.List;

/**
 * msJava
 *
 * @Description 剑指 Offer 24. 反转链表
 * @Date 2021-02-28
 */
public class Offer24 {


    /**
     * 递归解决 —— 链表反转
     *
     * @param head
     * @return
     */
    public ListNode reverseList_01(ListNode head) {

        if (head == null || head.next == null) {
            return head;
        }
        ListNode next = head.next;
        ListNode newHead = reverseList_01(next);
        next.next = head;
        head.next = null;
        return newHead;
    }


    /**
     * 双指针
     * @param head
     * @return
     */
    public ListNode reverseList_02(ListNode head) {
        // 如果链表为空，那么直接返回null
        if (head == null || head.next == null) {
            return head;
        }
        ListNode first = head;
        //建立一个新的节点用来存放结果
        ListNode reverseHead = null;
        //遍历输入链表，开始处理每一个节点
        while (first != null) {
            //先处理第一个节点first，所以需要一个指针来存储first的后继
            ListNode second = first.next;
            //将first放到新链表头节点的头部
            first.next = reverseHead;
            //移动新链表的头指针，让它始终指向新链表头部
            reverseHead = first;
            //继续处理原链表的节点，即之前指针存放的后继，循环往复
            first = second;
        }
        return reverseHead;
    }

    public ListNode reverseList_03(ListNode head){
        if(head==null){
            return head;
        }
        ListNode reversedHead=null;
        ListNode curNode=head;
        ListNode preNode=null;
        while (curNode!=null){
            // 保存当前节点的下一个节点 防止链表断开   关键点
            ListNode nextNode=curNode.next;
            // 如果当前节点的下一个节点为空，则说明当前节点就是反转之后的链表的头节点
            if(nextNode==null){
                reversedHead=curNode;
            }
            curNode.next=preNode;
            preNode=curNode;
            curNode=nextNode;
        }
        return reversedHead;
    }
}
