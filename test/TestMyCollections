package testmycollections;

import mycollections.MyList;
import mycollections.MyList;

public class TestMyCollections {

    public static void add_3elements(MyList list) throws Exception {

        int size = list.size();

        list.add("Hello word #1");
        list.add("Hello word #2");
        list.add("Hello word #3");

        if (size == list.size()) {
            throw new Exception();
        }

        System.out.println("Test 'Add 3 elements' successful");
    }

    public static void add_3elementsByIndex(MyList list) throws Exception {

        int size = list.size();

        list.add(1, "Hello word #15");
        list.add(1, "Hello word #13");
        list.add(2, "Hello word #14");

        if (size == list.size()) {
            throw new Exception();
        }

        System.out.println("Test 'Add 3 elements by index' successful");
    }

    public static void addAll_addList2InList1(MyList list1, MyList list2) throws Exception {

        int size1 = list1.size() + list2.size();
        int size2 = list2.size();

        list1.addAll(list2);

        if (size1 != list1.size() || size2 != list2.size()) {
            throw new Exception();
        }

        System.out.println("Test 'addAll add list2 in list1' successful");
    }

    public static void addAll_addList2InList1WithIndex(MyList list1, MyList list2) throws Exception {
    
        int size2 = list2.size();
        int index = size2 / 2; 
        int size1 = list1.size() + size2 - index;

        list1.addAll(index, list2);

        if (size1 != list1.size() || size2 != list2.size()) {
            throw new Exception();
        }

        System.out.println("Test 'addAll add list2 in list1 with index' successful");
    }

    public static void get_getObject(MyList list) throws Exception {

        Object obj = new Object();
        int indexEnd = list.size() / 2;

        list.add(indexEnd, obj);

        if (obj != list.get(indexEnd)) {
            throw new Exception();
        }

        System.out.println("Test 'get Object by Index' successful");
    }

    public static void findFirst_getFirstObject(MyList list) throws Exception {

        Object obj = new Object();

        list.add(0, obj);

        if (!obj.equals(list.get(0))) {
            throw new Exception();
        }

        System.out.println("Test 'find first get first object' successful");
    }

    public static void findLast_getLastObject(MyList list) throws Exception {

        Object obj = new Object();
        int indexEnd = list.size() / 2;

        list.add(indexEnd, obj);

        if (!obj.equals(list.get(indexEnd))) {
            throw new Exception();
        }

        System.out.println("Test 'find last get last object' successful");
    }

    public static void indexOf_getIndexOf(MyList list) throws Exception {

        Object obj = new Object();
        int indexEnd = list.size() / 2;

        list.add(indexEnd, obj);

        if (list.indexOf(obj) != indexEnd) {
            throw new Exception();
        }

        System.out.println("Test 'get Index Of ' successful");
    }

    public static void set_setObjectByIndex(MyList list) throws Exception {

        Object obj = new Object();
        int indexEnd = list.size() / 2;

        list.set(indexEnd, obj);

        if (!list.get(indexEnd).equals(obj)) {
            throw new Exception();
        }

        System.out.println("Test 'set Object by index' successful");
    }

    public static void remove_removeObjectByIndex(MyList list) throws Exception {

        Object obj = new Object();
        int index = list.size() / 2;

        list.set(index, obj);

        if (!list.get(index).equals(obj)) {
            throw new Exception();
        }

        System.out.println("Test 'remove object by index' successful");
    }

    public static void removeAll(MyList list) throws Exception {
        if (list.removeAll()) {
            if (0 == list.size()) {
                System.out.println("Test 'remove all' successful");
                return;
            }
        }
        throw new Exception();
    }
}
