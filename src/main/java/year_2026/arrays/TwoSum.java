package year_2026.arrays;

//1. Two Sum
//
//Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.
//
//You may assume that each input would have exactly one solution, and you may not use the same element twice.
//
//You can return the answer in any order.

import java.util.*;

public class TwoSum {

    public int[] twoSum(int[] nums, int target) {

        Map<Integer,Integer> hMap = new HashMap<>();

        for(int i=0;i<nums.length;i++){
//        for(Integer i:nums){

            if(!hMap.containsKey(target-nums[i])){
                hMap.put(nums[i],i);
            }
            else{
                return new int[]{hMap.get(target-nums[i]),i};
            }
        }

        return null;
    }

    public static void main(String[] args) {

        System.out.println(new TwoSum().twoSum(new int[]{2,3,5,6},5));
    }
}
