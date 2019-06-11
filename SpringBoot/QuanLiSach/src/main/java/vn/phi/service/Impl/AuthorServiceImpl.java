package vn.phi.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.phi.entity.Author;
import vn.phi.entity.Book;
import vn.phi.repository.AuthorRepository;
import vn.phi.service.AuthorService;

import java.util.List;

@Service
public class AuthorServiceImpl implements AuthorService {
    @Autowired
    private AuthorRepository authorRepository;

    @Override
    public List<Author> getAllAuthor() {
        return authorRepository.findAll();
    }

    @Override
    public Author getAuthorById(int id) {
        return null;
    }

    @Override
    public Author getAuthorByName(String name) {
        return null;
    }

    @Override
    public void saveAuthor(Author author) {
        authorRepository.save(author);
    }

    @Override
    public void deleteAuthor(int id) {
        authorRepository.deleteById(id);
    }
}
