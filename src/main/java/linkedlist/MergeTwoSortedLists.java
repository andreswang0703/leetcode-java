package linkedlist;

/**
 * No.21 merge two sorted lists.
 *
 * time: O(n)
 * space: O(1)
 *
 * Date: 02/14/2021
 */
public class MergeTwoSortedLists {

    public ListNode merge(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode();
        ListNode cur = dummy;

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
        cur.next = l1 == null ? l2 : l1;
        return dummy.next;
    }
}
