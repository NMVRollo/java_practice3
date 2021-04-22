package com.company;

import java.util.*;
import java.util.concurrent.Semaphore;
import java.util.stream.Collectors;

public class SyncHashMap<K, V> implements Map<K, V> {

    private final Map<K, V> map = new HashMap<>();
    private final Semaphore semaphore = new Semaphore(1);

    @Override
    public int size() {
        int size = 0;
        try {
            semaphore.acquire();
            size = map.size();
            semaphore.release();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return size;
    }

    @Override
    public boolean isEmpty() {
        boolean isEmpty = false;
        try {
            semaphore.acquire();
            isEmpty = map.isEmpty();
            semaphore.release();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return isEmpty;
    }

    @Override
    public boolean containsKey(Object key) {
        boolean contains = false;
        try {
            semaphore.acquire();
            contains = map.containsKey(key);
            semaphore.release();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return contains;
    }

    @Override
    public boolean containsValue(Object value) {
        boolean contains = false;
        try {
            semaphore.acquire();
            contains = map.containsValue(value);
            semaphore.release();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return contains;
    }

    @Override
    public V get(Object key) {
        V o = null;
        try {
            semaphore.acquire();
            o = map.get(key);
            semaphore.release();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return o;
    }

    @Override
    public V put(K key, V value) {
        V o = null;
        try {
            semaphore.acquire();
            o = map.put(key, value);
            semaphore.release();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return o;
    }

    @Override
    public V remove(Object key) {
        V o = null;
        try {
            semaphore.acquire();
            o = map.remove(key);
            semaphore.release();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return o;
    }

    @Override
    public void putAll(Map<? extends K, ? extends V> m) {
        try {
            semaphore.acquire();
            map.putAll(m);
            semaphore.release();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void clear() {
        try {
            semaphore.acquire();
            map.clear();
            semaphore.release();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Set<K> keySet() {
        Set<K> set = new HashSet<>();
        try {
            semaphore.acquire();
            set = map.keySet();
            semaphore.release();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return set;
    }

    @Override
    public Collection<V> values() {
        Collection<V> collection = null;
        try {
            semaphore.acquire();
            collection = map.values();
            semaphore.release();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return collection;
    }

    @Override
    public Set<Entry<K, V>> entrySet() {
        Set<Entry<K, V>> set = new HashSet<>();
        try {
            semaphore.acquire();
            set = map.entrySet();
            semaphore.release();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return set;
    }
}
