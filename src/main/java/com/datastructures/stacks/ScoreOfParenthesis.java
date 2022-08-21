package com.datastructures.stacks;

import java.util.Stack;

public class ScoreOfParenthesis {
    public int scoreOfParentheses(String s) {

       if(s==null || s.length()==0) return 0;

       Stack<String> st=new Stack<>();

       for(int i=0;i<s.length();i++){
           char c=s.charAt(i);
           if(st.isEmpty() || c=='('){
               st.push(c+"");
           }
           else{
               int innerVal=0;
               while(!st.isEmpty() && !st.peek().equals("(")){
                   innerVal+=Integer.valueOf(st.peek());
                   st.pop();
               }
               st.pop();
               if(innerVal==0){
                   st.push("1");
               }
               else{
                   st.push(2*innerVal+"");
               }

           }
       }
       int ans=0;
       while(!st.empty()){
         ans+=Integer.parseInt(st.pop());
        }

        return ans;
    }

    public static void main(String[] args) {

        System.out.println(new ScoreOfParenthesis().scoreOfParentheses(
                "()()"));
    }
}
