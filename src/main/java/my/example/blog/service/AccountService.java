package my.example.blog.service;


import lombok.RequiredArgsConstructor;
import my.example.blog.domain.Account;
import my.example.blog.domain.Role;
import my.example.blog.repository.AccountRepository;
import my.example.blog.repository.RoleRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
@RequiredArgsConstructor
public class AccountService {
    private final AccountRepository accountRepository;
    private final RoleRepository roleRepository;

    public List<Account> getAccountAll(){
        return accountRepository.findAll();
    }

    @Transactional
    public Account join(Account account) {

        Role role = roleRepository.getRoleByName("USER");
        account.addRole(role);
        return accountRepository.save(account);
    }

    @Transactional
    public void deleteAccount(Long id) {
        accountRepository.deleteById(id);
    }
}