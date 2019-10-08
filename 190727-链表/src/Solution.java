class ListNode {
     int val;
     ListNode next;
     ListNode(int x) {
         val = x;
         next = null;
     }
 }
public class Solution {

    //输入两个链表，找出它们的第一个公共结点
    private int getLength(ListNode head) {
        int len = 0;
        for (ListNode c = head; c != null; c = c.next) {
            len++;
        }

        return len;
    }
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int lenA = getLength(headA);
        int lenB = getLength(headB);

        ListNode longer = headA;
        ListNode shorter = headB;
        int diff = lenA - lenB;
        if (lenA < lenB) {
            longer = headB;
            shorter = headA;
            diff = lenB - lenA;
        }

        for (int i = 0; i < diff; i++) {
            longer = longer.next;
        }

        while (longer != shorter) {
            longer = longer.next;
            shorter = shorter.next;
        }

        return longer;
    }

    //给定一个链表，返回链表开始入环的第一个节点。 如果链表无环，则返回 null。
    public ListNode detectCycle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        // fast 遇到 null，表示不带环，返回 null
        // fast == slow，表示遇到相遇点了
        do {
            if (fast == null) {
                return null;
            }
            fast = fast.next;
            if (fast == null) {
                return null;
            }
            fast = fast.next;
            slow = slow.next;
        } while (fast != slow);

        ListNode p = head;
        ListNode q = slow;
        while (p != q) {
            p = p.next;
            q = q.next;
        }

        return p;
    }
}