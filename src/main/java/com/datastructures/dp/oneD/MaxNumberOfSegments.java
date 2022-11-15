package com.datastructures.dp.oneD;

import java.util.Arrays;

public class MaxNumberOfSegments {

    public static int cutSegmentsUtil(int n, int x, int y, int z) {
        // Write your code here.
        if(n==0)
            return 0;
        if(n<0)
            return Integer.MIN_VALUE;


        int X=cutSegmentsUtil(n-x,x,y,z)+1;
        int Y=cutSegmentsUtil(n-y,x,y,z)+1;
        int Z=cutSegmentsUtil(n-z,x,y,z)+1;

        return Math.max(X,Math.max(Y,Z));

    }

    public static int cutSegmentsMem(int n, int x, int y, int z,int dp[]) {
        // Write your code here.
        if(n==0)
            return 0;
        if(n<0)
            return Integer.MIN_VALUE;

        if(dp[n]!=-1)
            return dp[n];

        int X=cutSegmentsMem(n-x,x,y,z,dp)+1;
        int Y=cutSegmentsMem(n-y,x,y,z,dp)+1;
        int Z=cutSegmentsMem(n-z,x,y,z,dp)+1;

        dp[n]=Math.max(X,Math.max(Y,Z));
        return dp[n];

    }

    public static int cutSegmentsTab(int n, int x, int y, int z) {
        // Write your code here.

        int dp[]=new int[n+1];
        Arrays.fill(dp,Integer.MIN_VALUE);
        dp[0]=0;

        for(int i=1;i<=n;i++){

            if(i-x>=0)
                dp[i]=Math.max(dp[i],dp[i-x]+1);
            if(i-y>=0)
                dp[i]=Math.max(dp[i],dp[i-y]+1);
            if(i-z>=0)
                dp[i]=Math.max(dp[i],dp[i-z]+1);


        }

        return dp[n];

    }

    public static int cutSegments(int n, int x, int y, int z) {
        // Write your code here.
        int dp[]=new int[n+1];
        Arrays.fill(dp,-1);
//         int ans=cutSegmentsUtil(n,x,y,z);
//         int ans=cutSegmentsMem(n,x,y,z,dp);
        int ans=cutSegmentsTab(n,x,y,z);

        return ans<0?0:ans;
    }

    public static void main(String[] args) {

        System.out.println(cutSegments(7,5,2,2));
    }
}
