package mycollections.map;

public class MyHashMap implements MyMap {

    //private Entry[] table;
    private int loadFactor = 75;
    private int capacity = 16;
    private int threshold = (capacity * loadFactor) / 100;
    private int size = 0;

    public MyHashMap(int capacity) {
        this.capacity = capacity;
    }

    public MyHashMap(int capacity, double loadFactor) {
        this.capacity = capacity;
        this.loadFactor = (int) (100 * loadFactor);
    }

    public MyHashMap() {
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
    public boolean containsKey(Object value) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean containsValue(Object value) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object get(Object value) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object put(Object key, Object value) {
        if (key == null) {
            return putForNullKey(value);
        } else {
            int hash = hash(key);
            int indexTable = indexFor(hash, threshold);
           // boolean i;
        }
        return new Object();
    }

    
    
    public Object putForNullKey(Object value) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object remove(Object value) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void putAll(MyMap map) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void clear() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private static int hash(Object h) {
        return h.hashCode();
    }   

    private static int indexFor(int hash, int length) {
        return hash & (length - 1);
    }
}
