package testmymap;

import mycollections.map.*;


public class TestMyMap extends TestsMyMap{

    public static void printMyArrayList(MyMap map) {
        System.out.println(map.toString() + ":\nsize = " + map.size());
        for (Object str : map) {
            System.out.println(str);
        }
        System.out.println("");
    }

    public static void TestMyHashMap() {

        System.out.println("TestMyArrayList start!!!");
        
        TestsMyMap(new MyHashMap());
        
        System.out.println("TestMyArrayList successful!!!\n");
    }
}
