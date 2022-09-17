package com.datastructures.recursion;

public class IsPalindrome {

    public boolean checkPalindrome(int i,int j,String str){
        if(i>j) return true;

        if(str.charAt(i)!=str.charAt(j)) return false;

        return checkPalindrome(++i,--j,str);
    }

    public static void main(String[] args) {
        String str="madama";
        System.out.println(new IsPalindrome().checkPalindrome(0,str.length()-1,str));
    }
}
