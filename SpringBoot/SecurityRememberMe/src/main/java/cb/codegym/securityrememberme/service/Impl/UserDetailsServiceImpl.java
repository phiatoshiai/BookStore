package cb.codegym.securityrememberme.service.Impl;

import cb.codegym.securityrememberme.entity.AppRole;
import cb.codegym.securityrememberme.entity.AppUser;
import cb.codegym.securityrememberme.repository.AppUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Repository;

import java.util.HashSet;
import java.util.Set;

@Repository
public class UserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    AppUserRepository appUserRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        AppUser user = appUserRepository.findByUserName(username);

        if (user == null) {
            throw new UsernameNotFoundException("Not find the User");
        }

        Set<GrantedAuthority> grantedAuthorities = new HashSet<>();
        Set<AppRole> roles = user.getRoleSet();
        for (AppRole role : roles) {
            grantedAuthorities.add(new SimpleGrantedAuthority(role.getRoleName()));
        }

        return new org.springframework.security.core.userdetails.User(user.getUserName(), user.getEncrytedPassword(), grantedAuthorities);

    }
}
