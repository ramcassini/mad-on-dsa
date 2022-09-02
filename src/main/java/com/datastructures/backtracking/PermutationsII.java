package com.datastructures.backtracking;

import java.util.*;

public class PermutationsII {
//    public List<List<Integer>> permuteUnique(int[] nums) {
//
//
//        if(nums.length==0) return null;
//        Set<List<Integer>> finalResultList=new HashSet<>();
//        List<Integer> resultList=new ArrayList<>();
//        boolean visited[]=new boolean[nums.length];
//
////        for(int i=0;i< nums.length;i++){
////            resultList.add(nums[0]);
//        permuteBTUtil(nums,resultList,finalResultList,visited);
////            resultList.remove(nums[0]);
////        }
//
//
//        return new ArrayList<>(finalResultList);
//    }
//
//
//    private void permuteBTUtil(int[] nums, List<Integer> resultList, Set<List<Integer>> finalResultList, boolean visited[]) {
//
//        if(resultList.size()==nums.length){
//
//            finalResultList.add(new ArrayList<>(resultList));
//            // printList(resultList);
//            return;
//        }
//        else{
//            for(int i=0;i<nums.length;i++){
//                if(!visited[i]){
//                    visited[i]=true;
//                    resultList.add(nums[i]);
//                    permuteBTUtil(nums,resultList,finalResultList,visited);
//                    resultList.remove(resultList.size()-1);
//                    visited[i]=false;
//                }
//
//            }
//        }
//        return;
//    }

    public List<List<Integer>> permuteUnique(int[] nums) {

        if(nums.length==0) return null;

        Set<List<Integer>> resultSet=new HashSet<>();
       Set<Integer> trackerIndex=new HashSet<>();
        permuteUniqueHelper(resultSet,nums,new ArrayList<>(),trackerIndex);

        return new ArrayList<>(resultSet);

    }

    public void permuteUniqueHelper(Set<List<Integer>> resultSet,int[] nums,List<Integer> trackerList,Set<Integer> trackerIndex){

        if(trackerList.size()==nums.length){
            resultSet.add(new ArrayList<>(trackerList));
            return;
        }

        for(int i=0;i<nums.length;i++){
            if(!trackerIndex.contains(i)){
                trackerList.add(nums[i]);
                trackerIndex.add(i);
                permuteUniqueHelper(resultSet,nums,trackerList,trackerIndex);
                trackerList.remove(trackerList.size()-1);
                trackerIndex.remove(i);
            }

        }


    }

    public static void main(String[] args) {
        System.out.println(new PermutationsII().permuteUnique(new int[]{1,2,3}));
    }
}
