package vn.phi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vn.phi.entity.Author;

@Repository
public interface AuthorRepository extends JpaRepository<Author,Integer> {
    Author findAuthorById(int id);
    Author findAuthorByName(String name);
    Integer countAllByName(String name);
}
