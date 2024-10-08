package com.solvd.laba;

import java.util.*;

public class Library {
    private List<Staff> staff = new ArrayList<>();
    private Book book;
    HashMap<Book, StudentZ> bookHolder = new HashMap<>();

    public Library(List<Staff> staff) {
        this.staff = staff;
    }

    public Library(Book book) {
        this.book = book;
    }

    public void lendBook(StudentZ student) {
        if (!(book.isBorrowed())) {
            bookHolder.put(book, student);
            book.setBorrowed(true);
            System.out.println("The book " + book.getName() + " has been lent to: " + bookHolder.get(book));
        } else {
            System.out.println("The book " + book.getName() + " has been lent to: " + bookHolder.get(book) + ", is not available.");
        }
    }
}
