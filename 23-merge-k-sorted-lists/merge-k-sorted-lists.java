class Solution {
    class Pair{
        int value;
        ListNode node;
        Pair(int value,ListNode node){
            this.value=value;
            this.node=node;
        }
    }
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<Pair>pq=new PriorityQueue<>((a,b)->Integer.compare(a.value,b.value));
        

        for(ListNode node:lists){
            if(node!=null){
             pq.offer(new Pair(node.val,node));
            }
        }

        ListNode dummy=new ListNode(0);
        ListNode curr=dummy;

        while(!pq.isEmpty()){
            Pair p=pq.poll();
            ListNode node=new ListNode(p.value);
            curr.next=node;
            curr=curr.next;
            if(p.node.next!=null){
                pq.offer(new Pair(p.node.next.val,p.node.next));
            }
        }
        return dummy.next;
    }
}