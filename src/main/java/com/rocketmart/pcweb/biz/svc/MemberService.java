package com.rocketmart.pcweb.biz.svc;

import com.rocketmart.pcweb.biz.dao.MemberDto;
import com.rocketmart.pcweb.biz.dao.MemberRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class MemberService implements UserDetailsService {

    private MemberRepository memberRepository;

    @Transactional
    public int joinUser(MemberDto memberDto) {
        // 비밀번호 암호화
//        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
//        memberDto.setPassword(passwordEncoder.encode(memberDto.getPassword()));

        //return memberRepository.save(memberDto.toEntity()).getId();
        return 0;
    }

    @Override
    public UserDetails loadUserByUsername(String userEmail) throws UsernameNotFoundException {
       /* Optional<MemberEntity> userEntityWrapper = memberRepository.findByEmail(userEmail);
        MemberEntity userEntity = userEntityWrapper.get();

        List<GrantedAuthority> authorities = new ArrayList<>();

        if (("admin@example.com").equals(userEmail)) {
            authorities.add(new SimpleGrantedAuthority(Role.ADMIN.getValue()));
        } else {
            authorities.add(new SimpleGrantedAuthority(Role.MEMBER.getValue()));
        }

        return new User(userEntity.getEmail(), userEntity.getPassword(), authorities);*/
       return null;
    }
}
