package my.example.blog.security;

import lombok.RequiredArgsConstructor;
import my.example.blog.domain.Account;
import my.example.blog.domain.Role;
import my.example.blog.repository.AccountRepository;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Component
@RequiredArgsConstructor // final 인 필드만 초기화하는 생성자가 자동으로 만들어진다. 생성자주입시 사용
public class BlogUserDetailsService implements UserDetailsService {
    private final AccountRepository accountRepository;

    @Override
    @Transactional(readOnly = false)
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Account account =
                accountRepository.getAccountByEmail(email);
        if(account == null)
            throw new UsernameNotFoundException(email + "에 해당하는 사용자 없어!");

        List<GrantedAuthority> authorities = new ArrayList<>();
        Set<Role> roles = account.getRoles();
        for(Role role : roles){
            authorities.add(new SimpleGrantedAuthority("ROLE_" + role.getName()));
        }
        // 리턴한 값은 세션에 저장된다.
        BlogSecurityUser blogSecurityUser = new BlogSecurityUser(email, account.getPasswd(), authorities);
        blogSecurityUser.setId(account.getId());
        blogSecurityUser.setName(account.getName());
        blogSecurityUser.setNickName(account.getNickName());
        return blogSecurityUser;
    }
}
