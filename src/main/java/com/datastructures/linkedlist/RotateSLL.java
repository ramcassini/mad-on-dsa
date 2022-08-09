package com.datastructures.linkedlist;

public class RotateSLL {

    public ListNode rotateRight(ListNode head, int k) {

        if(head==null) return null;

        int len=ListNode.lengthOfSLL(head);

        len=k%len;
        int temp=len+1;
        ListNode dummy=new ListNode(-99);
        dummy.next=head;
        ListNode p=null;
        ListNode q=head;

        while(temp>0 && q!=null){
            temp--;
            p=q;
            q=q.next;
        }
        p.next=null;
        ListNode tempNode=q;
        while(tempNode.next!=null){
            tempNode=tempNode.next;
        }
        tempNode.next=head;


        return q;

    }

    public static void main(String[] args) {

        ListNode head=ListNode.insertIntegerIntoList(null,0);
        head=ListNode.insertIntegerIntoList(head,1);
        head=ListNode.insertIntegerIntoList(head,2);
//        head=ListNode.insertIntegerIntoList(head,4);
//        head=ListNode.insertIntegerIntoList(head,5);

        ListNode.printIntegerList(new RotateSLL().rotateRight(head,4));

    }
}
