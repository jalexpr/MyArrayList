package mycollections.list;

import java.util.Iterator;

public class MyLinkedList implements MyList {

    private Node header;
    private int size;

    public MyLinkedList() {
        header = new Node(null, null, null);
        header.next = header.prev = header;
        size = 0;
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
    public boolean add(Object object) {

        Node node = new Node(object, header, header.prev);

        if (header == header.next) {
            header.next = node;
        } else {
            header.prev.next = node;
        }

        header.prev = node;
        size++;

        return true;
    }

    @Override
    public boolean add(int index, Object object) throws ArrayIndexOutOfBoundsException {

        if (index != size) {
            isIndexValid(index);

            Node nodeNext = searchNode(index);
            Node newNode = new Node(object, nodeNext, nodeNext.prev);

            nodeNext.prev.next = newNode;
            nodeNext.prev = newNode;
            size++;
        } else {
            add(object);
        }

        return true;
    }

    private Node searchNode(int index) throws ArrayIndexOutOfBoundsException {

        Node node = header;

        if (index < (size / 2)) {
            for (int i = 0; i <= index; i++) {
                node = node.next;
            }
        } else {
            for (int i = size; i > index; i--) {
                node = node.prev;
            }
        }

        return node;
    }

    @Override
    public boolean addAll(MyList myList) {
        return addAll(size, myList);
    }

    @Override
    public boolean addAll(int index, MyList myList) {

        for (int i = myList.size() - 1; i >= 0; i--) {
            this.add(index, myList.get(i));
        }

        return true;
    }

    @Override
    public Object get(int index) throws ArrayIndexOutOfBoundsException {
        return searchNode(index).element;
    }

    @Override
    public Object findFirst() {
        return header.next.element;
    }

    @Override
    public Object findLast() {
        return header.prev.element;
    }

    @Override
    public int indexOf(Object element) {

        int indexNode = 0;

        for (Object elementNode : this) {
            if (elementNode.equals(element) && indexNode < size) {
                return indexNode;
            }
            indexNode++;
        }

        return -1;
    }

    @Override
    public boolean set(int index, Object object) throws ArrayIndexOutOfBoundsException {

        Node oldNode = searchNode(index);

        Node newNode = new Node(object, oldNode.next, oldNode.prev);
        oldNode.next.prev = newNode;
        oldNode.prev.next = newNode;

        oldNode.next = null;
        oldNode.prev = null;

        return true;
    }

    @Override
    public Object remove(int index) throws ArrayIndexOutOfBoundsException {
        return removeNode(searchNode(index));
    }

    private Object removeNode(Node nodeRemove) {

        nodeRemove.prev.next = nodeRemove.next;
        nodeRemove.next.prev = nodeRemove.prev;
        nodeRemove.prev = null;
        nodeRemove.next = null;
        size--;

        return nodeRemove.element;
    }

    @Override
    public boolean remove(Object object) {

        boolean isRemove = false;
        Node nodeRemove = header;

        for (int i = 0; i < size; i++) {
            nodeRemove = nodeRemove.next;
            if (nodeRemove.element == null) {
                if (object == null) {
                    Node temp = nodeRemove;
                    nodeRemove = temp.next;
                    removeNode(temp);
                    isRemove = true;
                }
            } else if (nodeRemove.element.equals(object)) {
                Node temp = nodeRemove;
                nodeRemove = temp.next;
                removeNode(temp);
                isRemove = true;
            }
        }

        return isRemove;
    }
    
    @Override
    public boolean removeAll() {
        header.next = header;
        header.prev = header;
        size = 0;
        return true;
    }

    @Override
    public boolean removeAll(MyList otherList) {

        for (Object element : otherList) {
            remove(element);
        }

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

    public Object removeFirst() {
        return removeNode(header.next);
    }

    public Object removeLast() {
        return removeNode(header.prev);
    }

    @Override
    public Object[] toArray() {
        Object[] array = new Object[size];
        Node node = header;

        for (int i = 0; i < size; i++) {
            node = node.next;
            array[i] = node.element;
        }
        return array;
    }

    @Override
    public void clear() {
        header.next = header;
        header.prev = header;
        size = 0;
    }

    @Override
    public Iterator iterator() {
        return new Iterator() {

            private Node currentNode = header.next;

            @Override
            public boolean hasNext() {
                return currentNode != header;
            }

            @Override
            public Object next() {
                Object result = currentNode.element;
                if (!hasNext()) {
                    throw new IndexOutOfBoundsException("End of list.");
                }
                currentNode = currentNode.next;
                return result;
            }

            @Override
            public void remove() {
                MyLinkedList.this.removeNode(currentNode);
            }
        };
    }
    
    @Override
    public MyList getEmptyMyList() {
        return new MyLinkedList();
    }

    private static class Node {

        private Object element;
        private Node next;
        private Node prev;

        protected Node(Object element, Node next, Node prev) {
            this.element = element;
            this.next = next;
            this.prev = prev;
        }
    }
}
