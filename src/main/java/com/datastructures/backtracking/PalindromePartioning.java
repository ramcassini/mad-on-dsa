package com.datastructures.backtracking;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class PalindromePartioning {

    public List<List<String>> partition(String s) {

        if(s==null || s.length()==0){
            return null;
        }

        Set<List<String>> resultSet=new HashSet<>();

        partitionHelper(0,resultSet,new ArrayList<String>(),s);

        return new ArrayList<>(resultSet);
    }

    public void partitionHelper(int startIndex,Set<List<String>> resultSet,List<String> trackerList,String s){

        if(trackerList.size()>0)
            if(isPalinDrome(trackerList))
            resultSet.add(new ArrayList<>(trackerList));

        for(int i=startIndex;i<s.length();i++){
            trackerList.add(s.charAt(i)+"");
            partitionHelper(i+1,resultSet,trackerList,s);
            trackerList.remove(  trackerList.size()-1);
        }

    }

    public boolean isPalinDrome(List<String> aList){

        int i=0;
        int j=aList.size()-1;
        while(i<j){
            if(!aList.get(i).equals(aList.get(j))){
               return false;
            }
            i++;
            j--;
        }
        return true;
    }
    public static void main(String[] args) {

        System.out.println(new PalindromePartioning().partition("aab"));
    }
}
