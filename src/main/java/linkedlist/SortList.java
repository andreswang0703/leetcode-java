package linkedlist;

import java.util.ArrayList;
import java.util.List;

/**
 * No.148 sort list. (medium)
 *
 * time: O(nlogn)
 * space: O(1)
 *
 * Date: 02/14/2021
 */
public class SortList {

    public ListNode sort(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode dummy = new ListNode();
        dummy.next = head;
        ListNode mid = getMidAndSplit(head);
        ListNode left = sort(head);
        ListNode right = sort(mid);
        return mergeSortedLists(left, right);
    }

    // return the start node of second half, and split
    private ListNode getMidAndSplit(ListNode node) {
        ListNode dummy = new ListNode();
        dummy.next = node;

        ListNode s = dummy; // start at dummy to find prev of mid
        ListNode f = node;
        while (f != null && f.next != null) {
            f = f.next.next;
            s = s.next;
        }
        ListNode mid = s.next;
        s.next = null; // split
        return mid;
    }

    private ListNode mergeSortedLists(ListNode l1, ListNode l2) {
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

    /**
     * -------------------------------------------------------
     *  test
     * -------------------------------------------------------
     */

    public static void main(String[] args) {
        SortList sortList = new SortList();
        ListNode head = getList();
        ListNode sorted = sortList.sort(head);
        printList(sorted);
    }

    private static ListNode getList() {
        ListNode l1 = new ListNode(0);
        ListNode l2 = new ListNode(7);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(8);
        ListNode l5 = new ListNode(12);
        ListNode l6 = new ListNode(2);
        ListNode l7 = new ListNode(5);

        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l5;
        l5.next = l6;
        l6.next = l7;

        return l1;
    }

    private static void printList(ListNode head) {
        List<String> list = new ArrayList<>();
        while (head != null) {
            list.add("" + head.val);
            head = head.next;
        }
        String res = String.join(" -> ", list);
        System.out.println(res);
    }
}
