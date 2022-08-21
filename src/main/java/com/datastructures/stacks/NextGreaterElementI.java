package com.datastructures.stacks;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class NextGreaterElementI {

    public int[] nextGreaterElement(int[] nums1, int[] nums2) {

            if(nums2.length == 0 || nums1.length==0) return null;
            Map<Integer,Integer> hMap=new HashMap<>();
            Stack<Integer> st=new Stack<>();
            st.push(nums2[0]);
            for(int i=1;i<nums2.length;i++){
                while(!st.isEmpty() && st.peek()<nums2[i]){
                    hMap.put(st.pop(),nums2[i]);
                }

                    st.push(nums2[i]);


            }

            while(!st.isEmpty()){
                hMap.put(st.pop(),-1);
            }

            for(int i=0;i<nums1.length;i++){
                nums1[i]=hMap.get(nums1[i]);
            }
            return nums1;
        }


    public static void main(String[] args) {

        int nums1[]={2,4};
        int nums2[]={1,2,3,4};

        int ans[]=new NextGreaterElementI().nextGreaterElement(nums1,nums2);
        System.out.println("[");
        for(int i:ans){
            System.out.print(i+",");
        }
        System.out.println("]");
    }
}
