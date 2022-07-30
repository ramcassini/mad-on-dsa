package com.datastructures.linkedlist;

public class SwapNodesInPairs {

    int temp=0;
    public ListNode reverseSwapRecurUtil(ListNode head,int k){

        temp=k-1;
        ListNode curr=head;
        ListNode prev=null;
        ListNode N=null;

        while(curr!=null && temp>=0){
            N=curr.next;
            curr.next=prev;
            prev=curr;
            curr=N;
            temp--;
        }

        if(N!=null){
            head.next=reverseSwapRecurUtil(N,k);
        }

        return prev;
    }

    public static void main(String[] args) {

        ListNode head=ListNode.insertIntegerIntoList(null,1);
        head=ListNode.insertIntegerIntoList(head,2);
        head=ListNode.insertIntegerIntoList(head,3);
        head=ListNode.insertIntegerIntoList(head,4);

        ListNode.printIntegerList(new SwapNodesInPairs().reverseSwapRecurUtil(head,2));

    }
}
