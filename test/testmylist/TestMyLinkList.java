package testmylist;

import mycollections.list.MyLinkedList;

public class TestMyLinkList extends TestsMyList{

    public static void printMyArrayList(MyLinkedList list) {
        System.out.println(list.toString() + ":\nsize = " + list.size());
        for (Object str : list) {
            System.out.println(str);
        }
        System.out.println("");
    }

    public static void TestMyLinkedList() {

        System.out.println("TestMyArrayList start!!!");
        
        TestMyList(new MyLinkedList());
        
        System.out.println("TestMyArrayList successful!!!\n");
    }
}
