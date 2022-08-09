package com.datastructures.linkedlist;

public class ReverseSLLII {

    public ListNode reverseBetween(ListNode head, int left, int right) {

        if(left==right){
            return head;
        }
        ListNode dummy=new ListNode(-1000);
        dummy.next=head;
        ListNode p=dummy;
        int count=1;

        while(p.next!=null){
            if(count==left){
                ListNode temp=rotateByBound(p.next,right,left);

                p.next=temp;
            }
            p=p.next;
            count++;
        }

        // printNode(dummy.next);
        return dummy.next;
    }

    public ListNode rotateByBound(ListNode head, int pos ,int cond){
        pos=pos-cond+1;
        ListNode curr=head;
        ListNode prev=null;
        ListNode N=null;

        int count=0;
        while(count<pos && curr!=null){
            N=curr.next;
            curr.next=prev;
            prev=curr;
            curr=N;
            count++;
        }
//        ListNode dummy=prev;
        ListNode p=prev;

        while(p.next!=null){
            p=p.next;
        }
        p.next=curr;

        return prev;
//        return prev;
    }
//
//    public ListNode reverseUntilByKUtil(ListNode head,int count){
//
//
//
//        return prev;
//    }

    public static void main(String[] args) {

        ListNode head=ListNode.insertIntegerIntoList(null,1);
        head=ListNode.insertIntegerIntoList(head,2);
        head=ListNode.insertIntegerIntoList(head,3);
        head=ListNode.insertIntegerIntoList(head,4);
        head=ListNode.insertIntegerIntoList(head,5);

        ListNode.printIntegerList(new ReverseSLLII().reverseBetween(head,2,4));

    }
}
