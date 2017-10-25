package nikita.test;

import mycollections.list.MyArrayList;
import mycollections.list.MyList;

public class MyListTests {

//	Выбрал довольно громоздкую запись тестов, но как по мне, довольно подробную и читабельную:
//	Given_Preconditions_When_StateUnderTest_Then_ExpectedBehavior
    public MyList testList;
    public Object[] expectedValues;

    public MyListTests(MyList myList) {
        testList = myList;
    }

    public void verifyAll() {

        try {
            Given_EmptyList_When_AddValues_Then_ListContainsAddedValues();
            Given_ListWithValues_When_AddValuesAtIndex_Then_ListContainsAddedValues();

            Given_ListsWithValues_When_AddAllValuesFromOtherList_Then_TestListContainsAllValuesFromOtherList();
            Given_ListsWithValues_When_AddAllValuesAtIndexFromOtherList_Then_TestListContainsAllValuesFromOtherList();

            Given_ListWithValues_When_FindFirst_Then_ObjectFromFindFirstEqualsFirstValueFromList();
            Given_ListWithValues_When_FindLast_Then_ObjectFromFindLastEqualsLastValueFromList();

            Given_ListWithValues_When_SetValues_Then_ListContainsSettedValues();

            Given_ListWithValues_When_RemoveValues_Then_ListDoesNotContainsRemovedValues();
            Given_ListWithValues_When_RemoveValuesAtIndex_Then_ListDoesNotContainsRemovedValues();

            Given_TwoListsWithValues_When_RemoveAllValuesFromOtherList_Then_ListForRemoveDoesNotContainsAllValuesFromOtherList();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void Given_EmptyList_When_AddValues_Then_ListContainsAddedValues() throws Exception {
        //Given
        testList.clear();

        //When
        testList.add("Test1");
        testList.add("Test2");
        testList.add("Test3");
        testList.add("Test4");
        testList.add("Test5");
        testList.add("Test6");
        testList.add("Test7");
        testList.add("Test8");
        testList.add("Test9");
        testList.add("Test10");

        //Then
        expectedValues = new Object[]{"Test1", "Test2", "Test3",
            "Test4", "Test5", "Test6",
            "Test7", "Test8", "Test9", "Test10"};

        sizeCheck();
        positionCheck();

        System.out.println("Add Object Test passed");
    }

    public void Given_ListWithValues_When_AddValuesAtIndex_Then_ListContainsAddedValues() throws Exception {
        //Given
        prepareTestList(new Object[]{"Test1", "Test2", "Test3",
            "Test4", "Test5", "Test6",
            "Test7", "Test8", "Test9", "Test10"}
        );

        //When
        Object first = "FirstTest0";
        Object middle = "MiddleTest0";

        testList.add(0, first);
        testList.add(7, middle);

        //Then
        expectedValues = new Object[]{first, "Test1", "Test2", "Test3",
            "Test4", "Test5", "Test6", middle,
            "Test7", "Test8", "Test9", "Test10"};

        sizeCheck();
        positionCheck();

        System.out.println("Add At Index Test passed");
    }

    public void Given_ListsWithValues_When_AddAllValuesFromOtherList_Then_TestListContainsAllValuesFromOtherList() throws Exception {
        //Given
        prepareTestList(new Object[]{
            "Test1", "Test2", "Test3",
            "Test4", "Test5", "Test6", null,
            "Test8", "Test9", "Test10", "Test11"
        });

        MyList otherList = new MyArrayList();

        otherList.add("Test12");
        otherList.add("Test13");
        otherList.add("Test14");

        //When
        testList.addAll(otherList);

        //Then
        expectedValues = new Object[]{"Test1", "Test2", "Test3",
            "Test4", "Test5", "Test6", null,
            "Test8", "Test9", "Test10", "Test11", "Test12", "Test13", "Test14"};

        sizeCheck();
        positionCheck();

        System.out.println("Add All Test passed");
    }

    public void Given_ListsWithValues_When_AddAllValuesAtIndexFromOtherList_Then_TestListContainsAllValuesFromOtherList() throws Exception {
        //Given
        prepareTestList(new Object[]{
            "Test1", "Test2", "Test3", "Test4"
        });

        MyArrayList first = new MyArrayList();
        first.add("FirstTest0");
        first.add("FirstTest1");
        first.add("FirstTest2");

        MyArrayList middle = new MyArrayList();
        middle.add("MiddleTest0");
        middle.add("MiddleTest1");

        //When
        testList.addAll(0, first);
        testList.addAll(5, middle);

        //Then
        expectedValues = new Object[]{
            "FirstTest0", "FirstTest1", "FirstTest2",
            "Test1", "Test2",
            "MiddleTest0", "MiddleTest1",
            "Test3", "Test4"
        };

        sizeCheck();
        positionCheck();

        System.out.println("Add All At Index Test passed");

    }

    public void Given_ListWithValues_When_FindFirst_Then_ObjectFromFindFirstEqualsFirstValueFromList() throws Exception {
        //Given
        prepareTestList(new Object[]{"Test1", "Test2", "Test3",
            "Test4", "Test5", "Test6",
            "Test7", "Test8", "Test9", "Test10"});

        //When
        Object firstElement = testList.findFirst();

        //Then
        if (!firstElement.equals("Test1")) {
            testFailed("Wrong first element.", firstElement, "Test1");
        }

        System.out.println("Find First Test passed");
    }

    public void Given_ListWithValues_When_FindLast_Then_ObjectFromFindLastEqualsLastValueFromList() throws Exception {
        //Given
        prepareTestList(new Object[]{"Test1", "Test2", "Test3",
            "Test4", "Test5", "Test6",
            "Test7", "Test8", "Test9", "Test10"});

        //When
        Object lastElement = testList.findLast();

        //Then
        if (!lastElement.equals("Test10")) {
            testFailed("Wrong last element.", lastElement, "Test1");
        }

        System.out.println("Find Last Test passed");
    }

    public void Given_ListWithValues_When_SetValues_Then_ListContainsSettedValues() throws Exception {
        //Given
        prepareTestList(new Object[]{
            "Test1", "Test2", "Test3",
            "Test4", "Test5", "Test6",
            "Test7", "Test8", "Test9", "Test10"
        });

        //When
        testList.set(0, "Test777");
        testList.set(5, "Test999");
        testList.set(9, "Test666");

        //Then
        expectedValues = new Object[]{
            "Test777", "Test2", "Test3",
            "Test4", "Test5", "Test999",
            "Test7", "Test8", "Test9", "Test666"
        };

        sizeCheck();
        positionCheck();

        System.out.println("Set Test passed");
    }

    public void Given_ListWithValues_When_RemoveValues_Then_ListDoesNotContainsRemovedValues() throws Exception {
        //Given
        prepareTestList(new Object[]{
            "Test1", null, "Test3",
            "Test4", "Test5", "Test999",
            "Test7", "Test8", "Test9", "Test10"
        });

        //When
        testList.remove("Test999");
        testList.remove(null);

        //Then
        expectedValues = new Object[]{
            "Test1", "Test3",
            "Test4", "Test5",
            "Test7", "Test8", "Test9", "Test10"
        };

        sizeCheck();
        positionCheck();

        System.out.println("Remove Test passed");
    }

    public void Given_ListWithValues_When_RemoveValuesAtIndex_Then_ListDoesNotContainsRemovedValues() throws Exception {
        //Given
        prepareTestList(new Object[]{
            "Test1", "Test2", "Test3",
            "Test4", "Test5", "Test999",
            "Test7", "Test8", "Test9", "Test10"
        });

        //When
        testList.remove(0);
        testList.remove(5);
        testList.remove(7);

        //Then
        expectedValues = new Object[]{
            "Test2", "Test3",
            "Test4", "Test5", "Test999",
            "Test8", "Test9"
        };

        sizeCheck();
        positionCheck();

        System.out.println("Remove At Index Test passed");
    }

    public void Given_TwoListsWithValues_When_RemoveAllValuesFromOtherList_Then_ListForRemoveDoesNotContainsAllValuesFromOtherList() throws Exception {
        //Given
        prepareTestList(new Object[]{
            "Test1", null, "Test3",
            "Test4", "Test5", "Test999",
            "Test7", "Test8", "Test9", "Test10"
        });

        MyList otherList = new MyArrayList();
        otherList.add(null);
        otherList.add("NotFound1");
        otherList.add("NotFound2");
        otherList.add("Test999");
        otherList.add("NotFound3");
        otherList.add("Test9");
        otherList.add("NotFound4");

        //When
        testList.removeAll(otherList);

        //Then
        expectedValues = new Object[]{
            "Test1", "Test3",
            "Test4", "Test5",
            "Test7", "Test8", "Test10"
        };

        sizeCheck();
        positionCheck();

        System.out.println("Remove All Test passed");
    }

    public void prepareTestList(Object[] data) {
        testList.clear();
        for (Object o : data) {
            testList.add(o);
        }
    }

    public void sizeCheck() throws Exception {
        int listSize = testList.size();

        if (listSize != expectedValues.length) {
            testFailed("Wrong size.", listSize, expectedValues.length);
        }
    }

    public void positionCheck() throws Exception {
        for (int i = 0; i < expectedValues.length; i++) {
            Object listElement = testList.get(i);

            if (listElement == null) {
                if (null != expectedValues[i]) {
                    testFailed("Wrong position at Index <" + i + ">.", testList.get(i), expectedValues[i]);
                }
            } else {
                if (!listElement.equals(expectedValues[i])) {
                    testFailed("Wrong position at Index <" + i + ">.", testList.get(i), expectedValues[i]);
                }
            }

        }
    }

    public void testFailed(String message, Object currentValue, Object expectedValue) throws Exception {
        throw new Exception(message + " Current Value: <" + currentValue + ">, Expected Value: <" + expectedValue + ">.");
    }

}
