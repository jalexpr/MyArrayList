package testmycollections;

import mycollections.list.MyLinkedList;

public class TestMyLinkList {

    private static final MyLinkedList listTest1 = new MyLinkedList();
    private static final MyLinkedList listTest2 = new MyLinkedList();

    static {
        listTest2.add("Test 2_1");
        listTest2.add("Test 2_2");
        listTest2.add("Test 2_3");
        listTest2.add("Test 2_4");
        listTest2.add("Test 2_5");
    }

    public static void printMyArrayList(MyLinkedList list) {
        System.out.println(list.toString() + ":\nsize = " + list.size());
        for (Object str : list) {
            System.out.println(str);
        }
        System.out.println("");
    }

    public static void TestMyLinkedList() {

        System.out.println("TestMyArrayList start!!!");
        
        try {
            TestMyCollections.add_3elements(listTest1);
            TestMyCollections.add_3elementsByIndex(listTest1);
            TestMyCollections.add_3elements(listTest2);

            TestMyCollections.addAll_addList2InList1(listTest1, listTest2);
            TestMyCollections.addAll_addList2InList1WithIndex(listTest1, listTest2);

            TestMyCollections.get_getObject(listTest1);

            TestMyCollections.findFirst_getFirstObject(listTest1);
            TestMyCollections.findLast_getLastObject(listTest1);

            TestMyCollections.indexOf_getIndexOf(listTest1);

            TestMyCollections.set_setObjectByIndex(listTest1);
            
            TestMyCollections.remove_removeObjectByIndex(listTest1);
            TestMyCollections.removeAll(listTest1);

        } catch (Exception ex) {
            ex.printStackTrace();
        }
        
        System.out.println("TestMyArrayList successful!!!\n");
    }
}
