package com.solvd.laba;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.*;

@XmlRootElement(name="library")
public class Library {
    private List<Staff> staff = new ArrayList<>();
    private List<Book> books;
    HashMap<Book, StudentZ> bookHolder = new HashMap<>();

    public Library() {}
//    public Library(List<Staff> staff) {
//        this.staff = staff;
//    }

    public Library(List<Book> books) {
        this.books = books;
    }

    @XmlElementWrapper(name = "books")
    @XmlElement(name = "book")
    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

    public List<Staff> getStaff() {
        return staff;
    }

    public void setStaff(List<Staff> staff) {
        this.staff = staff;
    }

    public void lendBook(Book book, StudentZ student) {
        if (Book.getBooks().contains(book) && !(book.isBorrowed())) {
            bookHolder.put(book, student);
            book.setBorrowed(true);
            book.setDeliveryDate(new Date());

            // Sumar 7 días a la fecha actual para la fecha de devolución
            Calendar cal = Calendar.getInstance();
            cal.setTime(book.getDeliveryDate());
            cal.add(Calendar.DAY_OF_YEAR, 7);

            book.setReturnDate(cal.getTime());
            System.out.println("The book " + book.getName() + " has been lent to: " + bookHolder.get(book));
        } else {
            System.out.println("The book " + book.getName() + " has been lent to: "
                    + bookHolder.get(book) + ", is not available.");
        }
    }
    public void checkReturnDate(Book book) {
        Date currentDate = new Date();
        if (currentDate.after(book.getReturnDate())) {
            System.out.println("The return date has arrived. Please return the book.");

        } else {
            long daysLeft = (book.getReturnDate().getTime() - currentDate.getTime()) / (1000 * 60 * 60 * 24);
            System.out.println("There are " + daysLeft + " days left until the return date.");
        }

    }
}


