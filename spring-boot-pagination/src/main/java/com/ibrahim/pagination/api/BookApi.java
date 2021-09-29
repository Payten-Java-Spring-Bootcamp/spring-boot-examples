package com.ibrahim.pagination.api;

import com.ibrahim.pagination.model.Book;
import com.ibrahim.pagination.repo.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequiredArgsConstructor
@RequestMapping("/books")
public class BookApi {

    private final BookRepository bookRepository; //final yaptik ve artik bunun constructor da nesnesi olusturulacak

    @GetMapping
    public Page<Book> pagination(@RequestParam Integer pageSize, @RequestParam Integer currentPage){
        //kacinci sayfayi kac kayit seklinde getireyim
        Pageable pageable = PageRequest.of(currentPage, pageSize); //Pageable
        return bookRepository.findAll(pageable);
    }
    //localhost:8080/book?pageSize=1&currentPage=2 ile buna ulasabiliriz

    @GetMapping("/p")
    public Page<Book> pagination(Pageable pageable){
        return bookRepository.findAll(pageable);
    }
    //bu ise farkli bir yontemdir,parametreleri direkt bu sekilde url den verebilirsin
    //localhost:8080/p?size=1&page=2 diye de buna ulasabiliriz
    //sort parametresi de verilebilir


    @GetMapping("/s")
    public Slice<Book> slice(Pageable pageable){
        return bookRepository.findAll(pageable);
    }
    //bu ise daha performansli bir yontemdir, maaliyeti azaltir. Kac kayit var ilgilenmez. Tum elemanlari okumaz

}
