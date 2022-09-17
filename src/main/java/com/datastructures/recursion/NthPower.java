package com.datastructures.recursion;

public class NthPower {

    public int nthPowerUtil(int a ,int b) {

        //base case
        if (b == 0) return 1;
        if (b == 1) return a;


        //recursion
        int ans = nthPowerUtil(a, b / 2);

        //process + return
        if (b % 2 == 0) { //even
            return ans * ans;
        } else { //odd
            return a * ans * ans;
        }
    }

    public static void main(String[] args) {

        System.out.println(new NthPower().nthPowerUtil(3,11));
    }


}
