package com.datastructures.dp;

import java.util.Arrays;

public class ProductExceptSelf {

    public int[] productExceptSelf(int[] nums) {

        int n=nums.length;
        if(n==0) return null;

        //find zero if exists
        int zeroCounter=0;
        int product=1;
        int index=-1;
        for(int i=0;i<n;i++){
            if(nums[i]==0){
                zeroCounter++;
                index=i;
                nums[i]=1;
            }
            else{
                product=product*nums[i];
            }
        }

        if(zeroCounter>1){
            Arrays.fill(nums,0);
        }else if(zeroCounter==1){
            Arrays.fill(nums,0);
            nums[index]=product;
        }
        else{
            for(int i=0;i<n;i++){
                nums[i]=product/nums[i];
            }
        }

        return nums;
    }
}
