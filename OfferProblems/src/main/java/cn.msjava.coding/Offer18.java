package cn.msjava.coding;

/**
 * msJava
 *
 * @Description 剑指 Offer 18. 删除链表的节点
 * @Date 2021-02-28
 */
public class Offer18 {

    /**
     * 双指针解法
     * @param head  链表头节点
     * @param val   要删除的值
     * @return
     */
    public ListNode deleteNode_01(ListNode head,int val){

        /**
         * 如果链表为空，
         *      那么直接返回null
         */
        if(head==null){
            return null;
        }
        /**
         * 如果删除的是头节点，
         *      那么直接返回头节点的下一个节点即可
         */
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


    /**
     *  虚拟头节点+双指针
     * @param head
     * @param val
     * @return
     */
    public ListNode deleteNode_02(ListNode head, int val) {
        // 如果链表为空，那么直接返回null
        if(head==null){
            return null;
        }
        // 如果删除的是头节点，那么直接返回头节点的下一个节点即可
        if(head.val==val){
            return head.next;
        }
        ListNode dummy = new ListNode();
        // 将虚拟节点指向头节点
        dummy.next = head;
        // 初始化两个指针节点
        ListNode pre = dummy,cur = head;
        // 循环终止时,cur刚好位于需要删除的节点位置
        while(cur.val != val && cur!=null){
            pre = cur;
            cur = cur.next;
        }
        // 删除节点操作
        pre.next = cur.next;
        return dummy.next;
    }

}
