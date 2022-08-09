package com.datastructures.linkedlist;

 class MyHashSet {

     int key;
     MyHashSet next;

     public MyHashSet() {
         this.key = 0;
         this.next = null;
     }

     public MyHashSet(int key) {
         this.key = key;
         this.next = null;
     }

     public void add(int key) {

         MyHashSet obj=this;
         if (obj == null){
             obj=new MyHashSet();
         }
         else if(obj.next==null || !contains(key)){
             while(obj.next!=null){
                 obj=obj.next;
             }
             obj.next=new MyHashSet(key);
         }


         return;


     }

     public void remove(int key) {

         MyHashSet obj = this;
         while (obj != null && obj.next!=null) {
             MyHashSet temp = obj.next;
             if (obj.next.key == key) {

                obj.next=obj.next.next;
             }
             else{
                 obj = obj.next;
             }

         }
     }

     public boolean contains(int key) {

         MyHashSet obj = this;
         while (obj != null) {
             if (obj.key == key) return true;
             obj = obj.next;
         }
         return false;
     }

 }

 public class MyHashSetImpl {

     public static void main(String[] args) {

         MyHashSet hSet = new MyHashSet();
         hSet.add(1);
         hSet.add(2);
         hSet.contains(1);
         hSet.contains(3);
         hSet.add(2);
         hSet.contains(2);
         hSet.remove(2);
         hSet.contains(2);
     }


 }

