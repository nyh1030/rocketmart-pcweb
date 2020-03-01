package com.rocketmart.pcweb.biz.svc;

import com.rocketmart.pcweb.biz.dao.repository.MemberRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

@Slf4j
@Service
public class LoginSvc implements UserDetailsService {

	@Autowired
	private MemberRepository memberRepository;

	@Override

	public UserDetails loadUserByUsername(String memId) throws UsernameNotFoundException {
			Map<String, Object> memberInfo = memberRepository.findOneForMemInfo(memId);

			List<GrantedAuthority> authorities = new ArrayList<>();

			if (String.valueOf(memberInfo.get("ROLE")).contains("ADMIN")) {
				authorities.add(new SimpleGrantedAuthority("ADMIN"));
			}
			if (String.valueOf(memberInfo.get("ROLE")).contains("SELLER")) {
				authorities.add(new SimpleGrantedAuthority("SELLER"));
			}
			if (String.valueOf(memberInfo.get("ROLE")).contains("BUYER")) {
				authorities.add(new SimpleGrantedAuthority("BUYER"));
			}

		Iterator<? extends GrantedAuthority> iter = authorities.iterator();
		while (iter.hasNext()) { GrantedAuthority auth = iter.next(); System.out.println("hasRole: " + auth.getAuthority()); }


		return new User(String.valueOf(memberInfo.get("MEM_ID")), String.valueOf(memberInfo.get("MEM_PW")), authorities);
	}
}
