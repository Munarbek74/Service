package com.company.service;

import com.company.model.Book;
import com.company.model.LibraryMember;

import java.util.List;

public interface LibraryService {
    List<LibraryMember> getLibraryMembers();
    void addLibraryMember(LibraryMember member);

    LibraryMember findLibraryMemberById(Long id);
    void deleteLibraryMemberByID(Long id);

    void addBookToLibrary(Book book);

    List<Book> getLibraryBooks();

    Book findLibraryBookById(Long id);

    void deleteLibraryBookByID(Long id);

    void addBookToMember(Long memberId, long bookId);

    void removeBookFromReading(Long memberId, long bookId);
}