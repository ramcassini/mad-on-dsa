package com.datastructures.linkedlist;

//EASY
public class DetectCycleI {

    public boolean hasCycle(ListNode head) {

        if(head==null || head.next==null) return false;
        ListNode p=head;
        ListNode q=head.next;

        while(q!=null && q.next!=null){

            p=p.next;
            q=q.next.next;
            if(p==q){
                return true;
            }

        }

        return false;
    }
}
