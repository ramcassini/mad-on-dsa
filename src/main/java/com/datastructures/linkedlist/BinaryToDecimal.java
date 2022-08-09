package com.datastructures.linkedlist;

//EASY
public class BinaryToDecimal {


    public int getDecimalValue(ListNode head) {

        if(head==null) return -1;

        int len=ListNode.lengthOfSLL(head);

        ListNode p=head;
        int sum=0;

        while(p!=null){
            if(p.val==1){
                sum=sum+(int)Math.pow(new Double(2),new Double(--len));
            }
            else{
                --len;
            }

            p=p.next;
        }

        return sum;
    }

    public static void main(String[] args) {

        ListNode head=ListNode.insertIntegerIntoList(null,1);
        head=ListNode.insertIntegerIntoList(head,0);
        head=ListNode.insertIntegerIntoList(head,1);

        System.out.println(new BinaryToDecimal().getDecimalValue(head));

    }
}
