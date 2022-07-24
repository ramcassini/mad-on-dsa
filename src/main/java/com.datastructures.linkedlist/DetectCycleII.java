package com.datastructures.linkedlist;

//EASY
public class DetectCycleII {

    public ListNode detectCycle(ListNode head) {

        if(head==null || head.next==null) return null;

        ListNode p=head;
        ListNode q=head;

        while(q!=null && q.next!=null){
            p=p.next;
            q=q.next.next;

            if(p==q) break;
        }

        if(q==null || q.next==null) return null;

        q=head;

        while(p!=q){
            p=p.next;
            q=q.next;
        }

        return q;
    }
}
