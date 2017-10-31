
package mycollections.map;

public interface MyMap extends Iterable{
    
    public int size();

    public boolean isEmpty();

    public boolean containsKey(Object o);

    public boolean containsValue(Object o);

    public Object get(Object o);

    public Object put(Object k, Object v);

    public Object remove(Object o);

    public void putAll(MyMap map);

    public void clear();

    //public Set keySet();

    //public Collection values();

    //public Set entrySet();
    
    //public boolean equals(MyMap o);
    
    public MyMap getEmptyMyMap();
}
