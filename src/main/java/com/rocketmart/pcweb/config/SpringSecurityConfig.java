package com.rocketmart.pcweb.config;

import com.rocketmart.pcweb.biz.svc.LoginSvc;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {

    private LoginSvc loginSvc;

    public SpringSecurityConfig(LoginSvc loginSvc) {
        this.loginSvc = loginSvc;
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        // static 디렉터리의 하위 파일 목록은 인증 무시 ( = 항상통과 )
        web.ignoring().antMatchers("/css/**", "/js/**", "/img/**", "/lib/**");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception{
        http.csrf().disable();
        http.authorizeRequests()
            // 페이지 권한 설정
            //.antMatchers("/admin/**").hasRole("ADMIN")
            //.antMatchers("/seller/**").hasRole("SELLER")
            //.antMatchers("/buyer/**").hasRole("BUYER")
            .antMatchers("/**").permitAll()
            .and() // 로그인 설정
                .formLogin()
                .loginPage("/user/signin")
                .defaultSuccessUrl("/user/signin/result")
                .permitAll()
            .and() // 로그아웃 설정
                .logout()
                .logoutRequestMatcher(new AntPathRequestMatcher("/user/signout/result"))
                .logoutSuccessUrl("/")
                .invalidateHttpSession(true)
            .and()
            // 403 예외처리 핸들링
            .exceptionHandling().accessDeniedPage("/user/denied");


    }

    @Override
    public void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(loginSvc).passwordEncoder(passwordEncoder());

        /*auth.inMemoryAuthentication()
                .withUser("admin").password("{noop}1").roles("ADMIN","SELLER","BUYER")
            .and()
                .withUser("seller").password("{noop}1").roles("SELLER")
            .and()
                .withUser("buyer").password("{noop}1").roles("BUYER");*/
    }
}
