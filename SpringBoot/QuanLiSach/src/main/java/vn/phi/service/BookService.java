package vn.phi.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import vn.phi.entity.Book;

import java.util.List;

public interface BookService {

    List<Book> getAllBook();

    Book getBookById(int id);

    Page<Book> getBookByNameContaining(String name,Pageable pageable);

    Page<Book> getAllBook(Pageable pageable);

    void saveBook(Book book);

    void deleteBook(int id);

}
