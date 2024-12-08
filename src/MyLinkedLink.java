import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class MyLinkedLink<T> {

    public static class Node<T> {
        protected Node<T> next;
        protected Node<T> previous;
        protected T value;

        public Node(T value, Node<T> previous) {
            this.next = null;
            this.previous = previous;
            this.value = value;
        }

        public Node(T value) {
            this(value, null);
        }
    }

    protected int size;
    protected Node<T> root;
    protected Node<T> end;

    public MyLinkedLink() {
        size = 0;
        root = null;
        end = null;
    }

    private void checkIndexOrThrow(int index) {
        if (index < 0 || index >= size) throw new IndexOutOfBoundsException();
    }

    private Node<T> getNode(int index) {
        checkIndexOrThrow(index);
        if(index == size - 1) return end;

        Node<T> toFind = root;
        for (int i = 0; i < index; i++) toFind = toFind.next;
        return toFind;
    }


    private void addNodeAfterNode(Node<T> toAdd, Node<T> addAfter) {
        size++;
        toAdd.next = addAfter.next;
        toAdd.previous = addAfter;
        addAfter.next = toAdd;
        if (toAdd.next != null) toAdd.next.previous = toAdd;
        if (addAfter == end) end = toAdd;
    }

    private void addFirstNode(Node<T> toAdd) {
        size++;
        toAdd.next = root;
        if(root != null) root.previous = toAdd;
        else end = toAdd;
        root = toAdd;
    }

    public void add(T value, int index) {
        if (index == 0) {
            addFirstNode(new Node<>(value));
        }else {
            addNodeAfterNode(new Node<>(value), getNode(index - 1));
        }
    }

    public void add(T value) {
        add(value, size);
    }

    private void removeNode(Node<T> toRemove){
        size--;
        if (toRemove == root) {
            root = root.next;
            root.previous = null;
        } else if (toRemove == end) {
            end = end.previous;
            end.next = null;
        }else{
            toRemove.previous.next = toRemove.next;
            toRemove.next.previous = toRemove.previous;
        }
    }

    public void remove(int index) {
        removeNode(getNode(index));
    }

    public void removeLast() {
        removeNode(getNode(size - 1));
    }

    public T get(int index){
        return getNode(index).value;
    }

    public int size(){
        return size;
    }
}
