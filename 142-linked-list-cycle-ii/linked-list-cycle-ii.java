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
        ListNode slow=head;
        ListNode fast=head;
        while(fast!=null){
            
            slow=slow.next;
         if(fast.next==null) break;
            fast=fast.next.next;
            if(fast==slow) break;
        }
        if(fast==null) return null;
        ListNode temp=head;
        while(temp!=slow){
            temp=temp.next;
            if(slow==null) break;
            slow=slow.next;
        }
        return slow;
        
    }
}