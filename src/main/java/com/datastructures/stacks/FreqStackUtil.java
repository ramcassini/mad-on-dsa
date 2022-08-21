package com.datastructures.stacks;

import java.util.*;

public class FreqStackUtil {

    public static void main(String[] args) {


        FreqStack obj = new FreqStack();
        obj.push(5);
        obj.push(7);
        obj.push(5);
        obj.push(7);
        obj.push(4);
        obj.push(5);
        System.out.println(obj.pop());
        System.out.println(obj.pop());
        System.out.println(obj.pop());
        System.out.println(obj.pop());

    }
}

class FreqStack {

    List<Stack<Integer>> stList=null;
    Map<Integer,Integer> hMap=null;

    public FreqStack() {
        stList=new ArrayList<>();
        hMap=new HashMap<>();
    }

    public void push(int val) {
        hMap.put(val,hMap.getOrDefault(val,0)+1);
        int freq=hMap.get(val);
        if(freq-1>=stList.size()){
            stList.add(new Stack<Integer>());
        }
        stList.get(freq-1).add(val);
    }

    public int pop() {

        int size=stList.size();
        int x=stList.get(size-1).pop();
        if(stList.get(size-1).empty()){
            stList.remove(size-1);
        }

        hMap.put(x,hMap.get(x)-1);
        if(hMap.get(x)==0){
            hMap.remove(x);
        }
        return x;
    }
}
