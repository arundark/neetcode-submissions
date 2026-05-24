/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class Solution {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode list3 = new ListNode();

        ListNode dummy1 = list1;
        ListNode dummy2 = list2;
        ListNode dummy3 = list3;

        while (dummy1 != null && dummy2 != null) {
            if (dummy1.val < dummy2.val) {
                list3.next = dummy1;
                list3 = list3.next;
                dummy1 = dummy1.next;
            } else {
                list3.next = dummy2;
                list3 = list3.next;
                dummy2 = dummy2.next;
            }
        }

        list3.next = (dummy1 != null) ? dummy1 : dummy2;
        return dummy3.next;
    }
}