package com.datastructures.crashcourse.arrays;

public class ContainerWithMostWater {

    public int maxArea(int[] height) {

        int n=height.length;
        if(n==0 || n==1) return 0;

        int i=0;
        int j=n-1;

        int maxArea=0;
        //area of container(rectangle)= a*b; -> formula
        while(i<j){


            maxArea=Math.max(maxArea,(Math.min(height[i],height[j])*(j-i)));
            if(height[i]>height[j]){
                j--;
            }
            else{
                i++;
            }
            System.out.println("-->"+i+","+j+"="+maxArea);
        }

        return maxArea;
    }

    public static void main(String[] args) {

        System.out.println(new ContainerWithMostWater().maxArea(new int[]{2,3,4,5,18,17,6}));
    }
}
