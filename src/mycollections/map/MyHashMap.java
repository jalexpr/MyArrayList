package mycollections.map;

<<<<<<< HEAD
import java.util.Iterator;

public class MyHashMap implements MyMap {

    private static int TABLELENGTHDEFAULT = 16;
=======
public class MyHashMap implements MyMap {

    private static int TABLELENGTHDEFAULT = 2;
>>>>>>> 4e25cc0c57ca0d27c33dbefe44255a45cb799437
    private static float LOADFACTORDEFAULT = 0.75f;
    private int tableLength;
    private float loadFactor;
    private Node[] table;
    private int threshold;
    private int size;

    public MyHashMap() {
        this(TABLELENGTHDEFAULT);
    }

    public MyHashMap(int tableLength) {
        this(tableLength, LOADFACTORDEFAULT);
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
        this.table = new Node[tableLength];
        size = 0;

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

        Node firstNodeInCell = table[index];

        if (firstNodeInCell == null || node.equalsByIdentifier(firstNodeInCell)) {
            return replaceFirstNodeInCell(index, node);
        } else {
            return insertNodeBehindNode(firstNodeInCell, node);
        }
    }

    private Object replaceFirstNodeInCell(int index, Node node) {
        
        Node firstNodeInCell = table[index];
        table[index] = node;
        size++;
        
        if(firstNodeInCell == null) {
            return null;
        } else {
            node.next = firstNodeInCell.next;
            return firstNodeInCell.value;
        }
    }
    
    private Object insertNodeBehindNode(Node cellNode, Node newNode) {
        while (cellNode.hasNext()) {
            cellNode = cellNode.next;
            if (cellNode.equalsByIdentifier(newNode)) {
                return replaceValueInNode(cellNode, newNode);
            }
        }
        
        return addNodeLast(cellNode, newNode);
    }
    
    private Object replaceValueInNode(Node oldNode, Node newNode) {
        Object oldValue = newNode.value;
        oldNode.value = newNode.value;
        return oldValue;
    }
    
    private Object addNodeLast(Node lastNode, Node newNode) {
        lastNode.next = newNode;
        size++;
        return null;
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
<<<<<<< HEAD
            int indexTable;
            
            if(key == null) {
                indexTable = 0;
            } else {
                indexTable = indexFor(hashKey(key));
            }
            
        try {
            return searchNodeInCallByKey(table[indexTable], key) != null;
=======
            
        try {
            return searchNodeByKey(key) != null;
>>>>>>> 4e25cc0c57ca0d27c33dbefe44255a45cb799437
        } catch (Exception e) {
            return false;
        }
    }
<<<<<<< HEAD

    private Node searchNodeInCallByKey(Node cellNode, Object key) throws Exception {
            return searchByKeyInCell(cellNode, key);
=======
    
    private Node searchNodeByKey(Object key) throws Exception {
        int indexInTable = searchIndexInTable(key);
        
        return searchNodeInCallByKey(table[indexInTable], key);
    }
    
    private int searchIndexInTable(Object key) {
        return indexFor(hashKey(key));
    }
    
    private Node searchNodeInCallByKey(Node cellNode, Object key) throws Exception {
        return searchByKeyInCell(cellNode, key);
>>>>>>> 4e25cc0c57ca0d27c33dbefe44255a45cb799437
    }

    private Node searchByKeyInCell(Node cellNode, Object key) throws Exception {
        if (cellNode != null) {
            if (cellNode.equalsByIdentifier(key)) {
                return cellNode;
            } else {
                if (cellNode.hasNext()){
                    return searchByKeyInCell(cellNode.next, key);
                }
            }
        }
        throw new Exception("Значение по ключу не найдено!");
<<<<<<< HEAD
    }
    
    public static int hashKey(Object key) {
        if(key == null) {
            return -1;
        } else {
            return key.hashCode();
        }
=======
>>>>>>> 4e25cc0c57ca0d27c33dbefe44255a45cb799437
    }

    @Override
    public boolean containsValue(Object value) {
        for(Node cellNode : table) {
<<<<<<< HEAD
            if(searchByValueInCell(cellNode, value)){
=======
            if(containsValueInCell(cellNode, value)){
>>>>>>> 4e25cc0c57ca0d27c33dbefe44255a45cb799437
                return true;
            }
        }
        return false;
<<<<<<< HEAD
    }
    
    private boolean searchByValueInCell(Node cellNode, Object value) {
        if(cellNode != null) {
            if (cellNode.value.equals(value)){
                return true;
            } else {
                searchByValueInCell(cellNode.next, value);
            }
        } 
        return false;
=======
>>>>>>> 4e25cc0c57ca0d27c33dbefe44255a45cb799437
    }
    
    private boolean containsValueInCell(Node cellNode, Object value) {
        try{
            return searchNodeByValueInCell(cellNode, value) != null;
        } catch (Exception Ex) {
            return false;
        }
    }
    
    private Node searchNodeByValueInCell(Node cellNode, Object value) throws Exception {
        if(cellNode != null) {
            if (cellNode.value.equals(value)){
                return cellNode;
            } else {
                return searchNodeByValueInCell(cellNode.next, value);
            }
        } 
       throw new Exception();
    }
    
    @Override
    public Object get(Object key) {
        try {
            return searchNodeByKey(key).value;
        } catch (Exception ex) {
            return null;
        }
    }

    @Override
    public Object remove(Object key) {
        int indexInTable = searchIndexInTable(key);
        Node cellNode = table[indexInTable];
        
        if(cellNode == null) {
            return null;
        } else {
            if(cellNode.equalsByIdentifier(key)){
                table[indexInTable] = null;
                return cellNode.value;
            } else {
                try{
                    Node nodePrev = searchPrevNodeByKeyInCell(cellNode, key);
                    Node nodeRemove = nodePrev.next;
                    nodePrev.next = nodeRemove.next;
                    return nodeRemove.value;
                } catch (Exception ex) {
                    return null;
                }
            }
        }
    }
    
    private Node searchPrevNodeByKeyInCell(Node prevNode, Object key) throws Exception {
        
        if (prevNode != null  && prevNode.next != null) {
            if (prevNode.next.equalsByIdentifier(key)) {
                return prevNode;
            } else {
                if (prevNode.next.hasNext()){
                    return searchPrevNodeByKeyInCell(prevNode.next, key);
                }
            }
        }
        throw new Exception("Значение по ключу не найдено!");
    }
    
    @Override
    public void putAll(MyMap map) {
        addAllTable(((MyHashMap) map).table);
    }

    @Override
    public void clear() {
<<<<<<< HEAD
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Iterator iterator() {
        return new Iterator() {

            //private Node currentNode = header.next;

            @Override
            public boolean hasNext() {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public Object next() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void remove() {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
        };
    }
=======
        table = new Node[tableLength];
        size = 0;
    }
>>>>>>> 4e25cc0c57ca0d27c33dbefe44255a45cb799437
    
    @Override
    public MyMap getEmptyMyMap() {
        return new MyHashMap();
    }
<<<<<<< HEAD
=======
        
    public static int hashKey(Object key) {
        if(key == null) {
            return 0;
        } else {
            return key.hashCode();
        }
    }
>>>>>>> 4e25cc0c57ca0d27c33dbefe44255a45cb799437
    
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

        public boolean equalsByIdentifier(Node otherNode) {
<<<<<<< HEAD
            return otherNode.hash == hash && (otherNode.key == key || key.equals(otherNode.key));
        }
        
        public boolean equalsByIdentifier(Object otherKey) {
            return hashKey(otherKey) == hash && (otherKey == key || key.equals(otherKey));
=======
            return otherNode.hash == hash && (otherNode.key == key || key != null && key.equals(otherNode.key));
        }
        
        public boolean equalsByIdentifier(Object otherKey) {
            return hashKey(otherKey) == hash && (otherKey == key || key != null && key.equals(otherKey));
>>>>>>> 4e25cc0c57ca0d27c33dbefe44255a45cb799437
        }
    }
}
