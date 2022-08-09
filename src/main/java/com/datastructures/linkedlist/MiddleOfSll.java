package com.datastructures.linkedlist;

public class MiddleOfSll {

    public ListNode middleNode(ListNode head) {

        if(head==null) return null;

        ListNode p=head;
        ListNode q=head;

        while(q!=null && q.next!=null){
            p=p.next;
            q=q.next.next;
        }

        return p;


    }
}
