package com.datastructures.linkedlist;

//EASY
public class ReverseSLL {

    public ListNode reverseList(ListNode head) {

        ListNode curr=head;
        ListNode prev=null;
        ListNode N=null;

        while(curr!=null){
            N=curr.next;
            curr.next=prev;
            prev=curr;
            curr=N;
        }

        return prev;
    }
}
