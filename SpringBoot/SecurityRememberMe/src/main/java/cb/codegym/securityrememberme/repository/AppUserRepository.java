package cb.codegym.securityrememberme.repository;

import cb.codegym.securityrememberme.entity.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface AppUserRepository extends JpaRepository<AppUser,Long> {

        AppUser findByUserName (String username);
}
