package com.datastructures.linkedlist;

public class ReverseSLLII {
    public ListNode reverseBetween(ListNode head, int left, int right) {

        if(head==null) return null;

        int k=right-left+1;

        if(k==1) return head;
        int len=ListNode.lengthOfSLL(head);
        if(k==len) return reverseUtil(head);
        ListNode dummy=new ListNode(-99);
        dummy.next=head;
        ListNode p=head;

        while(left>1 && p!=null){
            p=p.next;
            left--;
        }

        ListNode curr=p;
        ListNode prev=null;
        ListNode forward=null;

        while(curr!=null && k>0){
            forward=curr.next;
            curr.next=prev;
            prev=curr;
            curr=forward;
            k--;
        }
//        p.next=prev;
        ListNode temp=prev;
        while(temp.next!=null){
            temp=temp.next;
        }
        if(forward!=null){
            temp.next=forward;
            head.next=prev;
            return dummy.next;
        }
        else{
            return prev;
        }





    }

    public ListNode reverseUtil(ListNode head){

        ListNode curr=head;
        ListNode prev=null;
        ListNode forward=null;

        while(curr!=null){
            forward=curr.next;
            curr.next=prev;
            prev=curr;
            curr=forward;

        }

        return prev;
    }

    public static void main(String[] args) {

        ListNode head=ListNode.insertIntegerIntoList(null,1);
        head=ListNode.insertIntegerIntoList(head,2);
        head=ListNode.insertIntegerIntoList(head,3);
//        head=ListNode.insertIntegerIntoList(head,4);
//        head=ListNode.insertIntegerIntoList(head,5);

        ListNode.printIntegerList(new ReverseSLLII().reverseBetween(head,1,2));

    }
}
