package com.datastructures.linkedlist;

public class SlpitLinkedListInParts {

    public ListNode[] splitListToParts(ListNode head, int k) {

        int len=ListNode.lengthOfSLL(head);
        int parts=len/k;
        int diff=len%k;

        ListNode[] result=new ListNode[k];
        ListNode dummy=new ListNode(-99);
        dummy.next=head;
        ListNode p=head;
        ListNode temp=p;
        int i=0;
        while(p!=null && i<k){


            result[i]=p;
            for(int j=0;j<parts+(diff>0?1:0);j++){
                temp=p;
                p=p.next;
            }
            temp.next=null;
            i++;
            diff--;
        }

        return result;
    }

    public static void main(String[] args) {

        ListNode head=ListNode.insertIntegerIntoList(null,1);
        head=ListNode.insertIntegerIntoList(head,2);
        head=ListNode.insertIntegerIntoList(head,3);
//        head=ListNode.insertIntegerIntoList(head,4);
//        head=ListNode.insertIntegerIntoList(head,5);

        ListNode[] ans=new SlpitLinkedListInParts().splitListToParts(head,5);


    }
}
