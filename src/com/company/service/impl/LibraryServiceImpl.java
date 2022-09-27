package com.company.service.impl;

import com.company.dao.Dao;
import com.company.model.Book;
import com.company.model.Library;
import com.company.model.LibraryMember;
import com.company.service.LibraryService;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class LibraryServiceImpl  implements LibraryService {
    private static final Scanner scannerN = new Scanner(System.in);
    private Dao dao;

    public LibraryServiceImpl(Dao dao) {
        this.dao = dao;
    }

    @Override
    public List<LibraryMember> getLibraryMembers() {
        List<LibraryMember> libraryMembers = null;
        return libraryMembers;
    }

    @Override
    public void addLibraryMember(LibraryMember member) {
        List<LibraryMember> libraryMembers = null;
        libraryMembers.add(member);
    }

    @Override
    public LibraryMember findLibraryMemberById(Long id) {
        List<LibraryMember> libraryMembers = null;
        System.out.println(libraryMembers.stream().filter(x -> x.getMemberId().equals(id)).collect(Collectors.toList()));
        return null;
    }

    @Override
    public void deleteLibraryMemberByID(Long id) {
        List<LibraryMember> libraryMembers = null;
        libraryMembers.remove(id);
    }

    @Override
    public void addBookToLibrary(Book book) {
        List<Book> finishedBooks = new ArrayList<>();
        finishedBooks.add(book);
    }

    @Override
    public List<Book> getLibraryBooks() {
        List<Book> finishedBooks = new ArrayList<>();
        return finishedBooks;
    }

    @Override
    public void deleteLibraryBookByID(Long id) {
        List<Book> finishedBooks = new ArrayList<>();
        finishedBooks.remove(id);
    }

    @Override
    public Book findLibraryBookById(Long id) {
        List<Book> finishedBooks = new ArrayList<>();
        finishedBooks.stream().filter(x -> x.getBookId().equals(id)).collect(Collectors.toList());
        return findLibraryBookById(id);
    }

    @Override
    public void addBookToMember() {
        List<LibraryMember> libraryMembers = null;
        libraryMembers.add(new LibraryMember());
    }

    @Override
    public void removeBookFromReading(){
        List<Book> finishedBooks = new ArrayList<>();
        finishedBooks.stream().filter(x->x.getCurrentHolder() != null).collect(Collectors.toList());

    }
}
