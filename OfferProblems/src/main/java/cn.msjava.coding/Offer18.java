package cn.msjava.coding;

/**
 * msJava
 *
 * @Description 剑指 Offer 18. 删除链表的节点
 * @Date 2021-02-28
 */
public class Offer18 {

    /**
     * 双指针
     * @param head
     * @param val
     * @return
     */
    public ListNode deleteNode(ListNode head,int val){

        new StringBuilder();
        if(head==null){
            return null;
        }
        if(head.val==val){
            return head.next;
        }
        ListNode pre=head;
        ListNode cur=head.next;
        while (cur!=null && cur.val!=val){
            pre=cur;
            cur=cur.next;
        }
        if(cur!=null){
            pre.next=cur.next;
        }
        return head;
    }

}
