
class Solution {
    public ListNode removeNodes(ListNode head) {
        Stack<ListNode>st=new Stack<>();
        ListNode temp=head;

        while(temp!=null){
            int val=temp.val;
            while(!st.isEmpty()&&st.peek().val<val) st.pop();
            st.push(temp);
            temp=temp.next;
        }
        Stack<ListNode>st2=new Stack<>();
        while(!st.isEmpty()){
           st2.push(st.pop());
        }
        ListNode newhead=st2.pop();
        ListNode curr=newhead;
        while(!st2.isEmpty()){
            curr.next=st2.pop();
            curr=curr.next;
        }
        curr.next=null;
        return newhead;
    }
}