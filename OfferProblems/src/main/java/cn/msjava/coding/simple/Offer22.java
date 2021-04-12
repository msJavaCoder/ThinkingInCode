package cn.msjava.coding.simple;


import cn.msjava.coding.ListNode;

/**
 * msJava
 *
 * @Description 剑指 Offer 22. 链表中倒数第k个节点
 * @Date 2021-02-28
 */
public class Offer22 {
    /**
     * 双指针解法
     * @param head
     * @param k
     * @return
     */
    public ListNode getKthFromEnd(ListNode head, int k) {
        if(head==null || k<0){
            return head;
        }
        // 初始化两个指针
        ListNode pre =head,low=head;
        // 先让pre走k步
        for (int i = 0; i < k-1; i++) {
            if(pre .next!=null){
                pre =pre .next;
            }else {
                return null;
            }
        }
        // pre走了k步之后，两个指针同时走，当pre.next==null的时候，
        //     low指针刚好位于链表中倒数第k个节点
        while (pre .next!=null){
            pre =pre .next;
            low=low.next;
        }
        return low;
    }
}
