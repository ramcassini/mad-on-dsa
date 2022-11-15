package com.datastructures.crashcourse.arrays;

public class PrintArrayUtil {

    public static void printArr(int nums[]){
        System.out.print("[");
        for(int i:nums){
            System.out.print(i+" ");
        }
        System.out.print("]");
        System.out.println("");
    }
}
