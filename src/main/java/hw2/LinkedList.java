package hw2;

import java.util.NoSuchElementException;

public class LinkedList<T> {

    int size = 0;
    int modCount = 0;
    Node<T> first;


    public boolean isEmpty(){
        return first == null;
    }

    /**
     * Получение первого элемента списка
     */
    public T get() {
        final Node<T> f = first;
        if (f == null)
            throw new NoSuchElementException();
        return f.item;
    }

    public void push(T t){
        Node node = new Node(t);
        node.next = first;
        first = node;
    }


    public T poll() {
        final Node<T> f = first;
        return (f == null) ? null : unlinkFirst(f);
    }

    private T unlinkFirst(Node<T> f) {
        final T element = f.item;
        final Node<T> next = f.next;
        f.item = null;
        f.next = null;
        first = next;
        size--;
        modCount++;
        return element;
    }

    public void add(T t) {
        final Node<T> f = first;
        final Node<T> newNode = new Node<>(t, f);
        first = newNode;
        size++;
        modCount++;
    }

    private static class Node<T> {
        T item;
        Node<T> next;

        Node(T element) {
            this.item = element;
        }

        Node(T element, Node<T> next){
            this.item = element;
            this.next = next;
        }


    }
}
