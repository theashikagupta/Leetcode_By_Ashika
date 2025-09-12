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
    public ListNode middleNode(ListNode head) {
        //Brute force
        int size=0;
        ListNode temp=head;

        while(temp!=null ){ 
            temp=temp.next;
            size++;
        }
        int mid = size / 2;  
        temp = head;
        for (int i = 0; i < mid; i++) {
            temp = temp.next;
        }
        return temp;

        //Optimal TC:O(n)
        // ListNode slow = head;
        // ListNode fast = head;

        // while (fast != null && fast.next != null) {
        //     slow = slow.next;
        //     fast = fast.next.next;
        // }

        // return slow; 
    }
}