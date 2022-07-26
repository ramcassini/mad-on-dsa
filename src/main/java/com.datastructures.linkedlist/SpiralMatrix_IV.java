package com.datastructures.linkedlist;

import java.util.Arrays;

public class SpiralMatrix_IV {

    public int[][] spiralMatrix(int m, int n, ListNode head) {

        if(head==null) return null;

        int[][] res=new int[m][n];

        for(int i =0;i<m;i++){
            Arrays.fill(res[i],-1);
        }
        ListNode p=head;

        int i=0; // row
        int j=0; // column

        int top=0;
        int left=0;
        int right=n-1;
        int down=m-1;


        while(p!=null || (top<down && left <right)){

            //i = row , j=column for traversals
//            left to right via top
            j=left;
            while(j<=right){
                if(p!=null){
                    res[top][j]=p.val;
                    p=p.next;
                }
                else{
                    res[top][j]=res[top][j]!=-1?res[top][j]:-1;
                }

                j++;
            }
            top++;
            printArr(res);

//            top to bottom via right
            i=top;
            while(i<=down){

                if(p!=null){
                    res[i][right]=p.val;
                    p=p.next;
                }
                else{
                    res[i][right]=res[i][right]!=-1?res[i][right]:-1;
                }

                i++;
            }
            right--;
            printArr(res);

//            right to left via bottom
            j=right;
            while(j>=left){
                if(p!=null){
                    res[down][j]=p.val;
                    p=p.next;
                }
                else{
                    res[down][j]=res[down][j]!=-1?res[down][j]:-1;
                }

                j--;
            }
            down--;
            printArr(res);

//            down to top via left
            i=down;
            while(i>=top){

                if(p!=null){
                    res[i][left]=p.val;
                    p=p.next;
                }else{
                    res[i][left]=res[i][left]!=-1?res[i][left]:-1;
                }

                i--;
            }
            left++;
            printArr(res);
        }



        return res;
    }

    public static void main(String[] args) {

        ListNode head=ListNode.insertIntegerIntoList(null,3);
        head=ListNode.insertIntegerIntoList(head,0);
        head=ListNode.insertIntegerIntoList(head,2);
        head=ListNode.insertIntegerIntoList(head,6);
        head=ListNode.insertIntegerIntoList(head,8);
        head=ListNode.insertIntegerIntoList(head,1);
        head=ListNode.insertIntegerIntoList(head,7);
        head=ListNode.insertIntegerIntoList(head,9);
        head=ListNode.insertIntegerIntoList(head,4);
        head=ListNode.insertIntegerIntoList(head,2);
//        head=ListNode.insertIntegerIntoList(head,5);
//        head=ListNode.insertIntegerIntoList(head,5);
//        head=ListNode.insertIntegerIntoList(head,0);

        new SpiralMatrix_IV().printArr(new SpiralMatrix_IV().spiralMatrix(10,1,head));



    }

    public void printArr(int res[][]){
        for(int i=0;i<res.length;i++){
            System.out.println("");
            for(int j=0;j<res[0].length;j++){
                System.out.print(res[i][j]+"|");
            }
        }
        System.out.println("");
        System.out.println("----------");
    }
}
