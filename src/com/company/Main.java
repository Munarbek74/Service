package com.company;

import com.company.dao.Dao;
import com.company.model.Book;
import com.company.model.Library;
import com.company.model.LibraryMember;
import com.company.service.impl.LibraryServiceImpl;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    static Scanner scannerN = new Scanner(System.in);
    static Scanner scannerS = new Scanner(System.in);
    public static void main(String[] args) {



        LibraryMember libraryMember = new LibraryMember();
        LibraryMember libraryMember1 = new LibraryMember();
        Book book = new Book();
        Book book1 = new Book();

        List<Book> books = new ArrayList<>();
        books.add(0,book);

        List<Book> books1 = new ArrayList<>();
        books1.add(0,book1);
        libraryMember.setMemberId(1L);
        libraryMember.setName("First name");
        libraryMember.setCurrentlyReading(book);
        libraryMember.setFinishedBooks(books1);
        System.out.println(libraryMember);

       book.setBookId(1L);
       book.setTitle("Manas");
       book.setCurrentHolder(libraryMember);



       book.setBookId(2L);
       book.setTitle("Roman");
       book.setCurrentHolder(libraryMember1);
//        System.out.println(book);





//        System.out.println(books);



//
//        libraryMember1.setMemberId(2L);
//        libraryMember1.setName("Second name");
//        libraryMember1.setCurrentlyReading(book1);
//        libraryMember1.setFinishedBooks(books1);
//        System.out.println(libraryMember1);


//        Dao dao = new Dao(new Library());
//        LibraryServiceImpl libraryService = new LibraryServiceImpl(dao);
//        libraryService.addBookToLibrary(book);
//        libraryService.addLibraryMember(libraryMember);
//        libraryService.addBookToMember();
//        System.out.println(libraryService);
//        while(true){
//            buttons();
//
//        }
    }

    public static void  buttons(){
        System.out.println("<><><><><><><><><><><><><><><><><><><><><><><><><><><><>");
        System.out.println("Нажмите 1, чтобы добавить нового участника в библиотеку.");
        System.out.println("Нажмите 2, чтобы увидеть всех участников библиотеки.");
        System.out.println("Нажмите 3, чтобы найти участника по ID и увидеть данные участника, читаемая книга и прочитанные.");
        System.out.println("Нажмите 4, чтобы удалить участника по ID.");
        System.out.println("<><><><><><><><><><><><><><><><><><><><><><><><><><><><>");
        System.out.println("Нажмите 5, чтобы добавить книгу в библиотеку.");
        System.out.println("Нажмите 6, чтобы увидеть все книги в библиотеке.");
        System.out.println("Нажмите 7, чтобы найти книгу по ID.");
        System.out.println("Нажмите 8, чтобы удалить книгу по ID.");
        System.out.println("<><><><><><><><><><><><><><><><><><><><><><><><><><><><>");
        System.out.println("Нажмите 9, чтобы ввести memberId участника и bookId книги, добавить в читаемые");
        System.out.println("Нажмите 10, чтобы ввести memberId участника и bookId книги, добавить в прочитанные");
        System.out.println("Нажмите x, чтобы завершить программу.");
    }
}