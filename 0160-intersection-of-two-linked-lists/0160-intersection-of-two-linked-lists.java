/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int lenA=getLen(headA); //5
        int lenB=getLen(headB); //6
        int diff=Math.abs(lenA-lenB); //1
        int count=0;
        while(count!=diff){
           if(lenA>lenB){
             headA=headA.next;
           }else{
             headB=headB.next;
           }
           count++;
        }
        while(headA!=headB){
            headA=headA.next;
            headB=headB.next;
        }
        return headA;


    }
    private int getLen(ListNode head){
        if(head==null){ return 0;}
        int len=1;
        while(head!=null){
            head=head.next;
            len++;
        }
        return len;
    }
}