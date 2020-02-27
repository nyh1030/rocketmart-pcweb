package com.rocketmart.pcweb.biz.svc;

import com.rocketmart.jooq.tables.records.TbMemMstRecord;
import com.rocketmart.pcweb.biz.dao.repository.MemberRepository;
import lombok.AllArgsConstructor;
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
import java.util.List;
import java.util.Map;

@Slf4j
@AllArgsConstructor
@Service
public class LoginSvc implements UserDetailsService {

	@Autowired
	private MemberRepository memberRepository;

	@Override

	public UserDetails loadUserByUsername(String memId) throws UsernameNotFoundException {
			Map<String, Object> memberInfo = memberRepository.findOneForMemInfo(memId);

			List<GrantedAuthority> authorities = new ArrayList<>();

			if ("ADMIN".equals(memberInfo.get("role"))) {
				authorities.add(new SimpleGrantedAuthority("ADMIN"));
			}
			if ("SELLER".equals(memberInfo.get("role"))) {
				authorities.add(new SimpleGrantedAuthority("SELLER"));
			}
			if ("BUYER".equals(memberInfo.get("role"))) {
				authorities.add(new SimpleGrantedAuthority("BUYER"));
		}

		return new User(String.valueOf(memberInfo.get("memId")), String.valueOf(memberInfo.get("memPw")), authorities);
	}
}
