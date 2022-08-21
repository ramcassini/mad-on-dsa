package com.datastructures.stacks;

import java.util.*;

public class RemoveDuplicateLetter {

    public String removeDuplicateLetters(String s) {

        if(s==null || s.length()==0) return s;

        Stack<Character> st=new Stack<>();
        Map<Character,Integer> hMap=new HashMap<>();
        Set<Character> hSet=new HashSet<>();
        for(int i=0;i<s.length();i++){
            hMap.put(s.charAt(i),hMap.getOrDefault(s.charAt(i),0)+1);
        }

        int i=0;
        while(i<s.length()){
            char c=s.charAt(i);
            if(hMap.containsKey(c)){
                hMap.put(c,hMap.get(c)-1);
            }

            i++;
            if(hSet.contains(c)){
                continue;
            }
            while(!st.isEmpty() && st.peek()>c && hMap.get(st.peek())>0){
//                hMap.put(st.peek(),hMap.get(st.peek())-1);
                hSet.remove(st.pop());
            }

//            if(!hSet.contains(c))
            st.push(c);
            hSet.add(c);
//            i++;
        }

        char[] ans=new char[st.size()];
        int k=st.size()-1;
        while(!st.isEmpty()){
            ans[k--]=st.pop();
        }
            return new String(ans);
    }

    public String callReverse(String s){
        char[] cArr=s.toCharArray();

        int i=0;
        int j=s.length()-1;

        while(i<j){

            char temp=cArr[j];
            cArr[j]=cArr[i];
            cArr[i]=temp;
            i++;
            j--;

        }

        return new String(cArr);
    }

    public static void main(String[] args) {

        System.out.println(new RemoveDuplicateLetter().removeDuplicateLetters("bcabc"));
    }

}
