package my.example.blog.service;


import my.example.blog.domain.Account;
import my.example.blog.repository.AccountRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountService {
    AccountRepository accountRepository;

    public AccountService(AccountRepository accountRepository) {

        this.accountRepository = accountRepository;
    }


    public List<Account> getAccountAll() {
        return accountRepository.findAll();
    }
}