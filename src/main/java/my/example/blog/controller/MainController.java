package my.example.blog.controller;
import my.example.blog.domain.Account;
import my.example.blog.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
public class MainController {
    @Autowired
    AccountService accountService;

    @GetMapping("/main")
    public String main(Model model){
        List<Account> list = accountService.getAccountAll();
        model.addAttribute("list", list);
        return "index";
    }

}
