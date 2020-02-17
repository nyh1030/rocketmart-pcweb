package com.rocketmart.pcweb.biz.svc;

import com.rocketmart.pcweb.biz.dao.MemberDto;
import com.rocketmart.pcweb.biz.dao.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
//@EnableAspectJAutoProxy(proxyTargetClass = true)
public class CustumUserDetailService implements UserDetailsService {

    @Autowired
    private MemberRepository memberRepository;


    @Override
    public UserDetails loadUserByUsername(String userEmail) throws UsernameNotFoundException {

        List<GrantedAuthority> authorities = new ArrayList<>();

        if (("admin@example.com").equals(userEmail)) {
            authorities.add(new SimpleGrantedAuthority("SELLER"));
        } else {
            authorities.add(new SimpleGrantedAuthority("SELLER"));
        }

       // return new User(userEntity.getEmail(), userEntity.getPassword(), authorities);*/
       return  new User("user1", "1111", authorities);
    }
}
