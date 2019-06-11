package vn.phi.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vn.phi.entity.Book;


@Repository
public interface BookRepository extends JpaRepository<Book, Integer> {
    Book findBookById(int id);
    Page<Book> findBookByNameContaining(String name, Pageable pageable);
    Integer countByName(String name);
}
