package com.datastructures.dp.oneD;

import java.util.*;

public class MinimumNumberOfCOins {

    int min=Integer.MAX_VALUE;
    public int coinChange(int[] coins, int amount) {

        if(amount==0) return 0;

        Set<List<Integer>> finalResultSet=new HashSet<>();
        int[] dp=new int[amount+1];
        Arrays.fill(dp,-1);
        int ans=coinChangeUtil(dp,finalResultSet,new ArrayList<>(),coins,amount);


        return ans==0?-1:finalResultSet.size();
    }

    private int coinChangeUtil(int dp[],Set<List<Integer>> finalResultSet,List<Integer> trackerList,int[] coins, int amount) {
        int ans=0;

        if(amount==0){
            if(min>trackerList.size()){
                min=trackerList.size();
            }
            finalResultSet.add(new ArrayList<>(trackerList));
            return 1;
        }
        if(amount<0){
            return 0;
        }
        if(dp[amount]!=-1){
            return dp[amount];
        }
        else{

            for(int i=0;i<coins.length;i++){
                trackerList.add(coins[i]);
                ans+=coinChangeUtil(dp,finalResultSet,trackerList,coins,amount-coins[i]);
                trackerList.remove(trackerList.size()-1);
            }

        }
        dp[amount]=ans;
        return ans;
    }

    public static void main(String[] args) {
        int[] coins={1,2,5};
        System.out.println(new MinimumNumberOfCOins().coinChange(coins,11));
    }
}
