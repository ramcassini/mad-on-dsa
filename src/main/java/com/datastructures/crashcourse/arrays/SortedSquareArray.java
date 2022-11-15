package com.datastructures.crashcourse.arrays;

public class SortedSquareArray {

    public int[] sortedSquares(int[] nums) {

        if(nums.length==0)
            return null;

        int i=0;
        int j=nums.length-1;

        while(i<j){

            if(nums[i]*nums[i]>nums[j]*nums[j]){
                swap(nums,i,j);
                i++;
            }
            else{
                j--;
            }


        }

        for(int k=0;k<nums.length;k++){
            nums[k]=nums[k]*nums[k];
        }
        return nums;
    }
    void swap(int[] nums,int i,int j){

        int temp=nums[i];
        nums[i]=nums[j];
        nums[j]=temp;
    }

    public static void main(String[] args) {

        int nums[]={-4,-1,0,3,10};
        PrintArrayUtil.printArr(new SortedSquareArray().sortedSquares(nums));
    }
}
