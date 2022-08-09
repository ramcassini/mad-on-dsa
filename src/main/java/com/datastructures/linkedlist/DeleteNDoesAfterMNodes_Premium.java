package com.datastructures.linkedlist;

//EASY-PREMIUM
public class DeleteNDoesAfterMNodes_Premium {

    public ListNode delteNodesIterative(ListNode head, int m, int n){

        if(head==null) return null;

        int len=ListNode.lengthOfSLL(head);
        if(len<m+n) return null;

        ListNode dummy=new ListNode(-99);

        dummy.next=head;
        ListNode p =head;

        int tempM=m;
        int temoN=n;
        while(p!=null) {
            while (tempM > 1) {
                tempM--;
                p = p.next;
            }
            ListNode temp = p;

            while (temoN > 0) {
                temoN--;
                temp = temp.next;
            }

            p.next = temp.next;
            tempM=m;
            temoN=n;
            p=p.next;
        }

        return dummy.next;
    }

    public static void main(String[] args) {

        ListNode head=ListNode.insertIntegerIntoList(null,1);
        head=ListNode.insertIntegerIntoList(head,2);
        head=ListNode.insertIntegerIntoList(head,3);
        head=ListNode.insertIntegerIntoList(head,4);
        head=ListNode.insertIntegerIntoList(head,5);
        head=ListNode.insertIntegerIntoList(head,6);
        head=ListNode.insertIntegerIntoList(head,7);
        head=ListNode.insertIntegerIntoList(head,8);
        head=ListNode.insertIntegerIntoList(head,9);
        head=ListNode.insertIntegerIntoList(head,10);

        System.out.println("Before");
        ListNode.printIntegerList(head);
        System.out.println("After");
        ListNode.printIntegerList(new DeleteNDoesAfterMNodes_Premium().delteNodesIterative(head,1,1));

    }
}
