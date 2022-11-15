package com.datastructures.dp.oneD;

import java.util.Arrays;

public class HouseRobber {

    public int robUtil(int[] nums,int n){

        if(n==0)
            return nums[0];
        if(n<0)
            return 0;

        int incl=robUtil(nums,n-2)+nums[n];
        int excl=robUtil(nums,n-1);

        return Math.max(incl,excl);
    }

    public int robMem(int[] nums,int n,int dp[]){

        if(n==0)
            return nums[0];
        if(n<0)
            return 0;

        if(dp[n]!=-1)
            return dp[n];

        int incl=robMem(nums,n-2,dp)+nums[n];
        int excl=robMem(nums,n-1,dp);

        dp[n]=Math.max(incl,excl);
        return dp[n];
    }

    public int robTab(int[] nums,int n){


        if(n<0)
            return 0;
        int dp[]=new int[n+1];
        dp[0]=nums[0];
        if(n>0)
        dp[1]=Math.max(nums[0],nums[1]);

        for(int i=2;i<n;i++){

                int incl=dp[i-2]+nums[i];
                int excl=dp[i-1];

                dp[i]=Math.max(incl,excl);


        }

        return dp[n-1];
    }
    public int rob(int[] nums) {

        int n=nums.length-1;
        int dp[]=new int[n+1];
        Arrays.fill(dp,-1);
        // return robUtil(nums,n);
        //  return robMem(nums,n,dp);
        return robTab(nums,nums.length);
    }

    public static void main(String[] args) {

        int nums[]={1,2,3,1};
        System.out.println(new HouseRobber().rob(nums));
    }

}
