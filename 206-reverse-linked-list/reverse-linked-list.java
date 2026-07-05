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
    public ListNode reverseList(ListNode head) {
        Stack<ListNode>st=new Stack<>();
        ListNode temp=head;
        if(temp==null) return head;
        while(temp!=null){
          
           st.push(temp);
           temp=temp.next;
        }
        
        ListNode ans=st.pop();
        ListNode curr=ans;
        while(!st.isEmpty()){

            curr.next=st.pop();
            curr=curr.next;
        }
        curr.next=null;
        return ans;
    }
}