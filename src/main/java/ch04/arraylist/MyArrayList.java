package ch04.arraylist;


import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Spliterator;
import java.util.function.Consumer;

/***
 * ArrayList的实现
 * @param <E> 指定泛型
 */
public class MyArrayList<E> implements Iterable<E> {

    private E[] elementData;  //基础数组

    //默认大小
    private static final int DEFAULT_CAPACITY = 10;

    private int size;  //当前数组的大小

    public MyArrayList() {
        doClear();
    }


    private void doClear() {
        this.size = 0;
        ensureCapacity(DEFAULT_CAPACITY);
    }

    private void ensureCapacity(int newCapacity) {
        if (newCapacity < size) {
            return;
        }
        E[] old = elementData;  //来存储对元素数组的一个引用
        //为新数组分配内存  泛型数组的创建时非法的
        elementData = (E[]) new Object[newCapacity];
        for (int i = 0; i < size(); i++) {
            elementData[i] = old[i];  //将旧数组拷贝到新数组
        }
    }


    public boolean add(E addEle) {
        add(size(), addEle);
        return true;
    }

    public void add(int idx, E element) {
        //进行扩容
        if (elementData.length == size()) {
            ensureCapacity(size() * 2 + 1);
        }

        for (int i = size; i > idx; i--) {
            elementData[i] = elementData[i - 1];
        }

        elementData[idx] = element;

        size++;
    }

    public int size() {
        return this.size;
    }

    public boolean isEmpty() {
        return this.size == 0;
    }

    public void clear() {
        doClear();
    }

    //重新调整list 方便GC回收
    public void trimToSize() {
        ensureCapacity(size());
    }

    public E set(int idx, E newVal) {
        //判断idx和size的大小
        if (idx < 0 || idx >= size()) {
            throw new ArrayIndexOutOfBoundsException();
        }
        E old = elementData[idx];
        elementData[idx] = newVal;
        return old;
    }

    public E get(int idx) {
        if (idx < 0 || idx >= size()) {
            throw new ArrayIndexOutOfBoundsException();
        }
        return elementData[idx];
    }

    public E remove() {
        E ele = remove(-1);
        return ele;
    }

    public void remove(E elem) {

    }

    public E remove(int idx) {
        E removeElement = elementData[idx];
        for (int i = 0; i < size(); i++) {
            elementData[i] = elementData[i + 1];
        }
        size--;
        return removeElement;
    }

    @Override
    public Iterator<E> iterator() {
        return new MyArrayListIterator<>();
    }

    @Override
    public void forEach(Consumer<? super E> action) {

    }

    @Override
    public Spliterator<E> spliterator() {
        return null;
    }


    //存储当前位置的概念
    class MyArrayListIterator<E> implements Iterator<E> {

        private int current = 0;

        @Override
        public boolean hasNext() {
            return current < size();
        }

        @Override
        public E next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            return (E) elementData[current++];
        }

        @Override
        public void remove() {
            MyArrayList.this.remove(--current);
        }

        @Override
        public void forEachRemaining(Consumer<? super E> action) {

        }
    }


}
