package linkedlist;

/**
 * No.148 sort list (bottom up)
 *
 * time: O(nlogn)
 * space: O(1)
 *
 * Date: 02/17/2021
 *
 */
public class SortListBottomUp {

    public ListNode sortList(ListNode head) {
        ListNode dummy = new ListNode();
        dummy.next = head;
        int n = countNodes(head);

        ListNode tail;
        ListNode cur;
        for (int i = 1; i < n; i *= 2) {
            tail = dummy;
            cur = tail.next;

            // cur stops at null at each end of iteration
            while (cur != null) {
                ListNode left = cur;
                ListNode right = split(left, i);
                cur = split(right, i);
                tail = merge(left, right, tail);
            }
        }
        return dummy.next;
    }

    private int countNodes(ListNode head) {
        int count = 0;
        while (head != null) {
            count++;
            head = head.next;
        }
        return count;
    }

    // split the list in #steps
    // return the next list's head node
    private ListNode split(ListNode head, int steps) {
        // if remaining list has less than #steps, stop at last node before null
        // note: start from i = 1, because only need to walk n - 1 steps
        for (int i = 1; i < steps && head.next != null; i++) {
            head = head.next;
        }
        ListNode nextHead = head.next;
        head.next = null; // split
        return nextHead;
    }

    // merge two lists in ascending order, append to tail node
    // and return the last node of merged list
    // tail can't be null
    private ListNode merge(ListNode l1, ListNode l2, ListNode tail) {

        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                tail.next = l1;
                l1 = l1.next;
            } else {
                tail.next = l2;
                l2 = l2.next;
            }
            tail = tail.next;
        }
        tail.next = l1 == null ? l2 : l1;
        while (tail.next != null) {
            tail = tail.next;
        }
        return tail;
    }

    public static void main(String[] args) {
        ListNode head = getList();
        SortListBottomUp sort = new SortListBottomUp();
        ListNode res = sort.sortList(head);
        SortList.printList(res);
    }

    private static ListNode getList() {
        ListNode l1 = new ListNode(4);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(1);
        ListNode l4 = new ListNode(3);
        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        return l1;
    }
}
