package IteratorsAndComparators.Lab;

import java.util.Comparator;

public class BookComparator implements Comparator<Book> {
    @Override
    public int compare(Book book1, Book book2) {
       return book1.compareTo(book2);
    }
}