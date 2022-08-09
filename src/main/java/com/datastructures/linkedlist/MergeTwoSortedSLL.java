package com.datastructures.linkedlist;

public class MergeTwoSortedSLL {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {

        if(list1==null) return list2;
        if(list2==null) return list1;

        ListNode dummy=new ListNode(-99);

        ListNode p=dummy;
        while(list1!=null && list2!=null){
            if(list1.val>list2.val){
                p.next=new ListNode(list2.val);
                list2=list2.next;
            }
            else{
                p.next=new ListNode(list1.val);
                list1=list1.next;
            }
            p=p.next;
        }

        while(list1!=null){
            p.next=new ListNode(list1.val);
            list1=list1.next;
            p=p.next;
        }
        while(list2!=null){
            p.next=new ListNode(list2.val);
            list2=list2.next;
            p=p.next;
        }

        return dummy.next;
    }

    public static void main(String[] args) {

        ListNode head1=ListNode.insertIntegerIntoList(null,-9);
        head1=ListNode.insertIntegerIntoList(head1,3);
//        head1=ListNode.insertIntegerIntoList(head1,8);
//        head1=ListNode.insertIntegerIntoList(head1,4);
//        head1=ListNode.insertIntegerIntoList(head1,5);

        ListNode head2=ListNode.insertIntegerIntoList(null,5);
        head2=ListNode.insertIntegerIntoList(head2,7);
//        head2=ListNode.insertIntegerIntoList(head2,1);
//        head2=ListNode.insertIntegerIntoList(head2,8);
//        head2=ListNode.insertIntegerIntoList(head2,4);
//        head2=ListNode.insertIntegerIntoList(head2,5);

        ListNode.printIntegerList(new MergeTwoSortedSLL().mergeTwoLists(head1,head2));

    }
}
