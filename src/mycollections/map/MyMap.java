
package mycollections.map;

public interface MyMap extends Iterable{
    
    public int size();

    public boolean isEmpty();

    public boolean containsKey(Object key);

    public boolean containsValue(Object value);

    public Object get(Object key);

    public Object put(Object key, Object value);

    public Object remove(Object key);

    public void putAll(MyMap map);

    public void clear();
    
<<<<<<< HEAD
    //public boolean equals(MyMap o);
    
    public MyMap getEmptyMyMap();
=======
    public MyMap getEmptyMyMap();
    
>>>>>>> 4e25cc0c57ca0d27c33dbefe44255a45cb799437
}
