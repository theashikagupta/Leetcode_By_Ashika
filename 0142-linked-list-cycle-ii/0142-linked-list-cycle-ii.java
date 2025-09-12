/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {
       
        ListNode fast=head;
        ListNode slow=head;
        ListNode p1;
        ListNode p2;
     
        while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
            if(slow==fast){
               p1=head;
               p2=slow;
               if(p1==p2){
                return p1;
               }else{
                  while(p1!=p2){
                   p1=p1.next;
                   p2=p2.next;
                   if(p1==p2){
                    return p1;
                   }
                }
               }
                
           
            }
           
        }
        
        return null;
    }
}