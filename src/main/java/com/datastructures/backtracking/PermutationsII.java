package com.datastructures.backtracking;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class PermutationsII {
    public List<List<Integer>> permuteUnique(int[] nums) {


        if(nums.length==0) return null;
        Set<List<Integer>> finalResultList=new HashSet<>();
        List<Integer> resultList=new ArrayList<>();
        boolean visited[]=new boolean[nums.length];

//        for(int i=0;i< nums.length;i++){
//            resultList.add(nums[0]);
        permuteBTUtil(nums,resultList,finalResultList,visited);
//            resultList.remove(nums[0]);
//        }


        return new ArrayList<>(finalResultList);
    }


    private void permuteBTUtil(int[] nums, List<Integer> resultList, Set<List<Integer>> finalResultList, boolean visited[]) {

        if(resultList.size()==nums.length){

            finalResultList.add(new ArrayList<>(resultList));
            // printList(resultList);
            return;
        }
        else{
            for(int i=0;i<nums.length;i++){
                if(!visited[i]){
                    visited[i]=true;
                    resultList.add(nums[i]);
                    permuteBTUtil(nums,resultList,finalResultList,visited);
                    resultList.remove(resultList.size()-1);
                    visited[i]=false;
                }

            }
        }
        return;
    }
}
