package com.datastructures.backtracking;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CombinationSum {

    public List<List<Integer>> combinationSum(int[] candidates, int target) {

        if(candidates.length==0) return null;

        Set<List<Integer>> finalResultList = new HashSet<>();
        List<Integer> resultList = new ArrayList<>();

        combinationSumBTUtil(0,candidates,target,resultList,finalResultList);


        return new ArrayList<>(finalResultList);

    }

    private void printList(List<Integer> aL){
        System.out.println("");
        for(Integer i:aL){
            System.out.print(i+",");
        }
        System.out.println("");
    }

    private void combinationSumBTUtil(int index,int[] candidates, int target, List<Integer> resultList, Set<List<Integer>> finalResultList) {

        if(target==0){
            printList(resultList);
            finalResultList.add(new ArrayList<>(resultList));
            return;
        }
        else if(target<0){
            return;
        }
        else{
            for (int i=index;i<candidates.length;i++){
                target=target-candidates[i];
                resultList.add(candidates[i]);
                if(target>=0){
                    combinationSumBTUtil(i,candidates,target,resultList,finalResultList);
                }

                resultList.remove(resultList.size()-1);
                target=target+candidates[i];

            }
        }

    }


    public static void main(String[] args) {

        int[] candidates = {2,3,6,7};
        int target = 7;

        new CombinationSum().combinationSum(candidates,target);
    }
}
