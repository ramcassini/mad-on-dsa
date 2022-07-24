package com.datastructures.linkedlist;

//EASY
public class ListNode {

    int val;
    char data;

    ListNode next;
    ListNode(int val){

        this.val=val;
        this.next=null;
    }

    public static ListNode insertIntegerIntoList(ListNode head,int val){

        if(head==null){

            head=new ListNode(val);
//            return head;
        }
        else{
            ListNode p=head;
            while(p.next!=null){
                p=p.next;
            }
            p.next=new ListNode(val);
        }

        return head;
    }

    public static ListNode insertCharacterIntoList(ListNode head,char data){

        if(head==null){

            head=new ListNode(data);
//            return head;
        }
        else{
            ListNode p=head;
            while(p.next!=null){
                p=p.next;
            }
            p.next=new ListNode(data);
        }

        return head;
    }


    public static void printIntegerList(ListNode head){
        if(head==null) {
            System.out.println("Null/Empty list");
            return;
        }
        else{
            while(head!=null){
                System.out.print(head.val+"->");
                head=head.next;
            }
            System.out.print("null");
            System.out.println("");
        }

    }

    public static void printCharacterList(ListNode head){
        if(head==null) {
            System.out.println("Null/Empty list");
            return;
        }
        else{
            while(head!=null){
                System.out.print(head.data+"->");
            }
            System.out.print("null");
            System.out.println("");
        }

    }

    public static int lengthOfSLL(ListNode head){

        if(head==null) return -1;

        int len=0;
        while(head!=null){
            len++;
            head=head.next;
        }

        return len;
    }
}
