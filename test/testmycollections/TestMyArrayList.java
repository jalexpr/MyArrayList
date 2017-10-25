package testmycollections;

import mycollections.list.MyArrayList;

public class TestMyArrayList extends TestMyCollections {

    private static final MyArrayList arrTest1 = new MyArrayList();
    private static final MyArrayList arrTest2 = new MyArrayList();

    static {
        arrTest2.add("Test 2_1");
        arrTest2.add("Test 2_2");
        arrTest2.add("Test 2_3");
        arrTest2.add("Test 2_4");
        arrTest2.add("Test 2_5");
    }

    public static void printMyArrayList(MyArrayList list) {
        System.out.println(list.toString() + ":\nsize = " + list.size());
        for (Object str : list) {
            System.out.println(str);
        }
        System.out.println("");
    }

    public static void TestMyArrayList() {

        System.out.println("TestMyArrayList start!!!");
        
        try {
            TestMyCollections.add_3elements(arrTest1);
            TestMyCollections.add_3elementsByIndex(arrTest1);
            TestMyCollections.add_3elements(arrTest2);

            TestMyCollections.addAll_addList2InList1(arrTest1, arrTest2);
            TestMyCollections.addAll_addList2InList1WithIndex(arrTest1, arrTest2);

            TestMyCollections.get_getObject(arrTest1);

            TestMyCollections.findFirst_getFirstObject(arrTest1);
            TestMyCollections.findLast_getLastObject(arrTest1);

            TestMyCollections.indexOf_getIndexOf(arrTest1);

            TestMyCollections.set_setObjectByIndex(arrTest1);

            TestMyCollections.remove_removeObjectByIndex(arrTest1);
            TestMyCollections.removeAll(arrTest1);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        
        System.out.println("TestMyArrayList successful!!!\n");
    }
}
