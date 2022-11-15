package com.datastructures.dp.oneD;

import java.util.Arrays;

public class MinCostClimingStairs {


    public int minCostClimbingStairs(int[] cost) {

        int n=cost.length;

        int dp[]=new int[n+1];
        Arrays.fill(dp,Integer.MIN_VALUE);

//        return Math.min(minCostClimbingStairsBT(cost,cost.length-1,dp),minCostClimbingStairsBT(cost,cost.length-2,dp));
        return Math.min(minCostClimbingStairsSO(cost,cost.length-1),minCostClimbingStairsSO(cost,cost.length-2));
//        return minCostClimbingStairsTD(cost,n-2,dp);
    }
    public int minCostClimbingStairsTD(int[] cost,int n,int[] dp) {

        if(n==0) return cost[0];
        if(n==1) return cost[1];

        if(dp[n]!=Integer.MIN_VALUE) return dp[n];
        dp[n]=cost[n]+Math.min(minCostClimbingStairsTD(cost,n-1,dp),minCostClimbingStairsTD(cost,n-2,dp));

        return dp[n];

    }

    public int minCostClimbingStairsBT(int[] cost,int n,int[] dp) {

        dp[0]=cost[0];
        dp[1]=cost[1];
        for(int i=2;i<=n;i++){
            dp[i]=cost[i]+Math.min(dp[i-1],dp[i-2]);
        }


        return dp[n];

    }

    public int minCostClimbingStairsSO(int[] cost,int n) {

        if(n==0) return cost[0];
        if(n==1) return cost[1];

        int p1=cost[0];
        int p2=cost[1];
        int curr=0;

        for(int i=2;i<=n;i++){
            curr=cost[i]+Math.min(p1,p2);
            p1=p2;

            p2=curr;
        }


        return p2;

    }

    public static void main(String[] args) {
//        int cost[] = {10,15,20};
        int cost[]={1,100,1,1,1,100,1,1,100,1};
        System.out.println(new MinCostClimingStairs().minCostClimbingStairs(cost));
    }
}
