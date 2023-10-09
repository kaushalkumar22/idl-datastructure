package com.behavioral;

import java.util.ArrayList;
import java.util.List;

// Client
public class IteratorPatternClient {
    public static void main(String[] args) {
        MyList<String> myList = new MyList<>();
        myList.add("Item 1");
        myList.add("Item 2");
        myList.add("Item 3");

        MyIterator<String> iterator = myList.createIterator();

        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}
// Iterator interface
interface MyIterator<T> {
    boolean hasNext();
    T next();
}

// Concrete Iterator
class ListIterator<T> implements MyIterator<T> {
    private List<T> list;
    private int position;

    public ListIterator(List<T> list) {
        this.list = list;
        this.position = 0;
    }

    @Override
    public boolean hasNext() {
        return position < list.size();
    }

    @Override
    public T next() {
        if (hasNext()) {
            return list.get(position++);
        }
        throw new IllegalStateException("No more elements");
    }
}

// Aggregate interface
interface MyAggregate<T> {
    MyIterator<T> createIterator();
}

// Concrete Aggregate
class MyList<T> implements MyAggregate<T> {
    private List<T> list;

    public MyList() {
        this.list = new ArrayList<>();
    }

    public void add(T item) {
        list.add(item);
    }

    @Override
    public MyIterator<T> createIterator() {
        return new ListIterator<>(list);
    }
}
