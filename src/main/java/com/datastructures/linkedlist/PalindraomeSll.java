package com.datastructures.linkedlist;

public class PalindraomeSll {

    public boolean isPalindrome(ListNode head) {

        if(head==null) return false;

        ListNode slow=head;
        ListNode fast=head.next;
//        ListNode temp=null;
        while(fast!=null && fast.next!=null){
//            temp=slow;
            slow=slow.next;
            fast=fast.next.next;
        }

        fast=head;
        slow=new ReverseSLL().reverseList(slow);

        while(slow!=null){

            if(fast.val!=slow.val){
                return false;
            }
            slow=slow.next;
            fast=fast.next;
        }

        return true;
    }

    public static void main(String[] args) {

        ListNode head=ListNode.insertIntegerIntoList(null,1);
        head=ListNode.insertIntegerIntoList(head,0);
        head=ListNode.insertIntegerIntoList(head,1);
//        head=ListNode.insertIntegerIntoList(head,1);
//        head=ListNode.insertIntegerIntoList(head,5);

        System.out.println(new PalindraomeSll().isPalindrome(head));

    }
}
