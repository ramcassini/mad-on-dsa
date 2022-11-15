package com.datastructures.arrays;

public class MaximiseDistanceToClosestPerson {

    public int maxDistToClosest(int[] seats) {

        int n=seats.length;

        if(n<2) return 1;

        int i=0;
        int j=0;
        //as minimum step is 1
        int steps=1;
        int maxStep=0;


        while(j<n){

            if(seats[j]==0){
                steps++;
                // j++;
            }
            else{

                maxStep=Math.max(maxStep,steps/2);
                steps=1;
                i=j;
            }
            j++;
        }

        if(seats[0]==0 && seats[n-1]!=0){
            maxStep=Math.max(maxStep,j-1);
        }
        else{
            if(maxStep==0){
                maxStep=j-1;
            }
        }


        return maxStep;
    }

    public static void main(String[] args) {

       System.out.println(new MaximiseDistanceToClosestPerson().maxDistToClosest(new int[]{1,0,0,0,1,0,1}));
        System.out.println(new MaximiseDistanceToClosestPerson().maxDistToClosest(new int[]{1,0,0,0}));
        System.out.println(new MaximiseDistanceToClosestPerson().maxDistToClosest(new int[]{0,1}));
        System.out.println(new MaximiseDistanceToClosestPerson().maxDistToClosest(new int[]{0,0,1}));
        System.out.println(new MaximiseDistanceToClosestPerson().maxDistToClosest(new int[]{0,1,0,1,0}));
    }
}
