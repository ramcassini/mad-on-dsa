package com.datastructures.linkedlist;

public class RemoveElementsSLL {
    public ListNode removeElements(ListNode head, int val) {

        if(head==null) return null;

        ListNode dummy=new ListNode(-99);
        dummy.next=head;
        ListNode p=head;

        while(p!=null && p.next!=null){


            if(p.next.val==val){
                p.next=p.next.next;
            }
            else{
                p=p.next;
            }
        }

//        Math.abs(Math)
        if(dummy.next.val==val){
            dummy.next=dummy.next.next;
        }
        return dummy.next;
    }
}
