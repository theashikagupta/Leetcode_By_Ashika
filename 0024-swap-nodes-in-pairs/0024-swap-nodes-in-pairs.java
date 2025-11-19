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
    public ListNode swapPairs(ListNode head) {
        if(head==null || head.next==null){
            return head;
        }

        ListNode firstNode=head;
        ListNode secondNode =head.next;
        ListNode newHead=swapPairs(secondNode.next);
        secondNode.next=firstNode;
        firstNode.next=newHead;
        
        return secondNode;



//         ListNode dummy=new ListNode(-1);
//         dummy.next=head;
//         ListNode prev=dummy;
//         ListNode first=head;
//         ListNode sec=first.next;
//         ListNode third;
//         while(first!=null && sec!=null){
//             third=sec.next;
//             sec.next=first;
//             first.next=third;
//             if(prev!=null){
//                 prev.next=sec;
//             }else{
//                 head=sec;
//             }
//             prev=first;
//             first=third;
//             if(third!=null){
//                 sec=third.next;
//             }else{
//                 sec=null;
//             }
//         }
//         return dummy.next;
    }
}


