package linkedlist;

/**
 * No.19 Remove nth node from end of list. (medium)
 *
 */
public class RemoveNthNodeFromEndOfList {

    /**
     *  time: O(n)
     *  space: O(1)
     **/
    public ListNode removeNthFromEnd(ListNode head, int n) {

        // use dummy node to deal with edge case n = len (remove first node)
        ListNode dummy = new ListNode(0, head);

        ListNode f = dummy;
        ListNode s = dummy;

        for (int i = 0; i < n + 1; i++) {
            f = f.next;
        }

        while (f != null) {
            f = f.next;
            s = s.next;
        }
        s.next = s.next.next;
        return dummy.next;
    }
}
