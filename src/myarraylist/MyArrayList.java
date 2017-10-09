package mycollections;

import java.util.Iterator;

public class MyArrayList implements Iterable, MyList {

    private int size;
    private Object arr[];

    public MyArrayList() {
        this(5);
    }

    public MyArrayList(int length) {

        this.size = 0;
        this.arr = new Object[length];
    }

    //увеличение длинны доступного массива на размер по умолчанию
    private void addLength() {
        addLength((arr.length * 3) / 2);
    }

    //увеличение длинны доступного массива на заданный размер
    private void addLength(int addLength) {

        Object tempArr[] = new Object[arr.length + addLength];
        System.arraycopy(arr, 0, tempArr, 0, size);
        arr = tempArr;
    }

    @Override
    public boolean add(Object element) {

        if (size >= arr.length) {
            addLength();
        }

        arr[size++] = element;
        return true;
    }

    @Override
    public boolean add(int index, Object element) {

        if (size >= arr.length) {
            addLength();
        }
        
        
        System.arraycopy(arr, index, arr, index + 1, size - index);

        arr[index] = element;

        size++;

        return true;
    }

    @Override
    public boolean addAll(MyList source) {
        return addAll(0, source);
    }

    @Override
    public boolean addAll(int start, MyList source) {
        
        Object[] arrSource = ((MyArrayList) source).arr;
        int sourcelength = arrSource.length;
        int newSize = size + ((MyArrayList) source).size() - start;

        if (newSize > arr.length) {
            addLength(sourcelength);
        }

        System.arraycopy(arrSource, start, arr, size,  sourcelength - start);

        size = newSize;

        return true;
    }

    @Override
    public Object get(int index) throws IndexOutOfBoundsException {

        if (index > -1 && index < size && !isEmpty()) {
            return arr[index];
        } else {
            throw new IndexOutOfBoundsException("End of list.");
        }
    }

    @Override
    public Object findFirst() {
        if (!isEmpty()) {
            return arr[0];
        } else {
            throw new IndexOutOfBoundsException();
        }
    }

    @Override
    public Object findLast() {
        if (!isEmpty()) {
            return arr[size - 1];
        } else {
            throw new IndexOutOfBoundsException();
        }
    }

    @Override
    public int indexOf(Object element) {
        if (!isEmpty()) {
            for (int i = 0; i < size; i++) {
                if (arr[i].equals(element)) {
                    return i;
                }
            }
        } else {
            throw new IndexOutOfBoundsException();
        }
        return -1;
    }

    @Override
    public boolean set(int index, Object element) {
        if (index > -1 && index < size && !isEmpty()) {
            arr[index] = element;
            return true;
        } else {
            return false;
        }
    }

    @Override
    public Object remove(int index) {

        Object tempElement = null;

        if (index > -1) {
            if (index < size) {
                tempElement = arr[index];
                System.arraycopy(arr, index + 1, arr, index, size - 1 - index);
                size--;
            } else {
                throw new IndexOutOfBoundsException("End of list.");
            }
        }

        return tempElement;
    }

    @Override
    public boolean remove(Object o) {
        return remove(indexOf(o)) != null;
    }

    @Override
    public boolean removeAll() {

        arr = new Object[arr.length];
        size = 0;

        return true;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
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
            public Object next() {
                Object result = arr[current];
                if (!hasNext()) {
                    throw new IndexOutOfBoundsException("End of list.");
                }
                current++;
                return result;
            }

            @Override
            public void remove() {
                MyArrayList.this.remove(current);
            }
        };
    }

    public int getSize() {
        return size;
    }
}
