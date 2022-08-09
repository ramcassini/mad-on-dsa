package com.datastructures.linkedlist;

public class RemoveLinkedListElements {

    public ListNode removeElements(ListNode head, int val) {
        if(head == null){
            return null;
        }

        ListNode dummy=new ListNode(-99);
        dummy.next=head;
        ListNode p=dummy;

        while(p!=null && p.next!=null){

            if(p.next.val==val){
                p.next=p.next.next;
            }
            else{
                p=p.next;
            }
        }

        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode head=ListNode.insertIntegerIntoList(null,1);
        head=ListNode.insertIntegerIntoList(head,2);
        head=ListNode.insertIntegerIntoList(head,6);
        head=ListNode.insertIntegerIntoList(head,3);
        head=ListNode.insertIntegerIntoList(head,4);
        head=ListNode.insertIntegerIntoList(head,5);
        head=ListNode.insertIntegerIntoList(head,6);


        ListNode.printIntegerList(new RemoveLinkedListElements().removeElements(head,6));

    }
}
