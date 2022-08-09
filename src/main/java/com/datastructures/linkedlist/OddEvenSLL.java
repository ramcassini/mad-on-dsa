package com.datastructures.linkedlist;

import java.util.List;

public class OddEvenSLL {

    public ListNode oddEvenList(ListNode head) {

        if(head==null || head.next==null || head.next.next==null) return head;

        ListNode pDummy=new ListNode(-99);
        ListNode qDummy=new ListNode(-99);

        pDummy.next=head;
        qDummy.next=head.next;

        ListNode p=head;
        ListNode q=head.next;

        while(q!=null && q.next!=null){
            p.next=p.next.next;
            q.next=q.next.next;
            p=p.next;
            q=q.next;
        }
        p.next=qDummy.next;

        return pDummy.next;
    }

    public static void main(String[] args) {
        ListNode head=ListNode.insertIntegerIntoList(null,1);
        head=ListNode.insertIntegerIntoList(head,2);
        head=ListNode.insertIntegerIntoList(head,3);
        head=ListNode.insertIntegerIntoList(head,4);
        head=ListNode.insertIntegerIntoList(head,5);

        ListNode.printIntegerList(new OddEvenSLL().oddEvenList(head));

    }
}
