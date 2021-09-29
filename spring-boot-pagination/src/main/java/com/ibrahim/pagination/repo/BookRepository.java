package com.ibrahim.pagination.repo;

import com.ibrahim.pagination.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> { //Book entity si ile calisicaz ve Long primary key id si
    //burada sorgular olusturuluyor, bu sayede sorgu yazmamiza gerek kalmiyor
}
