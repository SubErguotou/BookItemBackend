package com.erguotou.controller;

import com.erguotou.pojo.Book;
import com.erguotou.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class LibraryController {
    @Autowired
    BookService bookService;

    @GetMapping("/api/books")
    public List<Book> list() throws Exception{
        return bookService.list();
    }

    @PostMapping("/api/books")
    public Book addOrUpdate(@RequestBody Book book) throws Exception{
        bookService.addOrUpdate(book);
        return book;
    }

    @PostMapping("/api/delete")
    public void delete(@RequestBody Book book) throws Exception {
        bookService.deleteById(book.getId());
    }

    @GetMapping("/api/categories/{cid}/books")
    public List<Book> listByCategory(@PathVariable("cid") int cid) throws Exception{
        if (0!=cid){
            return bookService.listByCategory(cid);
        }else {
            return list();
        }
    }
//    根据标题或者作者查询
    @GetMapping(value = "/api/search")
    public List<Book> searchResult(@RequestParam("keywords")String keywords){
        if("".equals(keywords)){
            return bookService.list();
        }else {
            return bookService.SearchKey(keywords);
        }
    }
}
