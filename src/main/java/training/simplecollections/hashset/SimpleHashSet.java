package training.simplecollections.hashset;

import java.util.*;

public class SimpleHashSet<T> implements java.util.Set<T> {
    private static final Object PRESENT = new Object();
    private transient HashMap<T, Object> map;
    private int size = 0;

    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 1, 1, 1, 2, 3);
        SimpleHashSet<Integer> set = new SimpleHashSet<>();

        System.out.println(set.addAll(list));
        System.out.println(set.add(0));
        System.out.println(set.remove(0));

        list = Arrays.asList(2, 3);
        System.out.println(set.containsAll(list));
        System.out.println(set.removeAll(list));

        for(Number num : set) {
            System.out.println(num);
        }
    }

    public SimpleHashSet() {
        this.map = new HashMap<>();
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
    public boolean add(T t) {
        return map.put(t, PRESENT) == null;
    }

    @Override
    public boolean addAll(Collection<? extends T> c) {
        return c.stream()
                .map(x -> map.put(x, PRESENT) == null)
                .reduce(true, (left, right) -> left && right);
    }

    @Override
    public boolean remove(Object o) {
        return map.remove(o) == PRESENT;
    }

    @Override
    public boolean contains(Object o) {
        return map.containsKey(o);
    }

    @Override
    public Iterator<T> iterator() {
        return map.keySet().iterator();
    }

    @Override
    public Object[] toArray() {
        return map.keySet().toArray();
    }

    @Override
    public <T1> T1[] toArray(T1[] a) {
        return  (T1[]) map.keySet().toArray();
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        return c.stream()
                .map(x -> map.containsKey(x))
                .reduce(true, (left, right) -> left && right);
    }

    // I did not write it by myself
    @Override
    public boolean retainAll(Collection<?> c) {
        Objects.requireNonNull(c);
        boolean modified = false;
        Iterator<T> it = iterator();
        while (it.hasNext()) {
            if (!c.contains(it.next())) {
                it.remove();
                modified = true;
            }
        }
        return modified;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        return c.stream()
                .map(x -> map.remove(x) == PRESENT)
                .reduce(true,(left, right) -> left && right);
    }

    @Override
    public void clear() {
        map.clear();
    }
}
