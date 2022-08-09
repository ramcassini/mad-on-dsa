package com.datastructures.linkedlist;

public class SortSLL {

    public ListNode mergeSort(ListNode head){

        if(head==null || head.next==null) return head;

        ListNode list1=head;
        ListNode slow=list1;

        ListNode list2=head;
        ListNode fast=list2;

        ListNode temp=null;
        while(fast!=null && fast.next!=null){
            temp=slow;
            slow=slow.next;
            fast=fast.next.next;
        }
        temp.next=null;

        list1=mergeSort(head);
        list2=mergeSort(slow);
        return mergeUtil(list1,list2);
    }

    public ListNode mergeUtil(ListNode left,ListNode right){

        if(left==null) return right;
        if(right==null) return left;

        ListNode dummy=new ListNode(-99);
        ListNode p=dummy;

        while(left!=null && right!=null){

            if(left.val<right.val){
                dummy.next=new ListNode(left.val);
                left=left.next;
                dummy=dummy.next;
            }
            else{
                dummy.next=new ListNode(right.val);
                right=right.next;
                dummy=dummy.next;
            }
        }

        while(left!=null){
            dummy.next=new ListNode(left.val);
            left=left.next;
            dummy=dummy.next;
        }

        while(right!=null){
            dummy.next=new ListNode(right.val);
            right=right.next;
            dummy=dummy.next;
        }

        return p.next;
    }

    public static void main(String[] args) {

        ListNode head=ListNode.insertIntegerIntoList(null,4);
        head=ListNode.insertIntegerIntoList(head,2);
        head=ListNode.insertIntegerIntoList(head,1);
        head=ListNode.insertIntegerIntoList(head,3);

        ListNode.printIntegerList(new SortSLL().mergeSort(head));

    }
}
