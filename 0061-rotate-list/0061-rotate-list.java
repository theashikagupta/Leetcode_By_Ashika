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
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null || k == 0) return head;
        int size=1;    
        ListNode temp=head;
        while(temp.next!=null){
            temp=temp.next;
            size++;       
        }
        temp.next=head;
        k=k%size;
        int index=size-k;
        
        ListNode temp1 = head;
        for (int i = 1; i < index; i++) {
            temp1 = temp1.next;
        }
        ListNode temp2=temp1.next;
        temp1.next=null;
        return temp2;
    }
}





        
        