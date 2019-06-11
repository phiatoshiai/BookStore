package vn.phi.service;

import vn.phi.entity.Author;

import java.util.List;

public interface AuthorService {

    List<Author> getAllAuthor();

    Author getAuthorById(int id);

    Author getAuthorByName(String name);

    void saveAuthor(Author author);

    void deleteAuthor(int id);

}
