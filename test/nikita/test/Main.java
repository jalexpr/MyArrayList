package nikita.test;

import mycollections.list.MyArrayList;
import mycollections.list.MyLinkedList;
import mycollections.list.MyList;

public class Main {
    public static void main(String[] args) {
        
        MyList myList = new MyArrayList(1);
        MyListTests tests = new MyListTests(myList);
        tests.verifyAll();

        System.out.println("\nMyArrayList Tests passed\n");

        myList = new MyLinkedList();
        tests = new MyListTests(myList);
        tests.verifyAll();

        System.out.println("\nMyLinkedList Tests passed");
    }
}
