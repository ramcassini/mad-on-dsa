package com.datastructures.crashcourse.arrays;

public class ReverseArray {

    public void rotate(int[] nums, int k) {

        int n= nums.length;

        if(k==0 || n==0)
            return;


        k=k%n;

        int i=0;
        int j=n-k-1;

        //left rotate
        rotate(nums,i,j);

        //right rotate
        i=n-k;
        j=n-1;
        rotate(nums,i,j);

        //full rotate
        i=0;
        j=n-1;
        rotate(nums,i,j);

    }

    void swap(int[] nums,int i,int j){

        int temp=nums[i];
        nums[i]=nums[j];
        nums[j]=temp;
    }

    void rotate(int[] nums,int i,int j){

        while(i<j){
            swap(nums,i,j);
            i++;
            j--;
        }
    }
}
