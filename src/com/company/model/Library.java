package com.company.model;

import java.util.ArrayList;
import java.util.List;

public class Library {
    private List<Book> books;
    private List<LibraryMember> libraryMembers;



    public Library() {
        this.books = new ArrayList<>();
        this.libraryMembers = new ArrayList<>();
    }

    public List<Book> getBooks() {
        return books;
    }

    public List<LibraryMember> getLibraryMembers() {
        return libraryMembers;
    }

    @Override
    public String toString() {
        return "Library{" +
                "books=" + books +
                ", libraryMembers=" + libraryMembers +
                '}';
    }
}
