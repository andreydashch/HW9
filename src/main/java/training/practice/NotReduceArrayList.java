package training.practice;

import java.util.ArrayList;
import java.util.Collection;
import java.util.function.Predicate;
import java.util.function.UnaryOperator;

public class NotReduceArrayList<T> extends ArrayList<T> {
    @Override
    public T remove(int index) {
        return null;
    }

    @Override
    public boolean remove(Object o) {
        return false;
    }

    @Override
    protected void removeRange(int fromIndex, int toIndex) {
        // Nothing
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean removeIf(Predicate<? super T> filter) {
        return false;
    }

    @Override
    public void replaceAll(UnaryOperator<T> operator) {
        // Nothing
    }
}
