package com.datastructures.backtracking;

import java.util.*;

public class CombinationSumIV {

    public int combinationSum4(int[] nums, int target) {
        int[] dp = new int[target+1];
        Arrays.fill(dp,-1);
        return memoization(nums,target,dp);
    }
    public int memoization(int[] nums,int target,int[] dp){
        if(target<0)
            return 0;
        if(target==0)
            return 1;
        if(dp[target]!=-1)
        {
            return dp[target];
        }
        int ans=0;
        for(int i=0;i<nums.length;i++)
        {
            ans+=memoization(nums,target-nums[i],dp);
        }
        dp[target] = ans;
        return dp[target];
    }

    public static void main(String[] args) {

        int arr[]={1,2,3};
        System.out.println(new CombinationSumIV().combinationSum4(arr,4));
    }

}
