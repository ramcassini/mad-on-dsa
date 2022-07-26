package com.datastructures.linkedlist;

public class SwapNodesInLinkedList {

    public ListNode swapNodes(ListNode head, int k) {

        if(head==null) return null;

        ListNode p =head;
        ListNode q=head;

        while(k>1){
            p=p.next;
            k--;
        }

        ListNode tempNode=p;

        while(tempNode.next!=null){
            q=q.next;

            tempNode=tempNode.next;
        }

        int temp=q.val;
        q.val=p.val;
        p.val=temp;

        return head;
    }
    public ListNode swapNodesWithLength(ListNode head, int k) {

        if(head==null) return null;

        ListNode p =head;
        ListNode q=head;

        int len=findLengthOfSLL(head);

        len=len-k+1;

        while(k>1){
            p=p.next;
            k--;
        }

        while(len>1){
            len--;
            q=q.next;
        }

        int temp=q.val;
        q.val=p.val;
        p.val=temp;

        return head;
    }

    public int findLengthOfSLL(ListNode head){

        if(head==null) return -1;

        int count=0;
        while(head!=null){
            count++;
            head=head.next;
        }

        return count;
    }
}
