/**
 * msJava
 *
 * @Description 剑指 Offer 25. 合并两个排序的链表
 * @Date 2021-02-28
 */
public class Offer25 {

    /**
     * 双指针
     *
     * @param l1
     * @param l2
     * @return
     */
    public ListNode mergeTwoLists_01(ListNode l1, ListNode l2) {

        ListNode dum = new ListNode(0);
        ListNode cur = dum;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                cur.next = l1;
                l1 = l1.next;
            } else {
                cur.next = l2;
                l2 = l2.next;
            }
            cur = cur.next;
        }
        cur.next = l1 != null ? l1 : l2;
        return dum.next;
    }

    public ListNode mergeTwoLists_02(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }

        if (l1.val < l2.val) {
            l1.next = mergeTwoLists_02(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoLists_02(l1, l2.next);
            return l2;
        }

    }
}
