package com.datastructures.stacks;

import java.util.Stack;

public class ValidateStackSequence {
    public boolean validateStackSequences(int[] pushed, int[] popped) {

        Stack<Integer> st=new Stack<>();
        int i=0;
        int j=0;
        while(i<pushed.length){
            st.push(pushed[i]);
            while(!st.empty() && st.peek()==popped[j]){
                st.pop();
                j++;
            }
            i++;
        }

        return st.empty();
    }

    public static void main(String[] args) {



        System.out.println(new ValidateStackSequence().validateStackSequences(new int[]{1,0},new int[]{1,0}));
    }
}
