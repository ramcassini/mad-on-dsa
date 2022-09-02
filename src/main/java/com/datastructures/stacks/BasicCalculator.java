package com.datastructures.stacks;

import java.util.Stack;

public class BasicCalculator {
    //1+1
    //"(1+(4+5+2)-3)+(6+8)"
    public int calculate(String s) {

        if(s==null || s.length()<1) return 0;

        int ans=0;
        int sign=1;
        int curr=0;
        Stack<Integer> st=new Stack<>();

        int i=0;
        while(i<s.length()){
//            char c=s.charAt(i);
            if(Character.isDigit(s.charAt(i))){
                String temp="";
                while(i<s.length() && Character.isDigit(s.charAt(i))){
                    temp=temp+s.charAt(i);
                    i++;
                }
                curr=Integer.parseInt(temp);
                ans=ans+(curr*sign);
                sign=1;
                curr=0;
                continue;
            }
            else if(s.charAt(i)=='+'){
                sign=1;
            }
            else if(s.charAt(i)=='-'){
                sign=-1;
            }
            else if(s.charAt(i)=='('){
                st.push(ans);
                st.push(sign);
                ans=0;
                sign=1;
            }
            else if(s.charAt(i)==')'){
                //first top will always be sign
                ans=ans*st.pop();
                //second top will always be data
                ans=ans+st.pop();
             }
            i++;
        }
        return ans;
    }

    public static void main(String[] args) {
//        System.out.println(new BasicCalculator().calculate("1 + 1"));
//        System.out.println(new BasicCalculator().calculate("2-1 + 2"));
        System.out.println(new BasicCalculator().calculate("(1+(4+5+2)-3)+(6+8)"));
    }
}
