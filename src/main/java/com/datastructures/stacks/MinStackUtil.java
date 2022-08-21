package com.datastructures.stacks;

import java.util.*;

public class MinStackUtil {

    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        System.out.println(minStack.getMin()); // return -3
        minStack.pop();
        minStack.top();    // return 0
        System.out.println(minStack.getMin());  // return -2
    }


}

//class MinStack {
//
//    Stack<Integer> st=null;
//    Map<Integer,Integer> minValMap;
//    int minVal;
//
//    public MinStack() {
//        this.st=new Stack<>();
//        this.minValMap=new TreeMap<>();
//        this.minVal=Integer.MIN_VALUE;
//
//    }
//
//    public void push(int val) {
//        this.minValMap.put(val,this.minValMap.getOrDefault(val,0)+1);
//        if(this.minValMap.size()>0){
//            this.minVal= (int) new ArrayList(this.minValMap.keySet()).get(0);
//        }
//        this.st.push(val);
//    }
//
//    public void pop() {
//        this.minValMap.put(st.peek(),minValMap.get(st.peek())-1);
//        if(minValMap.get(st.peek())==0){
//            this.minValMap.remove(st.peek());
//        }
//        st.pop();
//        if(this.minValMap.size()>0){
////            List<Integer> tempList=;
//            this.minVal=(int) new ArrayList(this.minValMap.keySet()).get(0);
//        }
//
//    }
//
//    public int top() {
//        return this.st.peek();
//    }
//
//    public int getMin() {
//        return this.minVal;
//    }
//}
class MinStack {

    /*
         minStack = [1, 1, 1, -1, -2]
         stack = [1, 2, 3, -1, -2]
     */
    private final Stack<Integer> stack = new Stack<>();
    private final Stack<Integer> minStack = new Stack<>();

    public void push(int val) {
        if (stack.isEmpty()) {
            stack.push(val);
            minStack.push(val);
        }
        else {
            int prevMin = minStack.peek();
            stack.push(val);
            minStack.push(Math.min(val, prevMin));
        }
    }

    public void pop() {
        stack.pop();
        minStack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */