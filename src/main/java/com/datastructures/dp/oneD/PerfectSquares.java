package com.datastructures.dp.oneD;

import java.util.Arrays;

public class PerfectSquares {

//    recursive solution
    public int numSquares(int n) {

        if(n==0)
            return 0;
        int ans=n;
        for(int i=1;i*i<=n;i++){
            int temp=i*i;
            ans=Math.min(ans,1+numSquares(n-temp));
        }

        return ans;
    }

    public int numSquaresMem(int n,int[] dp) {

        if(n==0)
            return 0;

        if(dp[n]!=-1)
            return dp[n];

        int ans=n;
        for(int i=1;i*i<=n;i++){
            int temp=i*i;
            ans=Math.min(ans,1+numSquaresMem(n-temp,dp));
        }
        dp[n]=ans;
        return dp[n];
    }

    public int numSquaresTab(int n,int[] dp) {

        if(n==0)
            return 0;

        Arrays.fill(dp,Integer.MAX_VALUE);
        dp[0]=0;

        for(int i=1;i<dp.length;i++){
            for(int j=1;j*j<=n;j++){
                int temp=j*j;
                if(i-temp>=0)
                dp[i]=Math.min(dp[i],1+dp[i-temp]);
            }
        }

        return dp[n];
    }

    public static void main(String[] args) {

        int n=100;
        int dp[]=new int[n+1];
        Arrays.fill(dp,-1);
        System.out.println(new PerfectSquares().numSquaresTab(12,dp));
    }
}
