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
        if(lists.length == 0) return null;

        ListNode list1 = lists[0];

        for(int i =1; i < lists.length; i++){
            ListNode list2 = lists[i];
            ListNode newNode = new ListNode();
            ListNode dummy = newNode;
            while(list1 != null && list2 != null){
                if(list1.val < list2.val){
                    newNode.next = list1;
                    newNode = newNode.next;
                    list1 = list1.next;
                }
                else{
                    newNode.next = list2;
                    newNode = newNode.next;
                    list2 = list2.next;
                }
            }
            newNode.next = (list1 != null) ? list1 : list2;
            list1 = dummy.next;
        }
        
        return list1;
    }
}
