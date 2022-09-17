package com.datastructures.recursion;

public class Reversestring {

    public String reverse(String str){

        char[] charArr=str.toCharArray();
        reverseUtilRecur(0,str.length()-1,charArr);

        return new String(charArr);
    }

    public void reverseUtilRecur(int i,int j,char[] charArr){

        //base case
        if(i>j) return;

        //process
        swap(i,j,charArr);

        reverseUtilRecur(++i,--j,charArr);
    }


    private void swap(int i, int j, char charArr[]) {

//        char charArr[]=str.toCharArray();
        char temp=charArr[i];
        charArr[i]=charArr[j];
        charArr[j]=temp;


    }

    public static void main(String[] args) {

        String str="babbar";
        System.out.println(new Reversestring().reverse(str));
    }
}
