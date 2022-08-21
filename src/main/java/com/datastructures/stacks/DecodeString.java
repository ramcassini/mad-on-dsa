package com.datastructures.stacks;

public class DecodeString {
    public String decodeString(String s) {

        if(s==null || s.length()==0) return s;
        s=s.replaceAll("\\[","");
        String sArr[]=s.split("]");
        int k=0;
        StringBuilder sb=new StringBuilder();
        int i=0;
        String temp="";
        while(i<sArr.length){
            if(sArr[i].matches(".*[0-9].*")){

                temp=sArr[i].replaceAll("[*0-9]", "");
                k=Integer.parseInt(sArr[i].substring(0,1));
                while(k>0){
                    sb.append(temp);
                    k--;
                }
                i++;
            }


        }

        return sb.toString();
    }

    public static void main(String[] args) {

        System.out.println(new DecodeString().decodeString("3[a]2[bc]"));
    }
}
