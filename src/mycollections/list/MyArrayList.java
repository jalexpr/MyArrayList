package mycollections.list;

import java.util.Iterator;

public class MyArrayList implements MyList {

    private int size;
    private Object[] array;

    public MyArrayList() {
        this(5);
    }

    public MyArrayList(int length) {

        this.size = 0;
        this.array = new Object[length];
    }

    //увеличение длинны доступного массива на размер по умолчанию
    private void addLength() {
        addLength((array.length * 3) / 2);
    }

    //увеличение длинны доступного массива на заданный размер
    private void addLength(int addLength) {

        Object tempArr[] = new Object[array.length + addLength];
        System.arraycopy(array, 0, tempArr, 0, size);
        array = tempArr;
    }

    @Override
    public boolean add(Object element) {

        if (size >= array.length) {
            addLength();
        }

        array[size++] = element;
        return true;
    }

    @Override
    public boolean add(int index, Object element) {

        if (size >= array.length) {
            addLength();
        }

        System.arraycopy(array, index, array, index + 1, size - index);

        array[index] = element;

        size++;

        return true;
    }

    @Override
    public boolean addAll(MyList source) {
        return addAll(size, source);
    }

    @Override
    public boolean addAll(int startIndex, MyList source) {

        Object[] sourceArray = source.toArray();
        int newSize = size + sourceArray.length;
        Object[] newArray = new Object[newSize];

        System.arraycopy(array, 0, newArray, 0, startIndex);
        System.arraycopy(sourceArray, 0, newArray, startIndex, sourceArray.length);
        System.arraycopy(array, startIndex, newArray, startIndex + sourceArray.length, size - startIndex);

        array = newArray;
        size = newSize;

        return true;
    }

    @Override
    public Object get(int index) throws IndexOutOfBoundsException {

        if (index > -1 && index < size && !isEmpty()) {
            return array[index];
        } else {
            throw new IndexOutOfBoundsException("End of list.");
        }
    }

    @Override
    public Object findFirst() {
        if (!isEmpty()) {
            return array[0];
        } else {
            throw new IndexOutOfBoundsException();
        }
    }

    @Override
    public Object findLast() {
        if (!isEmpty()) {
            return array[size - 1];
        } else {
            throw new IndexOutOfBoundsException();
        }
    }

    @Override
    public int indexOf(Object element) {
        if (!isEmpty()) {
            for (int i = 0; i < size; i++) {
                if (array[i] == null || element == null) {
                    if (array[i] == element) {
                        return i;
                    }
                } else if (array[i] == null && element == null) {
                    return i;
                } else if (array[i].equals(element)) {
                    return i;
                }
            }
        }

        return -1;
    }

    @Override
    public boolean set(int index, Object element) {
        if (index > -1 && index < size && !isEmpty()) {
            array[index] = element;
            return true;
        } else {
            return false;
        }
    }

    @Override
    public Object remove(int index) throws ArrayIndexOutOfBoundsException {

        isIndexValid(index);

        Object tempElement = array[index];
        System.arraycopy(array, index + 1, array, index, size - 1 - index);
        size--;

        return tempElement;
    }

    @Override
    public boolean remove(Object o) {
        try {
            while(remove(indexOf(o)) != null) {
            }
            return true;
        } catch (ArrayIndexOutOfBoundsException e) {
            return false;
        }
    }

    @Override
    public boolean removeAll(MyList otherList) {
        for (Object element : otherList) {
            remove(element);
        }

        return true;
    }

    @Override
    public boolean removeAll() {

        array = new Object[array.length];
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
    public void clear() {
        array = new Object[array.length];
        size = 0;
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
                Object result = array[current];
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

    @Override
    public boolean isIndexValid(int index) throws ArrayIndexOutOfBoundsException {
        if (size > index && index >= 0) {
            return true;
        } else {
            throw new ArrayIndexOutOfBoundsException("Выход за границы листа:\n index = " + index + "\n size = " + size);
        }
    }

    @Override
    public Object[] toArray() {

        Object[] getArray;

        if (size > 1) {
            getArray = new Object[size];
            System.arraycopy(array, 0, getArray, 0, size);
            return getArray;
        }

        return new Object[0];
    }
    
    @Override
    public MyList getEmptyMyList() {
        return new MyArrayList();
    }
}
