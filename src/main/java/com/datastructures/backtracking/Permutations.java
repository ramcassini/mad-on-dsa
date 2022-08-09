package com.datastructures.backtracking;

import java.util.ArrayList;
import java.util.List;

public class Permutations {

    public List<List<Integer>> permute(int[] nums) {

        if(nums.length==0) return null;
        List<List<Integer>> finalResultList=new ArrayList<>();
        List<Integer> resultList=new ArrayList<>();
        boolean visited[]=new boolean[nums.length];

//        for(int i=0;i< nums.length;i++){
//            resultList.add(nums[0]);
            permuteBTUtil(nums,resultList,finalResultList,visited);
//            resultList.remove(nums[0]);
//        }


        return finalResultList;
    }

    private void printList(List<Integer> aL){
        System.out.println("");
        for(Integer i:aL){
            System.out.print(i+",");
        }
        System.out.println("");
    }
    private void permuteBTUtil(int[] nums, List<Integer> resultList, List<List<Integer>> finalResultList, boolean visited[]) {

        if(resultList.size()==nums.length){

            finalResultList.add(new ArrayList<>(resultList));
            printList(resultList);
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

    public static void main(String[] args) {

        int nums[]=new int[]{1,2,3};
        new Permutations().permute(nums);
    }
}
