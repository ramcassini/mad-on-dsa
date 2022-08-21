package com.datastructures.stacks;

import java.util.Stack;

public class ScoreOfParenthesis {
    public int scoreOfParentheses(String s) {

        Stack<Character> st=new Stack<>();
        int count=0;
        int product=1;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='('){

                st.push('(');
            }
            else{
                if(st.peek()!=s.charAt(i)){
                    st.pop();
                    if(product==2){
                        count=count*product;
                        product=1;
                    }else{
                        count++;
                    }

                    if(!st.isEmpty() && st.peek()=='('){
                        product=2;
                    }

                }

            }
        }

        return count;
    }

    public static void main(String[] args) {

        System.out.println(new ScoreOfParenthesis().scoreOfParentheses(
                "(()(()))"));
    }
}
