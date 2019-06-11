package vn.codegym.security.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vn.codegym.security.entity.Role;

import java.util.Set;

@Repository
public interface RoleRepository extends JpaRepository<Role,Integer> {

    Role findByName(String name);
}

