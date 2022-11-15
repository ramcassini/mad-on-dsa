package com.datastructures.crashcourse.hashMap;

import java.util.HashMap;
import java.util.Map;

public class IsoMorphicStrings {
    public boolean isIsomorphic(String s, String t) {

        if(s==null && t==null){
            return true;
        }
        if((s==null && t!=null) || (s!=null && t==null) || (s.length()!=t.length())){
            return false;
        }


        Map<Character,Character> hMap=new HashMap<>();
        String ans="";

        for(int i=0;i<s.length();i++){

            if(hMap.containsKey(s.charAt(i))){
                continue;
            }
            else if(hMap.containsValue(t.charAt(i))){
                return false;
            }
            else{
                hMap.put(s.charAt(i),t.charAt(i));
            }
        }
        for(int i=0;i<s.length();i++){

            ans=ans+hMap.get(s.charAt(i));
//            hMap.put()
        }

        if(ans.equals(t)){
            return true;
        }
        else{
            return false;
        }
    }

    public static void main(String[] args) {

        System.out.println(new IsoMorphicStrings().isIsomorphic("egg","add"));
        System.out.println(new IsoMorphicStrings().isIsomorphic("foo","bar"));
        System.out.println(new IsoMorphicStrings().isIsomorphic("paper","title"));
        System.out.println(new IsoMorphicStrings().isIsomorphic("badc","baba"));
    }
}
