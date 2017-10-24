package old.testmylist;

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
            TestMyList.add_3elements(listTest1);
            TestMyList.add_3elementsByIndex(listTest1);
            TestMyList.add_3elements(listTest2);

            TestMyList.addAll_addList2InList1(listTest1, listTest2);
            TestMyList.addAll_addList2InList1WithIndex(listTest1, listTest2);

            TestMyList.get_getObject(listTest1);

            TestMyList.findFirst_getFirstObject(listTest1);
            TestMyList.findLast_getLastObject(listTest1);

            TestMyList.indexOf_getIndexOf(listTest1);

            TestMyList.set_setObjectByIndex(listTest1);
            
            TestMyList.remove_removeObjectByIndex(listTest1);
            TestMyList.removeAll(listTest1);

        } catch (Exception ex) {
            ex.printStackTrace();
        }
        
        System.out.println("TestMyArrayList successful!!!\n");
    }
}
