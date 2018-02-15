package ru.itpark.security.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.rememberme.JdbcTokenRepositoryImpl;
import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository;

import javax.sql.DataSource;

@EnableWebSecurity
@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

  @Qualifier("dataSource")
  @Autowired
  private DataSource dataSource;


  @Override
  protected void configure(HttpSecurity http) throws Exception {
    http
        .authorizeRequests() // блок, отвечающий за урлы и их доступы
            .antMatchers("/registration/**").permitAll() // разрешили всем
            .antMatchers("/confirm/**").permitAll()
            .antMatchers("/css/**").permitAll()
            .antMatchers("/js/**").permitAll()
            .antMatchers("/images/**").permitAll()
            .antMatchers("/files/**").permitAll()
            .antMatchers("//**").permitAll()
            .antMatchers("/contact/**").permitAll()
            .antMatchers("/zoo/**").permitAll()
            .antMatchers("/events/**").permitAll()
            .antMatchers("/gallery/**").permitAll()
            .antMatchers("/password_recovery/**").permitAll()
            .antMatchers("/password_recovery_confirm/**").permitAll()
            .antMatchers("/password_confirm/**").permitAll()
            .antMatchers("/password_change/**").permitAll()
            .antMatchers("/success_password_change/**").permitAll()
            .antMatchers("/profile/**").hasAnyAuthority("USER", "ADMIN") // разрешили админу и пользователям
            .antMatchers("/user/**").hasAnyAuthority("ADMIN") // только админу
            .antMatchers("/tickets_redaction/**").hasAnyAuthority("ADMIN")
            .antMatchers("/tickets_new_ticket/**").hasAnyAuthority("ADMIN")

            .anyRequest().authenticated() // все остальные запросы требуют предварительной авторизации
            .and()
        .formLogin() // блок с формой входа
          .loginPage("/login")
          .usernameParameter("login")
          .passwordParameter("password")
          .defaultSuccessUrl("/profile")
          .failureUrl("/login?error=true")
            .permitAll()
            .and()
            .logout()
            .logoutUrl("/logout")
            .and()
            .rememberMe().rememberMeParameter("remember-me")
            .tokenRepository(persistentTokenRepository())
            .tokenValiditySeconds(128000)
        .and()
        .csrf().disable();
  }

  private PersistentTokenRepository persistentTokenRepository() {
    JdbcTokenRepositoryImpl tokenRepository = new JdbcTokenRepositoryImpl();
    tokenRepository.setDataSource(dataSource);
    return tokenRepository;
  }


  @Autowired
  private UserDetailsService userDetailsService;

  @Override
  protected void configure(AuthenticationManagerBuilder auth) throws Exception {
    auth.userDetailsService(userDetailsService).passwordEncoder(new BCryptPasswordEncoder());
  }
}