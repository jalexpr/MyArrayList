package old.testmylist;

import mycollections.list.MyArrayList;

public class TestMyArrayList extends TestMyList {

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
            TestMyList.add_3elements(arrTest1);
            TestMyList.add_3elementsByIndex(arrTest1);
            TestMyList.add_3elements(arrTest2);

            TestMyList.addAll_addList2InList1(arrTest1, arrTest2);
            TestMyList.addAll_addList2InList1WithIndex(arrTest1, arrTest2);

            TestMyList.get_getObject(arrTest1);

            TestMyList.findFirst_getFirstObject(arrTest1);
            TestMyList.findLast_getLastObject(arrTest1);

            TestMyList.indexOf_getIndexOf(arrTest1);

            TestMyList.set_setObjectByIndex(arrTest1);

            TestMyList.remove_removeObjectByIndex(arrTest1);
            TestMyList.removeAll(arrTest1);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        
        System.out.println("TestMyArrayList successful!!!\n");
    }
}
