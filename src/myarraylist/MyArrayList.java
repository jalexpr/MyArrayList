package myarraylist;

import java.util.Iterator;

public class MyArrayList implements Iterable {

    private int size;
    private String arr[];

    public MyArrayList() {
        this(5);
    }

    public MyArrayList(int length) {
        this.size = 0;
        this.arr = new String[length];
    }

    public boolean add(String element) {
        
        if (size >= arr.length) {

            String tempArr[] = new String[arr.length + arr.length / 2 + 1];
            System.arraycopy(arr, 0, tempArr, 0, size);
            arr = tempArr;

        }

        arr[size++] = element;
        return true;
        
    }

    public String get(int index) throws IndexOutOfBoundsException {
        if (index < size) {
            return arr[index];
        }else {
            throw new IndexOutOfBoundsException("End of list.");
        }
    }

    public int indexOf(String element) {
        
        for (int i = 0; i < size; i++) {
            
            if (arr[i].equals(element)) {
                return i;
            }
            
        }
        
        return -1;
        
    }

    public String remove(int index) throws IndexOutOfBoundsException {

        String tempElement = null;

        if (index < size) {
            tempElement = arr[index];
            System.arraycopy(arr, index + 1, arr, index, size - 1 - index);
            size--;
        } else {
            throw new IndexOutOfBoundsException("End of list.");
        }

        return tempElement; 
    }

    public String set(int index, String element) {
        if (index < size) {
            String tempStr = arr[index];
            arr[index] = element;
            return tempStr;
        } else {
            throw new IndexOutOfBoundsException("End of list.");
        }
    }

    @Override
    public Iterator iterator() {
        return new Iterator() {

            private int current = 0;

            @Override
            public boolean hasNext() {
                return current < size;
            }

            @Override
            public String next() {
                String result = arr[current];
                if (!hasNext()) {
                    throw new IndexOutOfBoundsException("End of list.");
                }
                current++;
                return result;
            }
        };
    }

    public int getSize() {
        return size;
    }
}
