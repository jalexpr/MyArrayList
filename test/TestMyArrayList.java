package testmycollections;

import mycollections.*;
import mycollections.MyArrayList;

public class TestMyArrayList {

    private static MyArrayList arrTest1 = new MyArrayList();
    private static MyArrayList arrTest2 = new MyArrayList();
    
    static {
        arrTest2.add("Test 2_1");
        arrTest2.add("Test 2_2");
        arrTest2.add("Test 2_3");
        arrTest2.add("Test 2_4");
        arrTest2.add("Test 2_5");
    }
    
    public static void printMyArrayList(MyArrayList list) {
        System.out.println(list.toString() + ":\nsize = " + list.getSize());
        for (Object str : list) {
            System.out.println(str);
        }
        System.out.println("");
    }

    public static void main(String[] args) {
        
        try {
            TestMyCollections.add_3elements(arrTest1);
            
            printMyArrayList(arrTest1);

            TestMyCollections.add_3elementsByIndex(arrTest1);

            printMyArrayList(arrTest1);

            TestMyCollections.add_3elements(arrTest2);

            printMyArrayList(arrTest2);

            TestMyCollections.addAll_addList2InList1(arrTest1, arrTest2);

            printMyArrayList(arrTest1);
            printMyArrayList(arrTest2);

            TestMyCollections.addAll_addList2InList1WithIndex(arrTest1, arrTest2);

            printMyArrayList(arrTest1);

            TestMyCollections.get_getObject(arrTest1);

            printMyArrayList(arrTest1);

            TestMyCollections.findFirst_getFirstObject(arrTest1);

            printMyArrayList(arrTest1);

            TestMyCollections.findLast_getLastObject(arrTest1);

            printMyArrayList(arrTest1);

            TestMyCollections.indexOf_getIndexOf(arrTest1);

            printMyArrayList(arrTest1);

            TestMyCollections.set_setObjectByIndex(arrTest1);

            printMyArrayList(arrTest1);

            TestMyCollections.remove_removeObjectByIndex(arrTest1);

            printMyArrayList(arrTest1);

            TestMyCollections.removeAll(arrTest1);

            printMyArrayList(arrTest1);

            
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        
        
    }
}
