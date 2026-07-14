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
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode temp = head;
        int idx = 1;
        ListNode prev = null;
        while (idx != left) {
            prev = temp;
            temp = temp.next;
            idx++;
        }
        Stack<ListNode> st = new Stack<>();
        while (idx != right + 1) {
            st.push(temp);
            temp = temp.next;
            idx++;
        }
        ListNode node = st.pop();
        ListNode tail = node;
        while (!st.isEmpty()) {
            tail.next = st.pop();
            tail = tail.next;
        }
        if (prev != null ) {
            prev.next = node;
        }
        if(tail!=null){
            tail.next=temp;
        }
       

        return left==1?node: head;

    }
}