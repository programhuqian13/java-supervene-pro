package ch04.linkedlist;

import java.util.*;
import java.util.function.Consumer;

public class MyLinkedList<E> implements Iterable<E> {

    private Node<E> header;

    private Node<E> laster;

    private int modCount;

    private int size;

    public MyLinkedList() {
        doClear();
    }

    /***
     * 清空链表
     * @return
     */
    public void clear() {
        doClear();
    }

    /***
     * 得到链表的大小
     * @return
     */
    public int size() {
        return size;
    }

    /***
     * 判断链表是否为空
     * @return
     */
    public boolean isEmpty() {
        return size() == 0;
    }

    //清空链表操作
    private void doClear() {
        header = new Node<>(null, null, null);
        laster = new Node<>(null, header, null);
        header.next = laster;
        size = 0;
        modCount++;
    }

    /***
     * 添加指定元素到列表的末尾
     * @param elem
     * @return
     */
    public boolean add(E elem) {
        add(size(), elem);
        return true;
    }

    /***
     * 在列表的指定位置添加指定的元素
     * @param idx
     * @param elem
     * @return
     */
    public void add(int idx, E elem) {
        addBefore(getNode(idx, 0, size()), elem);
    }

    /**
     * 获取指定索引的元素
     *
     * @param idx
     * @return
     */
    public E get(int idx) {
        return getNode(idx).data;
    }

    /**
     * 给列表指定位置设置指定元素并返回该索引以前的值
     *
     * @param idx
     * @param newVal
     * @return
     */
    public E set(int idx, E newVal) {
        Node<E> p = getNode(idx);
        E oldVal = p.data;
        p.data = newVal;
        return oldVal;
    }

    /**
     * 移除列表中制定位置的元素并返回
     *
     * @param idx
     * @return
     */
    public E remove(int idx) {
        return remove(getNode(idx));
    }

    /***
     *
     * @param node 节点包含的对象
     * @return 返回删除节点的元素
     */
    public E remove(Node<E> node) {
        node.next.prev = node.prev;
        node.prev.next = node.next;
        size--;
        modCount++;
        return node.data;
    }

    private void addBefore(Node<E> node, E elem) {
        Node<E> newNode = new Node<>(elem, node.prev, node);
        newNode.prev.next = newNode;
        node.prev = newNode;
        size++;
        modCount++;
    }


    private Node<E> getNode(int idx) {
        return getNode(idx, 0, size() - 1);
    }

    private Node<E> getNode(int idx, int lower, int size) {

        Node<E> findNode;

        if (idx < lower || idx > size) {
            throw new IndexOutOfBoundsException();
        }

        if (idx < size() / 2) {
            findNode = header.next;
            for (int i = 0; i < idx; i++) {
                findNode = findNode.next;
            }
        } else {
            findNode = laster;
            for (int i = size(); i > idx; i--) {
                findNode = findNode.prev;
            }
        }

        return findNode;
    }


    private static class Node<E> {
        public Node(E d, Node<E> p, Node<E> n) {
            data = d;
            prev = p;
            next = n;
        }

        public E data;

        public Node<E> prev;

        public Node<E> next;
    }

    /**
     * 是否包含相关的元素
     * @return
     */
    public boolean contains(E ele){
        Node<E> p = header.next;
        while(p!= laster && !(p.data.equals(ele))){
            p = p.next;
        }
        return (p != laster);
    }

    @Override
    public Iterator<E> iterator() {
        return new MyLinkedListIterator();
    }

    @Override
    public void forEach(Consumer<? super E> action) {

    }

    @Override
    public Spliterator<E> spliterator() {
        return null;
    }

    //进行迭代器的实现 通过内部类
    private class MyLinkedListIterator implements Iterator<E> {

        private int expectedModCount = modCount;

        private boolean okToRemove = false;

        private Node<E> current = (Node<E>) header.next;

        @Override
        public boolean hasNext() {
            //只需要判断当前的元素是不是最后一个就ok了
            return current != laster;
        }

        @Override
        public E next() {
            if (modCount != expectedModCount) {
                throw new ConcurrentModificationException();
            }
            if (!hasNext()) {
                throw new NoSuchElementException();
            }

            E nextItem = current.data;
            current = current.next;
            okToRemove = true;
            return nextItem;
        }

        @Override
        public void remove() {
            if (modCount != expectedModCount) {
                throw new ConcurrentModificationException();
            }
            if (!okToRemove) {
                throw new IllegalStateException();
            }

            MyLinkedList.this.remove(current.prev);
            expectedModCount++;
            okToRemove = false;
        }

        @Override
        public void forEachRemaining(Consumer<? super E> action) {

        }
    }
}
