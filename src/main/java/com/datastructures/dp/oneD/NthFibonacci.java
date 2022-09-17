package com.datastructures.dp.oneD;

public class NthFibonacci {

    public int fib(int n) {

        // int dpArr[]=new int[n+1];

        return fibUtilSO(n);
    }

    // top down => recursive + memoization
    public int fibUtilTD(int n,int dpArr[]){

        //bse case for recursive
        if(n==0 || n==1) return n;

        //memoization
        if(dpArr[n]!=0) return dpArr[n];

        dpArr[n] = fibUtilTD(n-1,dpArr) + fibUtilTD(n-2,dpArr);

        return dpArr[n];
    }

    // bottom top => tabulation
    public int fibUtilBT(int n,int dpArr[]){

        //base case
        if(n==0 || n==1) return n;

        dpArr[0]=0;
        dpArr[1]=1;
        for(int i=2;i<=n;i++){
            dpArr[i]=dpArr[i-1]+dpArr[i-2];
        }
        return dpArr[n];
    }

    // Space Optimization
    public int fibUtilSO(int n){

        //base case
        if(n==0 || n==1) return n;

        int p1=0;
        int p2=1;
        int curr=0;

        for(int i=2;i<=n;i++){
            curr=p1+p2;
            p1=p2;
            p2=curr;
        }
        return p2;
    }
    public static void main(String[] args) {

        System.out.println(new NthFibonacci().fib(6));
    }
}
