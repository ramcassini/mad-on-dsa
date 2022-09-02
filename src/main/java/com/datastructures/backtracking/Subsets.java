package com.datastructures.backtracking;

import java.util.*;

public class Subsets {
    public List<List<Integer>> subsets(int[] nums) {

        if(nums.length==0) return null;

        Set<List<Integer>> resultSet=new HashSet<>();
        resultSet.add(new ArrayList<Integer>());
        boolean[] isVistied=new boolean[nums.length];
//        for(int i=0;i<nums.length;i++)
        subsetsHelper(resultSet,nums,new ArrayList<Integer>(),0,isVistied);
        return new ArrayList<>(resultSet);
    }

    public void subsetsHelper( Set<List<Integer>> resultSet,int[] nums,List<Integer> trackerList,int startingIndex,boolean[] isVistied){

//        System.out.println(trackerList);
//        System.out.println(isVistied[0]+"-"+isVistied[1]+"-"+isVistied[2]);
//        System.out.println("=====");
        resultSet.add(new ArrayList<>(trackerList));
        for(int i=startingIndex;i<nums.length;i++){
            if(!isVistied[i])
                trackerList.add(nums[i]);
                isVistied[i]=!isVistied[i];
                subsetsHelper(resultSet,nums,trackerList,i+1,isVistied);
                isVistied[i]=!isVistied[i];
                trackerList.remove(trackerList.size()-1);
            }
        }


    public static void main(String[] args) {

        System.out.println(new Subsets().subsets(new int[]{1,2,3}));
    }
}
