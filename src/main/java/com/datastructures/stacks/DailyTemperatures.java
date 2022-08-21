package com.datastructures.stacks;

import java.util.Stack;

//Monotonic stack
public class DailyTemperatures {

    public int[] dailyTemperatures(int[] temperatures) {

        Stack<Integer[]> monotonicStack=new Stack<>();

        if(temperatures.length==0) return null;
        if(temperatures.length==1) return new int[]{0};

        monotonicStack.push(new Integer[]{temperatures[0],0});
        for(int i=1;i<temperatures.length;i++){

            while(!monotonicStack.isEmpty() && monotonicStack.peek()[0]<temperatures[i]){
                Integer index[]=monotonicStack.pop();
                temperatures[index[1]]=i-index[1];

            }
            monotonicStack.push(new Integer[]{temperatures[i],i});
        }

        while(!monotonicStack.isEmpty()){
            Integer index[]=monotonicStack.pop();
            temperatures[index[1]]=0;
        }

        return temperatures;
    }

    public static void main(String[] args) {

        int res[]=new DailyTemperatures().dailyTemperatures(new int[]{73,74,75,71,69,72,76,73});
        System.out.println("[");
        for(int i:res){
            System.out.print(i+",");
        }
        System.out.println("]");
    }
}
