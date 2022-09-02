package com.datastructures.backtracking;

import java.util.*;

//NOT WORKING
public class CountVowels {

    Map<String, List<String>>  ruleMap=processRule();
    public int countVowelPermutation(int n) {

        Set<String> resultSet=new HashSet<>();

        countVowelPermutationHelper("aeiou",resultSet,new StringBuilder(""),0,n);
        System.out.println(resultSet);
        return resultSet.size()>new Double(Math.pow(10,9)+7+"").intValue()?new Double(Math.pow(10,9)+7+"").intValue():resultSet.size();
    }

    private void countVowelPermutationHelper(String vowel, Set<String> resultSet, StringBuilder trackerList, int startIndex, int n) {

        if (trackerList.length() == n){
            resultSet.add(trackerList.toString());
            return;
        }

        for(int i=0;i<vowel.length();i++){

                trackerList.append(vowel.charAt(i)+"");
                if(!resultSet.contains(trackerList.toString()) && isValidEntry(trackerList.toString())){
                    countVowelPermutationHelper(vowel,resultSet,trackerList,i+1,n);
                }
                trackerList.deleteCharAt(trackerList.length()-1);

            }
        }

    private boolean isValidEntry(String data) {

        for(int i=1;i<data.length();i++){
            if(ruleMap.containsKey(data.charAt(i)+"")){
                List<String> list=ruleMap.get(data.charAt(i)+"");
                if(!list.contains(data.charAt(i-1)+"")){
                    return false;
                }
            }
        }

        return true;
    }


    private Map<String, List<String>> processRule() {

        Map<String, List<String>>  ruleMap=new HashMap<>();

        List<String> aList=new ArrayList<>();
        aList.add("e");
        ruleMap.put("a",aList);

        List<String> bList=new ArrayList<>();
        bList.add("a");
        bList.add("i");
        ruleMap.put("e",bList);

        List<String> cList=new ArrayList<>();
        cList.add("e");
        cList.add("a");
        cList.add("o");
        cList.add("u");
        ruleMap.put("i",cList);

        List<String> dList=new ArrayList<>();
        dList.add("i");
        dList.add("u");
        ruleMap.put("o",dList);

        List<String> eList=new ArrayList<>();
        eList.add("a");
        ruleMap.put("u",eList);

        return ruleMap;
    }

    public static void main(String[] args) {

//        System.out.println(new CountVowels().countVowelPermutation(1));
        System.out.println(new CountVowels().countVowelPermutation(144));
    }
}
