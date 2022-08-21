package com.datastructures.stacks;

import java.util.Stack;

public class MinimumRemoveToMakeValidString {

    public String minRemoveToMakeValid(String s) {

        if(s==null || s.length()==0) return s;

        Stack<Integer> st=new Stack<>();

        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='(' || s.charAt(i)==')'){
                if(!st.empty() && s.charAt(st.peek())=='(' && s.charAt(i)!=s.charAt(st.peek())){
                    st.pop();
                }
                else{
                    st.push(i);
                }

            }
        }
//        char sArr[]=s.toCharArray();
//
//        while(!st.empty()){
//            sArr[st.pop()]=0;
//        }
//        return new String(sArr);
        StringBuilder sb=new StringBuilder(s);
        while(!st.empty()){
            sb.deleteCharAt(st.pop());
        }

        return sb.toString();
    }

    public static void main(String[] args) {

        System.out.println(new MinimumRemoveToMakeValidString().minRemoveToMakeValid("lee(t(c)o)de)"));
    }
}
