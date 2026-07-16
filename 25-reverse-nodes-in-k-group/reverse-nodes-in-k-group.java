class Solution {
    public void reverse(ListNode left,int k){
        ListNode prev=null;
        ListNode curr=left;
        ListNode next=null;
        int time=k;
        while(time-->0){
            next=curr.next;
            curr.next=prev;
            prev=curr;
            curr=next;
            
          
        }
        return;
    }
    public ListNode reverseKGroup(ListNode head, int k) {
        if(head==null||head.next==null){
            return head;
        }
        ListNode left=head;
        ListNode res=null;
        ListNode right=head;
        ListNode prevleft=null;
        ListNode nextleft=null;
      while(true){
        right=left;
        for(int i=0;i<k-1;i++){
            if(right==null){
                break;
            }
            right=right.next;
        }
        if(right!=null){
            nextleft=right.next;
            reverse(left,k);
          
            if(prevleft!=null){
               prevleft.next=right;
               prevleft=left;
            }
            else{
                prevleft=left;
            }
            
            if(res==null){
                res=right;
            }
            left.next=nextleft;
            left=nextleft;
            
        }
        else{
            if(prevleft!=null){
                prevleft.next=left;
            }
            if(res==null){
                res=left;
            }
            break;
        }
      }
      return res;
    }
}