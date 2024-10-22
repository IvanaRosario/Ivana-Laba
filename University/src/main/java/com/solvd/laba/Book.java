package com.solvd.laba;

import javax.xml.bind.annotation.*;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.util.Date;
import java.util.List;


@XmlType(propOrder = {"name", "author", "bookID", "date"})
public class Book {
    private long bookID;
    private String name;
    private String author;
    private Date date;
    private boolean borrowed;
    private Date deliveryDate;
    private Date returnDate;
    private static List<Book> books;

    public Book() {}

    public Book(long bookID, String name, String author, Date date) {
        this.name = name;
        this.author = author;
        this.bookID = bookID;
        this.date = date;
    }


    public static List<Book> getBooks() {
        return books;
    }

    @Override
    public String toString() {
        return "Book:" +
                "name: " + name + '\'' +
                ", author='" + author + '\'' +
                ", bookID='" + bookID;
    }

    @XmlElement
    public String getName() {
        return name;
    }

    @XmlElement
    public String getAuthor() {
        return author;
    }

    @XmlAttribute(name="id")
    public long getBookID() {
        return bookID;
    }

    @XmlTransient
    public Date getDeliveryDate() {
        return deliveryDate;
    }

    @XmlTransient
    public Date getReturnDate() {
        return returnDate;
    }

    @XmlJavaTypeAdapter(DataAdapter.class)
    @XmlElement
    public Date getDate() {
        return this.date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    @XmlTransient
    public boolean isBorrowed() {
        return borrowed;
    }

    public void setBookID(long bookID) {
        this.bookID = bookID;
    }

    public void setBorrowed(boolean borrowed) {
        this.borrowed = borrowed;
    }

    public void setDeliveryDate(Date deliveryDate) {
        this.deliveryDate = deliveryDate;
    }

    public void setReturnDate(Date returnDate) {
        this.returnDate = returnDate;
    }

    public void setBooks() {
        books.add(this);
    }
}
