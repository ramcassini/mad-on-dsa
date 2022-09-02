package com.datastructures.stacks;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class ValidParenthesis {
    public boolean isValid(String s) {

        Stack<String> st=new Stack<>();
        Map<String,String> hMap=new HashMap<>();
        hMap.put("(",")");
        hMap.put("[","]");
        hMap.put("{","}");

        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='(' || s.charAt(i)=='[' || s.charAt(i)=='{'){
                st.push(s.charAt(i)+"");
            }
            else{
                if(!st.isEmpty() && hMap.get(st.peek()).equals(s.charAt(i)+"")){
                    st.pop();
                    continue;
                }
                else{
                    return false;
                }
            }
        }

        return st.empty();
    }

    public static void main(String[] args) {

        System.out.println(new ValidParenthesis().isValid("(]"));
    }
}
