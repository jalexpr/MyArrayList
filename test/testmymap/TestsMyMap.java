package testmymap;

import mycollections.map.MyMap;

public abstract class TestsMyMap {

    public static void TestsMyMap(MyMap myMap) {
        try {

            put_put10ElementNotCollisions_add10Element(myMap.getEmptyMyMap());
            put_put10ElementAnd2Collisions_add12Element(myMap.getEmptyMyMap());
            put_put10ElementAnd2NullKey_add11Element(myMap.getEmptyMyMap());
            put_put10ElementAnd2NullValue_add12Element(myMap.getEmptyMyMap());
            TestContainsKey.containsKey_containsKeyWhenInCellOneNode_getValue10(myMap.getEmptyMyMap());
            TestContainsKey.containsKey_containsKeyWhenInCellTwoNode_getValue10(myMap.getEmptyMyMap());
            TestContainsKey.containsKey_containsKeyNull_getValue15(myMap.getEmptyMyMap());

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static void put_put10ElementNotCollisions_add10Element(MyMap myMap) throws Exception {

        Object[] returnValues = new Object[10];
        Object[] referenceReturnValues = new Object[10];

        myMap.clear();

        for (int i = 0; i < 10; i++) {
            returnValues[i] = myMap.put(Integer.toString(i), i);
        }

        check(myMap, returnValues, referenceReturnValues);

        System.out.println("Test 'put_put10Element_add10Element' successful!");
    }

    public static void put_put10ElementAnd2Collisions_add12Element(MyMap myMap) throws Exception {

        Object[] returnValues = new Object[12];
        Object[] referenceReturnValues = new Object[12];
        referenceReturnValues[10] = 2;
        referenceReturnValues[11] = 4;

        myMap.clear();
        for (int i = 0; i < 10; i++) {
            returnValues[i] = myMap.put(Integer.toString(i), i);
        }

        returnValues[10] = myMap.put("2", 100);
        returnValues[11] = myMap.put("4", 101);

        check(myMap, returnValues, referenceReturnValues);

        System.out.println("Test 'put_put10ElementAnd2Collisions_add12Element' successful!");
    }

    public static void put_put10ElementAnd2NullKey_add11Element(MyMap myMap) throws Exception {

        Object[] returnValues = new Object[12];
        Object[] referenceReturnValues = new Object[11];

        myMap.clear();

        for (int i = 0; i < 10; i++) {
            myMap.put(Integer.toString(i), i);
        }

        returnValues[10] = myMap.put(null, 2);
        returnValues[11] = myMap.put(null, 4);

        check(myMap, returnValues, referenceReturnValues);

        System.out.println("Test 'put_put10ElementAnd2NullKey_add11Element' successful!");
    }

    public static void put_put10ElementAnd2NullValue_add12Element(MyMap myMap) throws Exception {

        Object[] returnValues = new Object[12];
        Object[] referenceReturnValues = new Object[12];

        myMap.clear();

        for (int i = 0; i < 10; i++) {
            myMap.put(Integer.toString(i), i);
        }

        returnValues[10] = myMap.put("11", null);
        returnValues[11] = myMap.put("14", null);

        check(myMap, returnValues, referenceReturnValues);

        System.out.println("Test 'put_put10ElementAnd2NullValue_add12Element' successful!");
    }

    public static void check(MyMap myMap, Object[] returnValues, Object[] referenceReturnValues) throws Exception {
        sizeCheck(myMap, referenceReturnValues.length);
        returnValuesCheck(returnValues, referenceReturnValues);
    }

    public static void sizeCheck(MyMap myMap, int size) throws Exception {
        if (myMap.size() != size) {
            exceptionGeneration("Размер не совпадает!", myMap.size(), size);
        }
    }

    public static void returnValuesCheck(Object[] returnValues, Object[] referenceReturnValues) throws Exception {

        Object returnValue;
        Object referenceReturnValue;

        for (int i = 0; i < referenceReturnValues.length; i++) {

            returnValue = returnValues[i];
            referenceReturnValue = referenceReturnValues[i];

            if (referenceReturnValue == null) {
                if (returnValue != null) {
                    exceptionGeneration("Не совпадение возвращенных значений!", returnValue, referenceReturnValue);
                }
            } else if (!referenceReturnValue.equals(returnValue)) {
                exceptionGeneration("Не совпадение возвращенных значений!", returnValue, referenceReturnValue);
            }
        }
    }

    public static void exceptionGeneration(String message, Object testValue, Object referenceValue) throws Exception {
        throw new Exception(message + " Test Value: " + testValue + " Reference Value: " + referenceValue);
    }

    public static class TestContainsKey {

        private static Object[] returnValues;
        private static Object[] referenceReturnValues;

        public static void containsKey_containsKeyWhenInCellOneNode_getValue10(MyMap myMap) throws Exception {
            containsKey_containsKey_getValue(myMap, 5, "7", 10);
            System.out.println("Test 'containsKey_containsKeyWhenInCellOneNode_getValue10' successful!");
        }

        public static void containsKey_containsKeyWhenInCellTwoNode_getValue10(MyMap myMap) throws Exception {
            containsKey_containsKey_getValue(myMap, 5, "13", 10);
            System.out.println("Test 'containsKey_containsKeyWhenInCellTwoNode_getValue10' successful!");
        }

        public static void containsKey_containsKey10_getNull(MyMap myMap) throws Exception {
            containsKey_containsKey_getValue(myMap, 5, "7", null);
            System.out.println("Test 'containsKey_containsKeyWhenInCellOneNode_getValue10' successful!");
        }

        public static void containsKey_containsKeyNull_getValue15(MyMap myMap) throws Exception {
            containsKey_containsKey_getValue(myMap, 5, null, 15);
            System.out.println("Test 'containsKey_containsKeyNull_getValue15' successful!");
        }

        private static void containsKey_containsKey_getValue(MyMap myMap, int sizeMap, String testKey, Object testValue) throws Exception {
            firstTrainData(myMap, sizeMap);

            returnValues[sizeMap] = myMap.put(testKey, testValue);

            if (!myMap.containsKey(testKey)) {
                exceptionGeneration("Исходное значение по ключу не найдено!", "", testValue);
            }

            check(myMap, returnValues, referenceReturnValues);
        }

        private static void firstTrainData(MyMap myMap, int sizeMap) {
            returnValues = new Object[sizeMap + 1];
            referenceReturnValues = new Object[sizeMap + 1];

            myMap.clear();
            for (int i = 0; i < sizeMap; i++) {
                returnValues[i] = myMap.put(Integer.toString(i), i);
            }
        }
    }

    public static class TestContainsValue {
        
    }
}
