package com.datastructures.dp.oneD;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MaximumNonAdjacentSum {

    public static int maximumNonAdjacentSumUtil(ArrayList<Integer> nums,int n){


        if(n==nums.size()-1)
            return nums.get(n);
        if(n>nums.size()-1)
            return 0;


        int incl=maximumNonAdjacentSumUtil(nums,n+2)+nums.get(n);
        int excl=maximumNonAdjacentSumUtil(nums,n+1);

        return Math.max(incl,excl);
    }

    public static int maximumNonAdjacentSumMem(ArrayList<Integer> nums,int n,int dp[]){


        if(n==nums.size()-1)
            return nums.get(n);
        if(n>nums.size()-1)
            return 0;

        if(dp[n]!=-1)
            return dp[n];
        int incl=maximumNonAdjacentSumMem(nums,n+2,dp)+nums.get(n);
        int excl=maximumNonAdjacentSumMem(nums,n+1,dp);
        dp[n]=Math.max(incl,excl);
        return dp[n];
    }

    public static int maximumNonAdjacentSumTab(ArrayList<Integer> nums,int n,int dp[]){



        Arrays.fill(dp,0);
        dp[n-1]=nums.get(n-1);

        for(int i=n;i>=0;i--){

            if(i-2>0) {
                int incl = dp[i - 2] + nums.get(i);
                int excl = dp[i - 1];


            dp[n]=Math.max(incl,excl);}
        }

        return dp[0];
    }
    public static int maximumNonAdjacentSum(ArrayList<Integer> nums) {
        // Write your code here.
        int n=nums.size();
        int dp[]=new int[n+1];
        Arrays.fill(dp,-1);
        if(n==0)
            return -1;
        else{
//             return maximumNonAdjacentSumUtil(nums,0);
//            return maximumNonAdjacentSumMem(nums,0,dp);
            return maximumNonAdjacentSumTab(nums,n-1,dp);
        }
    }

    public static void main(String[] args) {


        ArrayList<Integer> nums=new ArrayList<>();
        nums.add(9);
        nums.add(9);
        nums.add(8);
        nums.add(2);
        System.out.println(maximumNonAdjacentSum(nums));
    }
}
