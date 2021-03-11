package cn.msjava.coding;

/**
 * @author msJava
 * @Description: 设计链表
 */
public class MyLinkedList {

    class ListNode {
        // val用来存放链表中的数据
        public int val = 0;
        // next指向下一个结点
        public ListNode next = null;

        public ListNode() {
        }

        public ListNode(int x) {
            val = x;
        }
    }

    private ListNode dummy = new ListNode();
    private ListNode tail = dummy;
    private int length = 0;

    // 初始化
    public MyLinkedList() {

    }

    /**
     * 尾部添加新结点
     *
     * @param val
     */
    public void addAtTail(int val) {
        tail = new ListNode(val);
        tail = tail.next;
        length++;
    }

    /**
     * 头部添加新结点
     *
     * @param val
     */
    public void addAtHead(int val) {
        // 生成一个结点，存放的值为val
        ListNode p = new ListNode(val);
        // 将p.next指向第一个结点
        p.next = dummy.next;
        // dummy.next指向新结点，使之变成第一个结点
        dummy.next = p;
        // 注意动静结合原则，添加结点时，注意修改tail指针。
        if (tail == dummy) {
            tail = p;
        }
        length++;
    }

    public int get(int index) {
        // 获取链表中第 index 个结点的值。如果索引无效，则返回-1。
        // index从0开始
        if (index < 0 || index >= length) {
            return -1;
        }
        // 因为getPrevNode总是返回有效的结点，所以可以直接取值。
        return getPrevNode(index).next.val;
    }

    /**
     * 插入指定位置之前
     *
     * @param index
     * @param val
     */
    public void addAtIndex(int index, int val) {
        if (index > length) {
            // Case 1.如果 index 大于链表长度，则不会插入结点。
            return;
        } else if (index == length) {
            // Case 2.如果 index 等于链表的长度，则该结点将附加到链表的末尾。
            addAtTail(val);
        } else if (index <= 0) {
            // Case 3. 如果index小于0，则在头部插入结点。
            addAtHead(val);
        } else {
            // Case 4.
            // 得到index之前的结点pre
            ListNode pre = getPrevNode(index);
            // 在pre的后面添加新结点
            ListNode p = new ListNode(val);
            p.next = pre.next;
            pre.next = p;
            // 注意修改长度
            length++;
        }
    }

    public void deleteAtIndex(int index) {
        // Case 1. 如果index无效，那么什么也不做。
        if (index < 0 || index >= length) {
            return;
        }
        // Case 2. 删除index结点
        // step 1. 找到index前面的结点
        ListNode pre = getPrevNode(index);
        // step 2. 如果要删除的是最后一个结点，那么需要更改tail指针
        if (tail == pre.next) {
            tail = pre;
        }
        // step. 3 进行删除操作。并修改链表长度。
        pre.next = pre.next.next;
        length--;
    }

    /**
     * 获取 index 前一个元素
     *
     * @param index
     * @return
     */
    private ListNode getPrevNode(int index) {
        /*返回index结点的前驱结点，如果index不存在，那么返回dummy*/
        // 初始化front与back，分别一前一后
        ListNode front = dummy.next;
        ListNode back = dummy;
        // 在查找的时候，front与back总是一起走
        for (int i = 0; i < index && front != null; i++) {
            back = front;
            front = front.next;
        }
        // 把back做为prev并且返回
        return back;
    }


}
