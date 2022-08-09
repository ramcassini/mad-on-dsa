package com.datastructures.linkedlist;

public class ReorderSLL {

    public ListNode reorderList(ListNode head) {

        if(head==null) return null;

        ListNode slow=head;
        ListNode fast=head;

        ListNode temp=null;
        while(fast!=null && fast.next!=null){

            temp=slow;
            slow=slow.next;
            fast=fast.next.next;
        }

        temp.next=null;
        fast=new ReverseSLL().reverseList(slow);

        ListNode p=head;
        ListNode q=fast;

        // ListNode dummy=new ListNode(-99);
        // ListNode p=dummy;
        while(p!=null && q!=null){

            ListNode t1=p.next!=null?p.next:null;
            ListNode t2=q.next!=null?q.next:null;

            p.next=q;
            if(t1==null) break;
            q.next=t1;
            p=t1;
            q=t2;


        }

        return head;

    }

    public static void main(String[] args) {

        ListNode head=ListNode.insertIntegerIntoList(null,1);
        head=ListNode.insertIntegerIntoList(head,2);
        head=ListNode.insertIntegerIntoList(head,3);
        head=ListNode.insertIntegerIntoList(head,4);
        head=ListNode.insertIntegerIntoList(head,5);
//        head=ListNode.insertIntegerIntoList(head,6);

        ListNode.printIntegerList(new ReorderSLL().reorderList(head));
    }
}
