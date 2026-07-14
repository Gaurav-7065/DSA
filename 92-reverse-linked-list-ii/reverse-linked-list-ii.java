class Solution {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode temp = head;
        int idx = 1;
        ListNode prev = null;
        while (idx != left) {
            prev = temp;
            temp = temp.next;
            idx++;
        }
        ListNode prev1=null;
        ListNode curr=temp;
        ListNode nhead=temp;
        ListNode ahead=null;
        while(idx!=right+1&&curr!=null){
            
            ahead=curr.next;
            curr.next=prev1;
            prev1=curr;
            curr=ahead;
            idx++;
            
        }
        
        if (prev != null ) {
            prev.next = prev1;
        }
        nhead.next=curr;
        return left==1?prev1: head;

    }
}