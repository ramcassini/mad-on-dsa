package com.datastructures.backtracking;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CombinationSumIII {

    public List<List<Integer>> combinationSum3(int k, int n) {

        if(n==0) return null;
        Set<List<Integer>> resultSet=new HashSet<>();

        combinationSum3Helper(resultSet,k,n,1,new ArrayList<Integer>());

        return new ArrayList<>(resultSet);
    }

    public void combinationSum3Helper(Set<List<Integer>> resultSet,int k,int n,int startingIndex,List<Integer> trackerList){

        if(k==0 && n==0){
            resultSet.add(new ArrayList<>(trackerList));
            return;
        }
        if(k<=0){
            return;
        }

        for(int i=startingIndex;i<=9;i++){
            trackerList.add(i);
            combinationSum3Helper(resultSet,k-1,n-i,i+1,trackerList);
            trackerList.remove(trackerList.size()-1);
        }

    }

    public static void main(String[] args) {

        System.out.println(new CombinationSumIII().combinationSum3(3,9));
    }
}
