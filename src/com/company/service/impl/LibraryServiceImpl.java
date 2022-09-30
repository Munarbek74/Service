package com.company.service.impl;

import com.company.dao.Dao;
import com.company.model.Book;
import com.company.model.LibraryMember;
import com.company.service.LibraryService;

import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;


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
    public void addBookToMember(Long memberId, long bookId) throws Exception {
        Book b = findLibraryBookById(bookId);

        if (b.getCurrentHolder() == null) {
            LibraryMember m = findLibraryMemberById(memberId);
             dao.getLibrary().getLibraryMembers().stream().filter(x -> x.getMemberId() == memberId).toList().get(0).setCurrentlyReading(b);
            dao.getLibrary().getBooks().stream().filter(x -> x.getBookId() == bookId).toList().get(0).setCurrentHolder(m);
        } else {
            throw new Exception(b.getCurrentHolder().getName() + " is reading this book");
        }
    }
//    @Override
//    public void addBookToMember(Long memberId, long bookId) {
//        Book b = findLibraryBookById(bookId);
//        LibraryMember m = findLibraryMemberById(memberId);
//        Stream<Object> a = dao.getLibrary().getBooks().stream().map(x -> x.getCurrentHolder().getMemberId());
//        Stream<Object> c = dao.getLibrary().getLibraryMembers().stream().map(x -> x.getCurrentlyReading().getBookId());
////        dao.getLibrary().getLibraryMembers().stream().filter(x -> x.getMemberId() == memberId).toList().get(0).setCurrentlyReading(b);
//        dao.getLibrary().getBooks().stream().filter(x -> x.getBookId() == bookId).toList().get(0).setCurrentHolder(m);
//        System.out.println(dao.getLibrary().getBooks().stream().map(x -> x.getCurrentHolder().getMemberId()).collect(Collectors.toList()));
//
//        dao.getLibrary().getBooks().stream().map(x -> {
//            if (x.getCurrentHolder().getMemberId() != memberId) {
//                dao.getLibrary().getLibraryMembers().stream().filter(y -> y.getMemberId() == memberId).toList().get(0).setCurrentlyReading(b);
//            }
//            return x;
//
//        }).collect(Collectors.toList());
//        System.out.println(dao);
//    }
//
//
//        if (c != null) {
//        if (dao.getLibrary().getLibraryMembers().get(0).getCurrentlyReading().getBookId() == bookId) {
//                System.out.println("Книга не свободна");
//            } else {
//            dao.getLibrary().getLibraryMembers().stream().filter(x -> x.getMemberId() == memberId).toList().get(0).setCurrentlyReading(b);
//            }
//        } else {
//            dao.getLibrary().getLibraryMembers().stream().filter(x -> x.getMemberId() == memberId).toList().get(0).setCurrentlyReading(b);
//        }
//        }
//    }
    @Override
    public void removeBookFromReading(Long memberId, long bookId){
        Book b = findLibraryBookById(bookId);
        dao.getLibrary().getLibraryMembers().stream().filter(x -> x.getMemberId() == memberId).toList().get(0).setCurrentlyReading(null);
        dao.getLibrary().getBooks().stream().filter(x -> x.getBookId() == bookId).toList().get(0).setCurrentHolder(null);
        dao.getLibrary().getLibraryMembers().stream().filter(x -> x.getMemberId() == memberId).toList().get(0).setFinishedBooks(b);

    }
}