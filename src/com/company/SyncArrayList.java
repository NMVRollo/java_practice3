package com.company;

import java.util.*;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class SyncArrayList<T> implements List<T> {

    private final ArrayList<T> list = new ArrayList<>();
    private final Lock lock = new ReentrantLock(true);

    @Override
    public int size() {
        lock.lock();
        int size = list.size();
        lock.unlock();
        return size;
    }

    @Override
    public boolean isEmpty() {
        lock.lock();
        boolean isEmpty = list.isEmpty();
        lock.unlock();
        return isEmpty;
    }

    @Override
    public boolean contains(Object o) {
        lock.lock();
        boolean isContains = list.contains(o);
        lock.unlock();
        return isContains;
    }

    @Override
    public Iterator<T> iterator() {
        lock.lock();
        Iterator<T> iterator = list.iterator();
        lock.unlock();
        return iterator;
    }

    @Override
    public Object[] toArray() {
        lock.lock();
        Object[] objects = list.toArray();
        lock.unlock();
        return objects;
    }

    @Override
    public boolean add(T o) {
        lock.lock();
        boolean isAdd = list.add(o);
        lock.unlock();
        return isAdd;
    }

    @Override
    public boolean remove(Object o) {
        lock.lock();
        boolean isRemove = list.remove(o);
        lock.unlock();
        return isRemove;
    }

    @Override
    public boolean addAll(Collection c) {
        lock.lock();
        boolean isAddAll = list.addAll(c);
        lock.unlock();
        return isAddAll;
    }

    @Override
    public boolean addAll(int index, Collection c) {
        lock.lock();
        boolean isAddAll = list.addAll(index, c);
        lock.unlock();
        return isAddAll;
    }

    @Override
    public void clear() {
        lock.lock();
        list.clear();
        lock.unlock();
    }

    @Override
    public T get(int index) {
        lock.lock();
        T o = list.get(index);
        lock.unlock();
        return o;
    }

    @Override
    public T set(int index, T element) {
        lock.lock();
        T o = list.set(index, element);
        lock.unlock();
        return o;
    }

    @Override
    public void add(int index, T element) {
        lock.lock();
        list.add(index, element);
        lock.unlock();
    }

    @Override
    public T remove(int index) {
        lock.lock();
        T o = list.remove(index);
        lock.unlock();
        return o;
    }

    @Override
    public int indexOf(Object o) {
        lock.lock();
        int index = list.indexOf(o);
        lock.unlock();
        return index;
    }

    @Override
    public int lastIndexOf(Object o) {
        lock.lock();
        int index = list.lastIndexOf(o);
        lock.unlock();
        return index;
    }

    @Override
    public ListIterator<T> listIterator() {
        return list.listIterator();
    }

    @Override
    public ListIterator<T> listIterator(int index) {
        return list.listIterator(index);
    }

    @Override
    public List<T> subList(int fromIndex, int toIndex) {
        lock.lock();
        List<T> subList = list.subList(fromIndex, toIndex);
        lock.unlock();
        return subList;
    }

    @Override
    public boolean retainAll(Collection c) {
        lock.lock();
        boolean isRetrain = list.retainAll(c);
        lock.unlock();
        return isRetrain;
    }

    @Override
    public boolean removeAll(Collection c) {
        lock.lock();
        boolean isRemoveAll = list.removeAll(c);
        lock.unlock();
        return isRemoveAll;
    }

    @Override
    public boolean containsAll(Collection c) {
        lock.lock();
        boolean isContainsAll = list.containsAll(c);
        lock.unlock();
        return isContainsAll;
    }

    @Override
    public Object[] toArray(Object[] a) {
        lock.lock();
        Object[] array = list.toArray(a);
        lock.unlock();
        return array;
    }
}
