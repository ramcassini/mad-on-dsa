package com.datastructures.linkedlist;

public class MergeKLists {

    public ListNode bruteForceMergeKSorts(ListNode[] lists) {

        if(null==lists || lists.length==0) return null;

        return helperUtil(lists,0,lists.length-1);
    }

    private ListNode helperUtil(ListNode[] lists, int low, int high) {

        if(low>high) return null;
        else if(low==high) return lists[low];
        else{
            int mid=low+(high-low)/2;
            ListNode left=helperUtil(lists,low,mid);
            ListNode right=helperUtil(lists,mid+1,high);
            return mergeUtil(left,right);

        }
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

        ListNode head1=ListNode.insertIntegerIntoList(null,1);
        head1=ListNode.insertIntegerIntoList(head1,4);
        head1=ListNode.insertIntegerIntoList(head1,5);

        ListNode head2=ListNode.insertIntegerIntoList(null,1);
        head2=ListNode.insertIntegerIntoList(head2,3);
        head2=ListNode.insertIntegerIntoList(head2,4);

        ListNode head3=ListNode.insertIntegerIntoList(null,2);
        head3=ListNode.insertIntegerIntoList(head3,6);

        ListNode[] listNodes=new ListNode[3];
        listNodes[0]=head1;
        listNodes[1]=head2;
        listNodes[2]=head3;

        ListNode.printIntegerList(new MergeKLists().bruteForceMergeKSorts(listNodes));

    }
}
