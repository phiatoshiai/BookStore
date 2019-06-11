package vn.phi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vn.phi.entity.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category,Integer> {

}
