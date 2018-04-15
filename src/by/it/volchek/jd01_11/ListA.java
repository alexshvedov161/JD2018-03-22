package by.it.volchek.jd01_11;

import java.util.*;

/**
 * Created by volchek on 14.04.18.
 */
public class ListA<T> implements List<T> {
    @SuppressWarnings("all")
    private T[] elements = (T[])new Object[]{};
    private int size = 0;



    @Override
    public boolean add(T element) {
        if(size==elements.length)
            elements=Arrays.copyOf(elements,(size*3/2+1));
        elements[size++] = element;
        return false;
    }
    @Override
    public T remove(int index) {
        T deleted = elements[index];
        System.arraycopy(elements,index+1,elements,index,size-index);
        size--;
        return deleted;
    }
    @Override
    public T get(int index) {

        return elements[index];
    }
    @Override
    public  String toString(){
        StringBuilder sb = new StringBuilder("[");
        String delimeter="";
        for (int i = 0; i <size ; i++) {

            sb.append(delimeter).append(elements[i]);
            delimeter=", ";
        }
        sb.append("]");
        return sb.toString();
    }




    @Override
    public int size() {
        return 0;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public boolean contains(Object o) {
        return false;
    }

    @Override
    public Iterator<T> iterator() {
        return null;
    }

    @Override
    public Object[] toArray() {
        return new Object[0];
    }

    @Override
    public <T1> T1[] toArray(T1[] a) {
        return null;
    }



    @Override
    public boolean remove(Object o) {
        return false;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean addAll(Collection<? extends T> c) {
        return false;
    }

    @Override
    public boolean addAll(int index, Collection<? extends T> c) {
        return false;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return false;
    }

    @Override
    public void clear() {

    }



    @Override
    public T set(int index, T element) {
        return null;
    }

    @Override
    public void add(int index, T element) {

    }



    @Override
    public int indexOf(Object o) {
        return 0;
    }

    @Override
    public int lastIndexOf(Object o) {
        return 0;
    }

    @Override
    public ListIterator<T> listIterator() {
        return null;
    }

    @Override
    public ListIterator<T> listIterator(int index) {
        return null;
    }

    @Override
    public List<T> subList(int fromIndex, int toIndex) {
        return null;
    }
}
