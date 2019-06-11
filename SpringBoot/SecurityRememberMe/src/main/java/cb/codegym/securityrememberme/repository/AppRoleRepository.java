package cb.codegym.securityrememberme.repository;

import cb.codegym.securityrememberme.entity.AppRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AppRoleRepository extends JpaRepository<AppRole,Long> {

    AppRole findByRoleName(String name);
}
