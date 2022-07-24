package com.datastructures.linkedlist;

import java.util.HashSet;

public class GetIntersectionNode {
    public ListNode getIntersectionNode(ListNode head1, ListNode head2) {

        HashSet<ListNode> st=new HashSet<>();
        while(head1 != null) {
            st.add(head1);
            head1 = head1.next;
        }
        while(head2 != null) {
            if(st.contains(head2)) return head2;
            head2 = head2.next;
        }
        return null;
    }

    public int findLengthOfSll(ListNode head){

        if(head==null) return -1;
        int count=0;
        while(head!=null){
            count++;
            head=head.next;
        }

        return count;
    }

    public static void main(String[] args) {

        ListNode head1=ListNode.insertIntegerIntoList(null,4);
        head1=ListNode.insertIntegerIntoList(head1,1);
        head1=ListNode.insertIntegerIntoList(head1,8);
        head1=ListNode.insertIntegerIntoList(head1,4);
        head1=ListNode.insertIntegerIntoList(head1,5);

        ListNode head2=ListNode.insertIntegerIntoList(null,5);
        head2=ListNode.insertIntegerIntoList(head2,6);
        head2=ListNode.insertIntegerIntoList(head2,1);
        head2=ListNode.insertIntegerIntoList(head2,8);
        head2=ListNode.insertIntegerIntoList(head2,4);
        head2=ListNode.insertIntegerIntoList(head2,5);

        ListNode.printIntegerList(new GetIntersectionNode().getIntersectionNode(head1,head2));

    }
}
