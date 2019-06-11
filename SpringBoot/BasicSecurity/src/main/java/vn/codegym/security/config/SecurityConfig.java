package vn.codegym.security.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import vn.codegym.security.service.Impl.UserDetailsServiceImpl;


@Configuration
@EnableWebSecurity
public class SecurityService extends WebSecurityConfigurerAdapter {

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Autowired
    private UserDetailsServiceImpl userDetailsService;

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
    auth.inMemoryAuthentication().withUser("phiadmin").password(passwordEncoder().encode("12345")).roles("ADMIN");
    auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
http.authorizeRequests()
        .antMatchers("/register").permitAll()
        .antMatchers("/").hasRole("MEMBER")
        .antMatchers("/**").hasRole("ADMIN")
        .and()
            .formLogin()
            .loginPage("/login")
            .usernameParameter("email")
            .passwordParameter("password")
            .successForwardUrl("/")
            .failureForwardUrl("/login?error")
            .and()
                .exceptionHandling()
                .accessDeniedPage("/403");
    }
}
