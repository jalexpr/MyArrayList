package testmylist;

import mycollections.list.MyArrayList;

public class TestMyArrayList extends TestsMyList{

    public static void printMyArrayList(MyArrayList list) {
        System.out.println(list.toString() + ":\nsize = " + list.size());
        for (Object str : list) {
            System.out.println(str);
        }
        System.out.println("");
    }

    public static void TestMyArrayList() {

        System.out.println("TestMyArrayList start!!!");
        
        TestMyList(new MyArrayList());
        
        System.out.println("TestMyArrayList successful!!!\n");
    }
}
