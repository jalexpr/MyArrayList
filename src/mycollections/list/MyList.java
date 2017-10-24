package mycollections.list;

public interface MyList extends Iterable {
    
    public boolean isIndexValid(int index);

    public boolean add(Object object);

    public boolean add(int index, Object object) throws ArrayIndexOutOfBoundsException;

    public boolean addAll(MyList myList);

    public boolean addAll(int index, MyList myList) throws ArrayIndexOutOfBoundsException;

    public Object get(int index) throws ArrayIndexOutOfBoundsException;

    public Object findFirst();

    public Object findLast();

    public int indexOf(Object element);

    public boolean set(int index, Object object) throws ArrayIndexOutOfBoundsException;

    public Object remove(int index) throws ArrayIndexOutOfBoundsException;

    public boolean remove(Object object);

    public boolean removeAll(MyList otherList);
    
    public boolean removeAll();

    public int size();

    public boolean isEmpty();
    
    public Object[] toArray();
    
    public void clear();
    
    public MyList getEmptyMyList();
}
