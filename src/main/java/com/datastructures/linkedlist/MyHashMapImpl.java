package com.datastructures.linkedlist;

class MyHashMap {

    int key;
    int value;
    MyHashMap next;

    public MyHashMap() {
        this.key=-99;
        this.value=-99;
    }

    public MyHashMap(int key,int value) {
        this.key=key;
        this.value=value;
        this.next=null;
    }

    public void put(int key, int value) {

        MyHashMap hMap=this;
        if(hMap==null){
            hMap.put(key,value);
        }
        if(hMap.next == null){
            hMap.next=new MyHashMap(key,value);
        }else if(get(key)!=-1){
            while(hMap!=null){
                if(hMap.key==key){
                    hMap.value=value;
                    break;
                }
                hMap=hMap.next;
            }
        }
        else{
            while(hMap.next!=null){
                hMap=hMap.next;
            }
            hMap.next=new MyHashMap(key,value);
        }

    }

    public int get(int key) {
        MyHashMap hMap=this;
        while(hMap!=null){
            if(hMap.key==key){
                return hMap.value;
//                break;
            }
            hMap=hMap.next;
        }
        return -1;
    }

    public void remove(int key) {
        MyHashMap hMap=this;
        while(hMap!=null && hMap.next!=null){
            MyHashMap temp=hMap.next;
            if(hMap.next.key==key){
                hMap.next=hMap.next.next;
            }
            else{
                hMap=hMap.next;
            }

        }

    }
}

public class MyHashMapImpl {

    public static void main(String[] args) {

        MyHashMap hMap=new MyHashMap();
        hMap.put(1,1);
        hMap.put(2,2);
        hMap.get(1);
        hMap.get(3);
        hMap.put(2,1);
        hMap.get(2);
        hMap.remove(2);
        hMap.get(2);



    }
}
