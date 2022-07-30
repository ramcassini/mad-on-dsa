package com.datastructures.linkedlist;

public class AddTwoNumberSLL {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        if(l1==null) return l2;
        if(l2==null) return l1;

        // ListNode l1=reverseUtil(l1);
        // ListNode l2=reverseUtil(l2);

        ListNode dummy=new ListNode(-99);

        ListNode ans=dummy;

        int sum=0;
        int carry=0;

        while(l1!=null || l2!=null ){

            sum=carry+(l1!=null?l1.val:0)+(l2!=null?l2.val:0);
            carry=sum/10;
            ans.next=new ListNode(sum%10);
            ans=ans.next;
            l1=l1!=null?l1.next:null;
            l2=l2!=null?l2.next:null;
        }

        while(carry!=0){
            sum=carry;
            carry=sum/10;
            ans.next=new ListNode(sum%10);
            ans=ans.next;
        }

        return dummy.next;

    }
}
