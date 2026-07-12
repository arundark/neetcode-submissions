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
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null)
            return null;

        return divide(lists, 0, lists.length - 1);
    }

    public ListNode divide(ListNode[] lists, int l, int r) {
        if ( l > r) return null;

        if(l == r){
            return lists[l];
        }

        int mid = l + (r-l)/2;
        ListNode left = divide(lists, l , mid);
        ListNode right = divide(lists, mid+1, r);
        return conqur(left , right);
    }

    public ListNode conqur(ListNode left, ListNode right){
        ListNode newNode = new ListNode();
        ListNode dummy = newNode;

        while(left != null && right != null){
            if(left.val < right.val){
                newNode.next = left;
                left = left.next;
            }
            else{
                newNode.next = right;
                right = right.next;
            }
              newNode = newNode.next;
        }
        newNode.next = (left != null) ? left : right;

        return dummy.next;
    }
}
