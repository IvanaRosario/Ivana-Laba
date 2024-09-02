package com.solvd.laba;

public class Book {
    private String name;
    private String author;
    private String bookID;
    private boolean borrowed;

    public Book(String name, String author, String bookID) {
        this.name = name;
        this.author = author;
        this.bookID = bookID;
    }

    @Override
    public String toString() {
        return "Book:" +
                "name: " + name + '\'' +
                ", author='" + author + '\'' +
                ", bookID='" + bookID;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getBookID() {
        return bookID;
    }

    public void setBookID(String bookID) {
        this.bookID = bookID;
    }

    public boolean isBorrowed() {
        return borrowed;
    }

    public void setBorrowed(boolean borrowed) {
        this.borrowed = borrowed;
    }
}
