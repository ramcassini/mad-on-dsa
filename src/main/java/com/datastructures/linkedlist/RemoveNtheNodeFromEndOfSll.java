package com.datastructures.linkedlist;

public class RemoveNtheNodeFromEndOfSll {
    int temp=0;
    public ListNode removeNthFromEnd(ListNode head, int n) {

        if(head==null) return null;

        ListNode res=removeNthFromEnd(head.next,n);
        temp++;
        if(temp==n){
            head=res;
        }
        else{
            head.next=res;
//            tempNode=res;
        }

        return head;
    }

    public static void main(String[] args) {

        ListNode head=ListNode.insertIntegerIntoList(null,1);
        head=ListNode.insertIntegerIntoList(head,2);
        head=ListNode.insertIntegerIntoList(head,3);
        head=ListNode.insertIntegerIntoList(head,4);
        head=ListNode.insertIntegerIntoList(head,5);

        ListNode.printIntegerList(new RemoveNtheNodeFromEndOfSll().removeNthFromEnd(head,2));

    }
}
