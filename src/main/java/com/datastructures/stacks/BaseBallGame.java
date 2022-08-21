package com.datastructures.stacks;

import java.util.Stack;

public class BaseBallGame {
    public int calPoints(String[] ops) {

        if(ops==null || ops.length==0) return -1;

        int sum=0;
        Stack<Integer> st=new Stack<>();
        for(int i=0;i<ops.length;i++){
            char s=ops[i].charAt(0);
            if(ops[i].matches(".*[0-9].*")){
                sum=sum+Integer.parseInt(ops[i]);
                st.push(Integer.parseInt(ops[i]));
            }
            else if(s=='C' && !st.isEmpty()){
                sum=sum-st.peek();
                st.pop();

            }
            else if(s=='D' && !st.isEmpty()){
                int temp=st.peek();
                sum=sum+2*temp;
                st.push(2*temp);
            }
            else if(s=='+'){


                int temp=st.isEmpty()?0:st.pop();
                int newVal=temp+(st.isEmpty()?0:st.peek());
                st.push(temp);
                st.push(newVal);
                sum= sum+newVal;
            }
        }

        return sum;
    }

    public static void main(String[] args) {

//        System.out.println(new BaseBallGame().calPoints(new String[]{"5","2","C","D","+"}));
        System.out.println(new BaseBallGame().calPoints(new String[]{"5","-2","4","C","D","9","+","+"}));
    }
}
