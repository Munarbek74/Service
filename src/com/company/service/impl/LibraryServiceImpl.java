package com.company.service.impl;

import com.company.dao.Dao;
import com.company.model.Book;
import com.company.model.LibraryMember;
import com.company.service.LibraryService;

import java.util.List;
import java.util.Scanner;


public class LibraryServiceImpl implements LibraryService {
    private static final Scanner scannerN = new Scanner(System.in);
    private Dao dao;

    public LibraryServiceImpl(Dao dao) {
        this.dao = dao;
    }

    @Override
    public List<LibraryMember> getLibraryMembers() {
        return dao.getLibrary().getLibraryMembers();
    }

    @Override
    public void addLibraryMember(LibraryMember member) {
        dao.getLibrary().getLibraryMembers().add(member);
    }

    @Override
    public LibraryMember findLibraryMemberById(Long id) {
        return dao.getLibrary().getLibraryMembers().stream().filter(x -> x.getMemberId() == id).toList().get(0);
    }

    @Override
    public void deleteLibraryMemberByID(Long id) {
        LibraryMember m = dao.getLibrary().getLibraryMembers().stream().filter(x -> x.getMemberId() == id).toList().get(0);
        dao.getLibrary().getLibraryMembers().remove(m);
    }

    @Override
    public void addBookToLibrary(Book book) {
        dao.getLibrary().getBooks().add(book);
    }

    @Override
    public List<Book> getLibraryBooks() {
        return dao.getLibrary().getBooks();
    }

    @Override
    public void deleteLibraryBookByID(Long id) {
        Book b = dao.getLibrary().getBooks().stream().filter(x -> x.getBookId() == id).toList().get(0);
        dao.getLibrary().getBooks().remove(b);
    }

    @Override
    public Book findLibraryBookById(Long id) {
        return dao.getLibrary().getBooks().stream().filter(x -> x.getBookId() == id).toList().get(0);
    }

    @Override
    public void addBookToMember(Long memberId, long bookId) {
        Book b = findLibraryBookById(bookId);
        LibraryMember m = findLibraryMemberById(memberId);
        if (dao.getLibrary().getBooks().stream().filter(x -> x.getBookId().equals(bookId)).count() < 1)
            dao.getLibrary().getBooks().stream().filter(x -> x.getBookId() == bookId).toList().get(0).setCurrentHolder(m);

        if (dao.getLibrary().getLibraryMembers().stream().filter(x -> x.getMemberId().equals(memberId)).count() < 1)
            dao.getLibrary().getLibraryMembers().stream().filter(x -> x.getMemberId() == memberId).toList().get(0).setCurrentlyReading(b);

    }

    @Override
    public void removeBookFromReading(Long memberId, long bookId){
        Book b = findLibraryBookById(bookId);
        dao.getLibrary().getLibraryMembers().stream().filter(x -> x.getMemberId() == memberId).toList().get(0).setCurrentlyReading(null);
        dao.getLibrary().getBooks().stream().filter(x -> x.getBookId() == bookId).toList().get(0).setCurrentHolder(null);
        dao.getLibrary().getLibraryMembers().stream().filter(x -> x.getMemberId() == memberId).toList().get(0).setFinishedBooks(b);

    }
}