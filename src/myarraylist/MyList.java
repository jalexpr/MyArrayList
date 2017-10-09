
package mycollections;

public interface MyList {
        
    public boolean add(Object o);
    public boolean add(int index, Object o);
    
    public boolean addAll(MyList o);
    public boolean addAll(int index, MyList o);
    
    public Object get(int index);

    public Object findFirst();
    
    public Object findLast();
    
    public int indexOf(Object element);

    public boolean set(int index, Object object);
    
    public Object remove(int index);
    public boolean remove(Object object);
    
    public boolean removeAll();
    
    public int size();
    
    public boolean isEmpty();
}
