package myarraylist;

import java.util.Iterator;

public class MyArrayList implements Iterable<String>{

    private int length;
    private int size;
    private String arr[];

    public MyArrayList() {
        this(5);
    }

    public MyArrayList(int length) {
        this.length = length;
        this.size = 0;
        this.arr = new String[length];
    }

    public boolean add(String element) {
        if (size >= length) {
            length += length + length / 2 + 1;
            String tempArr[] = new String[length];
            System.arraycopy(arr, 0, tempArr, 0, size);
            arr = tempArr;
        }

        arr[size++] = element;
        return true;
    }

    public String get(int index) {
        return arr[index];
    }

    public int indexOf(String element) {
        for(int i = 0; i < size; i++){
            if(arr[i].equals(element)){
                return i;
            }
        }
        return -1;
    }

    public String remove(int index) throws IndexOutOfBoundsException {
        
        String tempElement = null;
        
        if(index < size){  
            tempElement = arr[index];
            for(int i = index; i < size - 1; i++) {
                arr[i] = arr[i + 1];
            }
        } else {
            throw new IndexOutOfBoundsException("End of list.");
        }
        
        size--;       
        
        return tempElement;
    }

    public String set(int index, String element){
        if(index < size){
            String tempStr = arr[index];
            arr[index] = element;
            return tempStr;
        } else {
            throw new IndexOutOfBoundsException("End of list.");
        }
    }
    
    @Override
    public Iterator<String> iterator() {
        return new Iterator<String>() {
            
            private int current = 0;

            @Override
            public boolean hasNext() {
                return current < size;
            }

            @Override
            public String next() throws IndexOutOfBoundsException {
                String result = arr[current];
                if (!hasNext()) throw new IndexOutOfBoundsException("End of list.");
                current++;
                return result;
            }
        };
    }

    public int getSize() {
        return size;
    }
}
