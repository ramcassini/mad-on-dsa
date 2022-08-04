package com.datastructures.linkedlist;

public class CloneWithRandomPointers {

    static class Node{

        int val;
        Node next;
        Node random;

        Node(int val){
            this.val=val;
            this.next=null;
            this.random=null;
        }
    }

    public Node copyRandomList(Node head) {

        //step1 create duplicate as neighbours
        Node dummy=new Node(-99);
        dummy.next=head;
        Node curr=head;
//        Node clone=null;
        Node clone=null;
        while(curr!=null){
            clone=new Node(curr.val);
            Node temp=curr.next;
            clone.next=temp;
            curr.next=clone;

            curr=curr.next.next;
//            curr=curr.next;
        }
        printNodes(head);

        curr=head;

        //duplicating random pointers
        clone=head.next;
        while(curr!=null){
//            if(curr.random !=null){
                curr.next.random=curr.random!=null?curr.random.next:null;
//            }
            curr=curr.next.next;
        }
        printRandomNodes(head);

        //splitting/delinking clone from original
        curr=head;
        Node currPtr=curr;
        clone=head.next;
        Node clonePtr=clone;
        while(currPtr!=null){
            Node currTemp=clonePtr.next;
            Node cloneTemp=currPtr.next.next;
            currPtr.next=currTemp;
            clonePtr.next=cloneTemp;

            currPtr=currPtr.next;
            clonePtr=clonePtr.next;
        }

        printNodes(curr);
        printNodes(clone);

        return clone;
    }
    void printNodes(Node head){
        System.out.println("");

        while(head!=null){
            System.out.print(head.val+"->");
            head=head.next;
        }
        System.out.print("null");
        System.out.println("");
    }

    void printRandomNodes(Node head){
        System.out.println("ramdom>>");

        while(head!=null){
            System.out.print((head.random!=null?head.random.val:null)+"->");
            head=head.next;
        }
        System.out.print("null");
        System.out.println("");
    }
    public static void main(String[] args) {

        Node head=new Node(7);

        head.next= new Node(13);
        head.next.next= new Node(11);
        head.next.next.next= new Node(10);
        head.next.next.next.next= new Node(1);

        head.random=null;
        head.next.random=head;
        head.next.next.random=head.next.next.next.next;
        head.next.next.next.random=head.next.next;
        head.next.next.next.next.random=head;

        new CloneWithRandomPointers().copyRandomList(head);
    }
}
