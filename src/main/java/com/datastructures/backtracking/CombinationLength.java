package com.datastructures.backtracking;

import java.util.*;

public class CombinationLength {

    public List<String> combinationFunc(String s,int length) {

        if(s==null || s.length()==0) return null;

        Set<String> resultSet=new TreeSet<>();
        boolean isVisited[]=new boolean[26];
        StringBuilder sb=new StringBuilder("");
        combinationFuncHelper(resultSet,sb,s,0,length,isVisited);

        return new ArrayList<>(resultSet);
    }

    public void combinationFuncHelper(Set<String> resultSet,StringBuilder sb,String s,int sI,int len,boolean[] isVisited){

        if(sb.length()==len){
            resultSet.add(sb.toString());
            return;
        }
        for(int i=sI;i<s.length();i++){

            if(!isVisited[s.charAt(i)-'a']){
                isVisited[s.charAt(i)-'a']=true;
                sb.append(s.charAt(i)+"");
                combinationFuncHelper(resultSet,sb,s,i,len,isVisited);
                sb.deleteCharAt(sb.length()-1);
                isVisited[s.charAt(i)-'a']=false;
            }


        }

    }

    public static void main(String[] args) {

        System.out.println(new CombinationLength().combinationFunc("abc",2));
    }

}
