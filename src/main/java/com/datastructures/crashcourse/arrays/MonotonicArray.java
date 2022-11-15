package com.datastructures.crashcourse.arrays;

public class MonotonicArray {

    public boolean isMonotonic(int[] nums) {

        if(nums.length==0 || nums.length==1)
            return true;

        boolean isHigh=false;
        boolean isLow=false;

        int n=nums.length;
        if(nums[0]>nums[n-1]){
            isLow=true;
        }
        else{
            isHigh=true;
        }

        if(isHigh){
            for(int i=0;i<nums.length-1;i++){

                if(nums[i]>nums[i+1])
                {
                    isLow=true;
                }
                if(isHigh && isLow){
                    return false;
                }

            }
        }
        if(isLow){
            for(int i=0;i<nums.length-1;i++){

                if(nums[i]<nums[i+1])
                {
                    isHigh=true;
                }
                if(isHigh && isLow){
                    return false;
                }

            }
        }
        return true;
    }
}
