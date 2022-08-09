package com.datastructures.linkedlist;

public class RotateByKNodes {

    public ListNode reverseKGroup(ListNode head, int k) {

        if(head==null) return null;

        int len=findLengthOfSLL(head);
        return reverseUtilByK(head,k%len,len,len);

    }

    public int findLengthOfSLL(ListNode head){
        if(head==null) return 0;

        int count=0;
        while(head!=null){
            count++;
            head=head.next;
        }

        return count;
    }

    public ListNode reverseUtilByK(ListNode head,int k,int count,int len){

        if(head==null || count<k) return head;

        ListNode curr=head;
        ListNode forward=null;
        ListNode prev=null;

        int temp=k;

        while(temp>0 && curr!=null){
            forward=curr.next;
            curr.next=prev;
            prev=curr;
            curr=forward;
            temp--;
        }
        count=count-k;
        if(forward!=null){
            head.next=reverseUtilByK(forward,k,count,len);
        }
//        if(curr!=null){
//            ListNode p=prev;
//            while(p.next!=null){
//                p=p.next;
//            }
//            p.next=curr;
//        }
        return prev;
    }

    public static void main(String[] args) {

        ListNode head=ListNode.insertIntegerIntoList(null,1);
        head=ListNode.insertIntegerIntoList(head,2);
        head=ListNode.insertIntegerIntoList(head,3);
        head=ListNode.insertIntegerIntoList(head,4);
        head=ListNode.insertIntegerIntoList(head,5);
//        head=ListNode.insertIntegerIntoList(head,2);

        ListNode.printIntegerList(new RotateByKNodes().reverseKGroup(head,3));
    }
}
