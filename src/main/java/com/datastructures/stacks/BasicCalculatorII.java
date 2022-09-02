package com.datastructures.stacks;

import java.util.Stack;

public class BasicCalculatorII {
    public int calculate(String s) {

        if(s==null || s.length()<1) return 0;

        int ans=0;
        int sign=1;
        int curr=0;
        int i=0;
        int total;
        s=s.replaceAll(" ","");
        Stack<Integer> st=new Stack<>();

        while(i<s.length()){
            if(Character.isDigit(s.charAt(i))){
                String temp="";
                while(i<s.length() && Character.isDigit(s.charAt(i))){

                    temp=temp+s.charAt(i);
                    i++;
                }
                ans=ans+Integer.parseInt(temp);
                temp="";
                if(s.charAt(i)=='*'){
                    while(i<s.length()-1 && Character.isDigit(s.charAt(i))){

                        temp=temp+s.charAt(i);
                        i++;
                    }
                    ans=ans*Integer.parseInt(temp);
                    st.push(ans);
                    st.push(sign);
                    ans=0;
                    sign=1;
                }
                else if(s.charAt(i)=='/'){
                    while(i<s.length()-1 && Character.isDigit(s.charAt(i))){

                        temp=temp+s.charAt(i);
                        i++;
                    }
                    ans=ans/Integer.parseInt(temp);
                    st.push(ans);
                    st.push(sign);
                    ans=0;
                    sign=1;
                }
                continue;
            }
            else if(s.charAt(i)=='+'){
                sign=1;

            }
            else if(s.charAt(i)=='-'){
                sign=-1;
            }
            i++;
        }
        while(!st.empty()){
            ans=ans*st.pop();
            ans=ans+st.pop();
        }
        return ans;
    }

    public static void main(String[] args) {
//        System.out.println(new BasicCalculator().calculate("1 + 1"));
//        System.out.println(new BasicCalculator().calculate("2-1 + 2"));
        System.out.println(new BasicCalculatorII().calculate("1-1+1"));
    }
}
