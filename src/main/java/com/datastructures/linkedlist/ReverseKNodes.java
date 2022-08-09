package com.datastructures.linkedlist;

public class ReverseKNodes {

    public ListNode reverseKGroup(ListNode head, int k) {

        if(head==null) return null;

        int len=lengthOfSLL(head);

        return reverKgroupUtil(head,k,len);
    }

    public ListNode reverKgroupUtil(ListNode head, int k , int len) {

        if(len<k) return head;

        ListNode curr=head;
        ListNode prev=null;
        ListNode forward=null;

        int tempK=k;
        while(curr!=null && tempK>0){
            forward=curr.next;
            curr.next=prev;
            prev=curr;
            curr=forward;
            tempK--;
        }

        len=len-k;
        if(forward!=null){
            head.next=reverKgroupUtil(forward,k,len);
        }

        return prev;
    }

    public int lengthOfSLL(ListNode head){

        if(head==null) return -1;

        int len=0;
        while(head!=null){
            len++;
            head=head.next;
        }

        return len;
    }

    public static void main(String[] args) {

        ListNode head=ListNode.insertIntegerIntoList(null,1);
        head=ListNode.insertIntegerIntoList(head,2);
        head=ListNode.insertIntegerIntoList(head,3);
        head=ListNode.insertIntegerIntoList(head,4);
        head=ListNode.insertIntegerIntoList(head,5);

        ListNode.printIntegerList(new ReverseKNodes().reverseKGroup(head,2));

    }
}

