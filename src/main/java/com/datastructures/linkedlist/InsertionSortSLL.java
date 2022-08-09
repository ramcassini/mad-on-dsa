package com.datastructures.linkedlist;

import java.util.Arrays;

public class InsertionSortSLL {

    public ListNode insertionSortList(ListNode head) {

        if(head==null || head.next==null) return head;

        ListNode dummy=new ListNode(-99);
        dummy.next=head;
        ListNode preInsert;
        ListNode positionViolatedPtr;

        ListNode curr=head;
        while(curr!=null && curr.next!=null){
           if(curr.val<=curr.next.val){
               curr=curr.next;
           }
           else{
               positionViolatedPtr=curr.next;
               preInsert=dummy;
               while(preInsert.next.val<positionViolatedPtr.val){
                   preInsert=preInsert.next;
               }

               curr.next=positionViolatedPtr.next;
               positionViolatedPtr.next=preInsert.next;
               preInsert.next=positionViolatedPtr;
           }

        }


        return dummy.next;

    }

    public static void main(String[] args) {

        ListNode head=ListNode.insertIntegerIntoList(null,4);
        head=ListNode.insertIntegerIntoList(head,2);
        head=ListNode.insertIntegerIntoList(head,1);
        head=ListNode.insertIntegerIntoList(head,3);

        ListNode.printIntegerList(new InsertionSortSLL().insertionSortList(head));
    }
}
