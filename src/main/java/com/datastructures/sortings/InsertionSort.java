package com.datastructures.sortings;

public class InsertionSort {

    public int[] sortByInsertionUtil(int[] nums){

        if(nums.length==0) return null;

        int[] res=new int[nums.length];

        for(int i=1;i<nums.length;i++){
            int pivot=nums[i];
            int k=i-1;
            while(k>=0 && pivot<nums[k] ){
               nums[k+1]=nums[k];
                k--;
//                pivot=nums[k];
            }
            nums[k+1]=pivot;
        }

        return nums;
    }
    public static void main(String[] args) {

        int[] arr={4,6,3,2,1,8,5};
        new InsertionSort().sortByInsertionUtil(arr);
    }
}
