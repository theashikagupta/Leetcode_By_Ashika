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
    public ListNode removeElements(ListNode head, int val) {
        if(head==null){
            return null;
        }
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
    public ListNode removeElements(ListNode head, int val) {
        // Dummy node to handle deletion of head itself
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        
        ListNode prev = dummy;
        ListNode curr = head;

        while (curr != null) {
            if (curr.val == val) {
                // Skip the current node
                prev.next = curr.next;
            } else {
                // Move prev only if curr is not deleted
                prev = curr;
            }
            // Move curr forward always
            curr = curr.next;
        }
        return dummy.next;
    }
}

    }
}