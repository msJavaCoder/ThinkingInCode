import cn.msjava.coding.ListNode;

import java.util.List;

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
        ListNode former =head;
        ListNode latter=head;
        for (int i = 0; i < k-1; i++) {
            if(former .next!=null){
                former =former .next;
            }else {
                return null;
            }
        }
        while (former .next!=null){
            former =former .next;
            latter=latter.next;
        }
        return latter;
    }
}
