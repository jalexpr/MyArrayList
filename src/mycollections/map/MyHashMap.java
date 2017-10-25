package mycollections.map;

import java.sql.Time;
import java.util.Date;

public class MyHashMap implements MyMap {

    private int tableLength;
    private float loadFactor;
    private Node[] table;
    private int threshold;
    private int size;

    public MyHashMap() {
        this(16);
    }

    public MyHashMap(int tableLength) {
        this(tableLength, 0.75f);
    }

    public MyHashMap(int tableLength, float loadFactor) {
        this.tableLength = tableLength;
        this.loadFactor = loadFactor;
        this.table = new Node[tableLength];
        this.threshold = newThreshold();
        this.size = 0;
    }

    private int newTableLength() {
        return tableLength * 2;
    }

    private int newThreshold() {
        return (int) (tableLength * loadFactor);
    }

    @Override
    public Object put(Object key, Object value) {

        if (isTableExpand()) {
            enlargeTable();
        }

        if (key == null) {
            return putForNullKey(value);
        } else {
            return putNode(new Node(key, value));
        }
    }

    private boolean isTableExpand() {
        return size > threshold;
    }

    private void enlargeTable() {

        tableLength = newTableLength();
        threshold = newThreshold();

        Node[] oldTable = table;
        this.table = new Node[threshold];

        addAllTable(oldTable);
    }

    private void addAllTable(Node[] newTable) {
        for (Node node : newTable) {
            addAllNode(node);
        }
    }

    private void addAllNode(Node node) {
        while (node != null) {
            putNode(node);
            node = node.next;
        }
    }

    private Object putNode(Node node) {
        return addNodeInCell(indexFor(node.hash), node);
    }

    private int indexFor(int hash) {
        return hash & (tableLength - 1);
    }

    private Object addNodeInCell(int index, Node node) {

        Node cellNode = table[index];

        if (cellNode == null) {
            table[index] = node;
            return null;
        } else {
            do {
                if (cellNode.equalsByIndicators(node)) {
                    table[index] = node;
                    return cellNode.value;
                }
            } while (cellNode.hasNext());

            cellNode.next = node;
            return node.value;
        }
    }

    public Object putForNullKey(Object value) {
        return addNodeInCell(0, new Node(null, value));
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
    public boolean containsKey(Object key) {
        try{
            Node cellNode = table[indexFor(hashKey(key))];
            return searchNodeInCallByKey(cellNode, key) != null;
        } catch (Exception e) {
            return false;
        }
    }

    private Node searchNodeInCallByKey(Node cellNode, Object key) throws Exception{
        
        if (cellNode != null) {
            int keyHash = hashKey(key);
            do {
                if (cellNode.equalsByIdentifier(key, keyHash)){
                    return cellNode;
                }
            } while (cellNode.hasNext());
        }
        throw new Exception("Ошибка поиска по ключу!");
    }

    public static int hashKey(Object h) {
        return h.hashCode() + 1;
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

    private class Node {

        int hash;
        Object key;
        Node next;
        Object value;

        public Node(Object key, Object value) {
            this.hash = hashKey(key);
            this.key = key;
            this.value = value;
        }

        public Node(int hash, Object key, Node next, Object value) {
            this.hash = hash;
            this.key = key;
            this.next = next;
            this.value = value;
        }

        public boolean hasNext() {
            return next != null;
        }

        public boolean equalsByIndicators(Node node) {
            return node.hash == hash && (node.key == key || key.equals(node.key));
        }
        
        public boolean equalsByIdentifier(Object otherKey, int hashKey) {
            return hashKey == hash && (otherKey == key || key.equals(otherKey));
        }
    }
}
