package cn.msjava.coding;

import java.util.ArrayList;
import java.util.List;

/**
 * @author msJava
 * @Description: 705. 设计哈希集合
 */
public class MyHashSet {


    List<Integer> hashSet;

    public MyHashSet() {
         hashSet=new ArrayList<Integer>();
    }

    public void add(int key) {
        if(!hashSet.contains(key)){
            hashSet.add(key);
        }
    }

    public void remove(int key) {
        for (Integer e : hashSet) {
            if(e==key){
                hashSet.remove(e);
                break;
            }
        }
    }

    public boolean contains(int key) {
        return hashSet.contains(key);
    }



}
