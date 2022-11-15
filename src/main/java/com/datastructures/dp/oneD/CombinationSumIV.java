package com.datastructures.dp.oneD;

public class CombinationSumIV {
    public int combinationSum4Util(int[] nums, int n) {

        if(n==0)
            return 0;
        if(n<0)
            return Integer.MAX_VALUE;
        int count=0;
        for(int i=0;i<nums.length;i++){
            int ans=combinationSum4Util(nums,n-nums[i]);
            if(ans!=Integer.MAX_VALUE)
                count=ans+1;

        }
        return count;


    }
    public int combinationSum4(int[] nums, int target) {
        return combinationSum4Util(nums,target);
    }

    public static void main(String[] args) {

        int nums[]={1,2,3};
        int target=5;

        System.out.println(new CombinationSumIV().combinationSum4(nums,target));
    }
}
