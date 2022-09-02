package com.datastructures.backtracking;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

//NOT WORKING
public class PartitionToKEqualSubsets {

    public boolean canPartitionKSubsets(int[] nums, int k) {

        if(nums.length==0 || k==0) return false;

        int sum=0;
        for(int i=0;i<nums.length;i++)
            sum+=nums[i];

        if(sum%k!=0) return false;
        sum=sum/k;
        boolean[] isVisited=new boolean[nums.length];
        List<List<Integer>> resultSet = new ArrayList<>();

        canPartitionKSubsetsHelper(resultSet,new ArrayList<Integer>(),isVisited,nums,sum,k,0,0);

        return resultSet.size()==k;
    }

    public boolean canPartitionKSubsetsHelper(List<List<Integer>> resultSet,List<Integer> trackerList,boolean[] isVisited,
                                        int[] nums,int sum,int k,int sI,int currSum){

        if(k==0) return true;
        if(currSum>sum) return false;
        if(currSum==sum){
            resultSet.add(new ArrayList<>(trackerList));
            return canPartitionKSubsetsHelper(resultSet,new ArrayList<>(),isVisited,nums,sum,k-1,0,0);
        }
        for(int i=sI;i<nums.length;i++){

            if(!isVisited[i]){
                isVisited[i]=true;
                trackerList.add(nums[i]);
                currSum=currSum+nums[i];
                if(canPartitionKSubsetsHelper(resultSet,trackerList,isVisited,nums,sum,k,i+1,currSum)){
                    return true;

                }

                trackerList.remove(trackerList.size()-1);
                currSum=currSum-nums[i];
                isVisited[i]=false;
            }

        }
        return false;
    }

    public static void main(String[] args) {

        System.out.println(new PartitionToKEqualSubsets().canPartitionKSubsets(new int[]{4,3,2,3,5,2,1},4));

    }
}
