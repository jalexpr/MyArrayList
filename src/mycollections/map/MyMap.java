
package mycollections.map;

public interface MyMap {
    
    public int size();

    public boolean isEmpty();

    public boolean containsKey(Object key);

    public boolean containsValue(Object value);

    public Object get(Object key);

    public Object put(Object key, Object value);

    public Object remove(Object key);

    public void putAll(MyMap map);

    public void clear();
    
    public MyMap getEmptyMyMap();
}
