package com.datastructures.crashcourse.arrays;

public class TrappingRainWater {

    public int trap(int[] height) {

        int n=height.length;
        if(n==0)
            return 0;

        int ans=0;

        int leftMax=0;
        int rightMax=0;
        int left=0;
        int right=n-1;

        while(left<right){

            if(height[left]<height[right]){
                if(height[left]>leftMax){
                    leftMax=height[left];
                }
                else{
                    ans+=leftMax-height[left];
                }
                left++;
            }
            else{
                if(height[right]>rightMax){
                    rightMax=height[right];
                }
                else{
                    ans+=rightMax-height[right];
                }
                right--;
            }


        }

        return ans;

    }
    public static void main(String[] args) {

        System.out.println(new TrappingRainWater().trap(new int[]{0,1,0,2,1,0,1,3,2,1,2,1}));
//        System.out.println(new TrappingRainWater().trap(new int[]{4,2,0,3,2,5}));
    }
}
