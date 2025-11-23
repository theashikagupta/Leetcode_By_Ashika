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
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode temp=head;
        int cnt=0;
        // Step 1: Check if there are at least k nodes ahead
        while(cnt<k){
            if(temp==null) return head;  // if nodes < k → no reverse
            temp=temp.next;
            cnt++;
        }
        // Step 2: Recursively reverse the remaining list after first k nodes
        ListNode prevNode=reverseKGroup(temp,k);
        // Step 3: Reverse first k nodes
        temp=head; cnt=0;
        while(cnt<k){
            ListNode next=temp.next;
            temp.next=prevNode;
            prevNode=temp;
            temp=next;
            cnt++;
        }
        // Step 4: Return the new head of the reversed k group
        return prevNode;
    }
}