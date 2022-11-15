package com.datastructures.crashcourse.hashMap;

import java.sql.SQLOutput;
import java.util.HashMap;
import java.util.Map;

public class TwoSum {

    public int[] twoSum(int[] nums, int target) {

        int n=nums.length;
        if(n<2) return null;
        if(target<Integer.MIN_VALUE || target>Integer.MAX_VALUE) return null;

        Map<Integer,Integer> hMap=new HashMap<>();
        int[] ans=new int[2];

        for(int i=0;i<n;i++){
            if(hMap.containsKey(target-nums[i])){
                ans[0]=hMap.get(target-nums[i]);
                ans[1]=i;
                break;
            }
            else{
                hMap.put(nums[i],i);
            }
        }

        return ans;
    }

    public static void main(String[] args) {

        new TwoSum().twoSum(new int[]{2,7,11,15},9);
    }
}
