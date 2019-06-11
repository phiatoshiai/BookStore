package vn.phi.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import vn.phi.entity.Book;
import vn.phi.repository.BookRepository;
import vn.phi.service.BookService;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookRepository bookRepository;

    @Override
    public List<Book> getAllBook() {
        return bookRepository.findAll();
    }

    @Override
    public Book getBookById(int id) {
        return bookRepository.findBookById(id);
    }

    @Override
    public Page<Book> getBookByNameContaining(String name, Pageable pageable) {
        return bookRepository.findBookByNameContaining(name,pageable);
    }

    @Override
    public Page<Book> getAllBook(Pageable pageable) {
        return bookRepository.findAll(pageable);
    }

    @Override
    public void saveBook(Book book) {
        bookRepository.save(book);

    }

    @Override
    public void deleteBook(int id) {
        bookRepository.deleteById(id);
    }
}
