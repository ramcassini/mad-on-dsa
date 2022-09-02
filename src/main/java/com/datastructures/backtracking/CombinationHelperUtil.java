package com.datastructures.backtracking;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class CombinationHelperUtil {

    public static void main(String[] args) {

        CombinationIterator obj=new CombinationIterator("abc",2);
        System.out.println(obj.next());
        System.out.println(obj.hasNext());
        System.out.println(obj.next());
        System.out.println(obj.hasNext());
        System.out.println(obj.next());
        System.out.println(obj.hasNext());
    }

}

class CombinationIterator {

    List<String> resultList;
    // int length;
    int count=0;
    public CombinationIterator(String characters, int combinationLength) {
        this.resultList=combinationFunc(characters,combinationLength);
        // this.length=this.resultList.size();
    }

    public String next() {
        if(hasNext() && this.count<this.resultList.size()){
            String temp=this.resultList.get(0);
            this.resultList.remove(0);
//            this.count++;
            return temp;
            // this.count++;
        }
        return null;
    }

    public boolean hasNext() {
        if(this.resultList.size()>0){
            return true;
        }
        return false;
    }

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
                combinationFuncHelper(resultSet,sb,s,i+1,len,isVisited);
                sb.deleteCharAt(sb.length()-1);
                isVisited[s.charAt(i)-'a']=false;
            }


        }

    }
}