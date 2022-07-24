package com.datastructures.linkedlist;

//EASY
public class RemoveDuplicateFromSorted {

    public ListNode deleteDuplicates(ListNode head) {

        if(head==null) return null;

        ListNode dummy=new ListNode(-99);

        dummy.next=head;
        ListNode p=head;

        while(p!=null && p.next!=null){
            if(p.val==p.next.val){

                p.next=p.next.next;
            }
            else{
                p=p.next;
            }
        }

        return dummy.next;
    }
}
