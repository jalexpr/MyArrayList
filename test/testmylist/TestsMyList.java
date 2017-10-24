package testmylist;

import mycollections.list.MyList;

public abstract class TestsMyList {

    public static void TestMyList(MyList myList){
        try {
            add_10elementAdding_10elementAdded(myList.getEmptyMyList());
            add_10elementByIndex_10elementAdded(myList.getEmptyMyList());
            add_3elementFirst_3elementAdded(myList.getEmptyMyList());
            add_3elementLast_3elementAdded(myList.getEmptyMyList());

            addAll_addAllCollection_collectionAddedAll(myList.getEmptyMyList(), myList.getEmptyMyList());
            addAll_addAllCollectionByIndex_collectionAddedAll(myList.getEmptyMyList(), myList.getEmptyMyList());

            findFirst_findFirst_FirstFound(myList.getEmptyMyList());
            findFirst_findLast_FirstFound(myList.getEmptyMyList());

            set_setValueByFirst_changeValue(myList.getEmptyMyList());
            set_setValue_changeValue(myList.getEmptyMyList());
            set_setValueByLast_changeValue(myList.getEmptyMyList());

            remove_removeElement(myList.getEmptyMyList());
            remove_removeElementByIndex(myList.getEmptyMyList());
            removeAll_removeOtherCollection_similarElementsRemoved(myList.getEmptyMyList(), myList.getEmptyMyList());
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    
    public static void add_10elementAdding_10elementAdded(MyList testList) throws Exception {

        testList.clear();
        int amountElements = 10;
        Object[] referenceArray = new Object[amountElements];

        for (int i = 0; i < amountElements; i++) {
            String testElement = "Test" + i;
            testList.add(testElement);
            referenceArray[i] = testElement;
        }

        sizeCheck(testList, referenceArray);
        positionCheck(testList, referenceArray);

        System.out.println("Test 'add_10elementAdding_10elementAdded' successful!");
    }

    public static void sizeCheck(MyList testList, Object[] referenceArray) throws Exception {

        if (testList.size() != referenceArray.length) {
            exceptionGeneration("Размер не совпадает.", testList.size(), referenceArray.length);
        }
    }

    public static void positionCheck(MyList testList, Object[] referenceArray) throws Exception {

        for (int i = 0; i < referenceArray.length; i++) {
            Object listElement = testList.get(i);

            if (listElement == null) {
                if (null != referenceArray[i]) {
                    exceptionGeneration("Ошибка в позиции:" + i, testList.get(i), referenceArray[i]);
                }
            } else {
                if (!listElement.equals(referenceArray[i])) {
                    exceptionGeneration("Ошибка в позиции:" + i, testList.get(i), referenceArray[i]);
                }
            }

        }
    }

    public static void exceptionGeneration(String message, Object testValue, Object referenceValue) throws Exception {
        throw new Exception(message + " Test Value: " + testValue + " Reference Value: " + referenceValue);
    }

    public static void add_10elementByIndex_10elementAdded(MyList testList) throws Exception {

        testList.clear();
        int amountElements = 10;
        Object[] referenceArray;

        for (int i = 0; i < amountElements; i++) {
            String testElement = "Test" + i;
            int index = i / 3;
            testList.add(index, testElement);
        }

        testList.add(6, null);

        referenceArray = new Object[]{"Test2", "Test5", "Test8", "Test9", "Test7",
            "Test6", null, "Test4", "Test3", "Test1", "Test0"
        };

        sizeCheck(testList, referenceArray);
        positionCheck(testList, referenceArray);

        System.out.println("Test 'add_10elementByIndex_10elementAdded' successful!");
    }

    public static void add_3elementFirst_3elementAdded(MyList testList) throws Exception {

        testList.clear();
        int amountElements = 3;
        Object[] referenceArray = new Object[amountElements];

        for (int i = 0; i < amountElements; i++) {
            String testElement = "Test" + i;
            int index = 0;
            testList.add(index, testElement);
            referenceArray[amountElements - 1 - i] = testElement;
        }

        sizeCheck(testList, referenceArray);
        positionCheck(testList, referenceArray);

        System.out.println("Test 'add_3elementFirst_3elementAdded' successful!");
    }

    public static void add_3elementLast_3elementAdded(MyList testList) throws Exception {

        testList.clear();
        int amountElements = 3;
        Object[] referenceArray = new Object[amountElements];

        for (int i = 0; i < amountElements; i++) {
            String testElement = "Test" + i;
            int index = i;
            testList.add(index, testElement);
            referenceArray[index] = testElement;
        }

        sizeCheck(testList, referenceArray);
        positionCheck(testList, referenceArray);

        System.out.println("Test 'add_3elementLast_3elementAdded' successful!");
    }

    public static void addAll_addAllCollection_collectionAddedAll(MyList testList, MyList otherList) throws Exception {

        testList.clear();
        int amountElements = 3;
        Object[] referenceArray = new Object[amountElements * 2];

        for (int i = 0; i < amountElements; i++) {
            String testElement = "Test" + i;
            testList.add(i, testElement);
            referenceArray[i] = testElement;
        }

        for (int i = 0; i < amountElements; i++) {
            String testElement = "Other test " + i;
            otherList.add(i, testElement);
            referenceArray[amountElements + i] = testElement;
        }

        testList.addAll(otherList);

        sizeCheck(testList, referenceArray);
        positionCheck(testList, referenceArray);

        System.out.println("Test 'addAll_addAllCollection_collectionAddedAll' successful!");
    }

    public static void addAll_addAllCollectionByIndex_collectionAddedAll(MyList testList, MyList otherList) throws Exception {

        testList.clear();
        int amountElements = 3;
        Object[] referenceArray;

        for (int i = 0; i < amountElements; i++) {
            String testElement = "Test" + i;
            testList.add(testElement);
        }

        otherList.add(null);
        for (int i = 0; i < amountElements; i++) {
            String testElement = "Other test " + i;
            otherList.add(testElement);
        }

        testList.addAll(1, otherList);

        referenceArray = new Object[]{"Test0", null, "Other test 0",
            "Other test 1", "Other test 2", "Test1", "Test2",};

        sizeCheck(testList, referenceArray);
        positionCheck(testList, referenceArray);

        System.out.println("Test 'addAll_addAllCollectionByIndex_collectionAddedAll' successful!");

    }

    public static void findFirst_findFirst_FirstFound(MyList testList) throws Exception {

        testList.clear();
        Object[] referenceArray = new Object[]{"Test1", "Test2", "Test3"};
        Object referenceElement = referenceArray[0];

        for (Object obj : referenceArray) {
            testList.add(obj);
        }

        Object testElement = testList.findFirst();

        if (!testElement.equals(referenceElement)) {
            exceptionGeneration("Ошибка в позиции: 1 ", testElement, referenceElement);
        }

        System.out.println("Test 'addAll_addAllCollectionByIndex_collectionAddedAll' successful!");
    }

    public static void findFirst_findLast_FirstFound(MyList testList) throws Exception {

        testList.clear();
        Object[] referenceArray = new Object[]{"Test1", "Test2", "Test3"};
        Object referenceElement = referenceArray[referenceArray.length - 1];

        testList.add(referenceElement);
        for (Object obj : referenceArray) {
            testList.add(obj);
        }

        Object testElement = testList.findFirst();

        if (!testElement.equals(referenceElement)) {
            exceptionGeneration("Ошибка в позиции: 1 ", testElement, referenceElement);
        }

        System.out.println("Test 'findFirst_findLast_FirstFound' successful!");
    }

    public static void set_setValueByFirst_changeValue(MyList testList) throws Exception {
        set_setValueByIndex(testList, 0);
        System.out.println("Test 'set_setValueByFirst_changeValue' successful!");
    }

    private static void set_setValueByIndex(MyList testList, int index) throws Exception {

        testList.clear();
        Object[] referenceArray = new Object[]{"Test1", "Test2", "Test3"};
        Object referenceElement = "referenceElement";

        for (Object obj : referenceArray) {
            testList.add(obj);
        }

        referenceArray[index] = referenceElement;
        testList.set(index, referenceElement);

        sizeCheck(testList, referenceArray);
        positionCheck(testList, referenceArray);

        System.out.println("Test 'set_setValueByIndex' successful!");
    }

    public static void set_setValue_changeValue(MyList testList) throws Exception {
        set_setValueByIndex(testList, 1);
        System.out.println("Test 'set_setValue_changeValue' successful!");
    }

    public static void set_setValueByLast_changeValue(MyList testList) throws Exception {
        set_setValueByIndex(testList, 2);
        System.out.println("Test 'set_setValueByLast_changeValue' successful!");
    }

    public static void remove_removeElement(MyList testList) throws Exception {

        testList.clear();
        Object[] referenceArray = new Object[]{"Test1", "Test3"};

        testList.add("Test0");
        testList.add("Test1");
        testList.add("Test2");
        testList.add("Test3");
        testList.add("Test4");

        testList.remove("Test0");
        testList.remove("Test2");
        testList.remove("Test4");

        sizeCheck(testList, referenceArray);
        positionCheck(testList, referenceArray);

        System.out.println("Test 'remove_removeElement' successful!");
    }

    public static void remove_removeElementByIndex(MyList testList) throws Exception {

        testList.clear();
        Object[] referenceArray = new Object[]{"Test1", "Test3"};

        testList.add("Test0");
        testList.add("Test1");
        testList.add("Test2");
        testList.add("Test3");
        testList.add("Test4");

        validComparisonvi(testList.remove(0), "Test0");
        validComparisonvi(testList.remove(3), "Test4");
        validComparisonvi(testList.remove(1), "Test2");

        sizeCheck(testList, referenceArray);
        positionCheck(testList, referenceArray);

        System.out.println("Test 'remove_removeElementByIndex' successful!");
    }

    private static void validComparisonvi(Object testValue, Object referenceValue) throws Exception {
        if (!testValue.equals(referenceValue)) {
            exceptionGeneration("Разные объекты. ", testValue.toString(), referenceValue.toString());
        }
    }

    public static void removeAll_removeOtherCollection_similarElementsRemoved(MyList testList, MyList otherList) throws Exception {

        testList.clear();
        Object[] referenceArray = new Object[]{"Test0", "Test1", "Test8"};

        testList.add("Test0");
        testList.add("Test2");
        testList.add("Test5");
        testList.add("Test1");
        testList.add("Test5");
        testList.add("Test8");

        otherList.add("Test3");
        otherList.add("Test7");
        otherList.add("Test2");
        otherList.add("Test4");
        otherList.add("Test9");
        otherList.add("Test5");

        testList.removeAll(otherList);
        
        sizeCheck(testList, referenceArray);
        positionCheck(testList, referenceArray);

        System.out.println("Test 'removeAll_removeOtherCollection_similarElementsRemoved' successful!");
    }
}
