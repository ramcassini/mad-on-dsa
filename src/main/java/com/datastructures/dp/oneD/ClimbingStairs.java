package com.datastructures.dp.oneD;

public class ClimbingStairs {

    public int climbStairs(int n) {

        //base condition
        if(n==0 || n==1) return n;

        int p1=1;
        int p2=1;
        int curr=0;

        for(int i=2;i<=n;i++){

            curr=p1+p2;
            p1=p2;
            p2=curr;
        }

        return p2;

    }
}
