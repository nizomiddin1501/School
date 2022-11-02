package uz.developers.school.config;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    // DIRECTOR, TEACHER and STUDENT

    private final PasswordEncoder passwordEncoder;
    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http

                .csrf().disable()
                .authorizeRequests()
                .antMatchers("/","index","/css/*","/js/*").permitAll()
                .antMatchers(HttpMethod.GET,"/api/**").hasAnyRole(UserRole.STUDENT.name(),UserRole.TEACHER.name(),UserRole.DIRECTOR.name())
                .antMatchers(HttpMethod.POST,"/api/**").hasAnyRole(UserRole.TEACHER.name(),UserRole.DIRECTOR.name())
                .antMatchers(HttpMethod.PUT,"/api/**").hasRole(UserRole.DIRECTOR.name())
                .antMatchers(HttpMethod.DELETE,"/api/**").hasRole(UserRole.DIRECTOR.name())
                .anyRequest()
                .authenticated()
                .and()
                .httpBasic();
    }

    @Override
    @Bean
    protected UserDetailsService userDetailsService() {
        UserDetails student = User.builder()
                .username("student")
                .password(passwordEncoder.encode("student"))
                .roles(UserRole.STUDENT.name()) //ROLE_STUDENT
                .build();

        UserDetails teacher = User.builder()
                .username("teacher")
                .password(passwordEncoder.encode("teacher"))
                .roles(UserRole.TEACHER.name()) //ROLE_TEACHER
                .build();

        UserDetails director = User.builder()
                .username("director")
                .password(passwordEncoder.encode("director"))
                .roles(UserRole.DIRECTOR.name()) //ROLE_DIRECTOR
                .build();


        return new InMemoryUserDetailsManager(
                student,
                teacher,
                director
        );
    }
}
