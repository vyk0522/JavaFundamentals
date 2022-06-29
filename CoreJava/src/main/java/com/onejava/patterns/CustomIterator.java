package com.onejava.patterns;

import java.util.Arrays;
import java.util.stream.IntStream;
/*
The need to implement the Iterator interface arises while designing custom data structures.
 */
public class CustomIterator {
    public static void main(String[] args) {
        String[] names = {"aa", "bb", "cc", "dd"};
        Iterator<String> iterator = new CustomDataStructure<>(names).iterator();

        System.out.println("Iterating elements start");
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
        System.out.println("Iterating elements End");

        System.out.println("Removed Element: " + iterator.remove());
    }
}

interface Iterator<X> {
    boolean hasNext();
    X next();
    X remove();
}

class CustomDataStructure<X> {
    private final X[] data;

    public CustomDataStructure(X[] data) {
        this.data = data;
    }

    public Iterator<X> iterator() {
        return new IteratorImpl();

    }

    // Implemented as an inner class of the Data Structure class since it won’t be used elsewhere.
    private class IteratorImpl implements Iterator<X> {
        private int currentIndex = 0;

        @Override
        public boolean hasNext() {
            return currentIndex < data.length;
        }

        @Override
        public X next() {
            X next = data[currentIndex];
            currentIndex++;
            return next;  // return data[currentIndex++];
        }

        @Override
        public X remove() {
            X[] newArray = (X[]) IntStream.range(0, data.length)
                    .filter(i -> i != currentIndex - 1)
                    .mapToObj(i -> data[i])
                    .toArray();
            System.out.println("newArray: " + Arrays.toString(newArray));
            return data[currentIndex - 1];
        }
    }


}
