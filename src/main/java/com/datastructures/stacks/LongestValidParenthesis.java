package com.datastructures.stacks;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class LongestValidParenthesis {

    public int longestValidParentheses(String s) {


        if(s==null || s.length()<2){
            return 0;
        }

        if(s.matches("[^()]+")){
            return 0;
        }
        Stack<Integer> st=new Stack<>();

        int count=0;
        int max=Integer.MIN_VALUE;
        for(int i=0;i<s.length();i++) {
            if(s.charAt(i)=='('){
                st.push(i);
            }
            else{
                if(!st.isEmpty() && s.charAt(st.peek())=='('){
                    st.pop();
                }
                else{
                    st.push(i);
                }
            }
        }

        int maxLen=Integer.MIN_VALUE;
        int endTerminal=s.length();
        while(!st.isEmpty()){
            int startTerminal=st.pop();
            maxLen=Math.max(maxLen,endTerminal-startTerminal-1);
            endTerminal=startTerminal;
        }

        return Math.max(endTerminal,maxLen);
    }

    public static void main(String[] args) {

        System.out.println(new LongestValidParenthesis().longestValidParentheses(")()())"));
    }
}
