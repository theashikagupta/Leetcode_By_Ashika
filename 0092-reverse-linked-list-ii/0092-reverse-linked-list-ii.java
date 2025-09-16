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
    public ListNode reverseBetween(ListNode head, int left, int right) {
        // Step 1: Dummy node
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        // Step 2: Move pointers
        ListNode leftPre = dummy;
        ListNode currNode = head;
        for (int i = 0; i < left - 1; i++) {
            leftPre = leftPre.next;
            currNode = currNode.next;
        }

        // Step 3: Reverse sublist
        ListNode subListHead = currNode;
        ListNode preNode = null;
        for (int i = 0; i <= right - left; i++) {
            ListNode nextNode = currNode.next;
            currNode.next = preNode;
            preNode = currNode;
            currNode = nextNode;
        }

        // Step 4: Reconnect
        leftPre.next = preNode;
        subListHead.next = currNode;

        // Step 5: Return new head
        return dummy.next;
    }
}