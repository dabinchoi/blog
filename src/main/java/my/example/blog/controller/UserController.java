package my.example.blog.controller;

import lombok.RequiredArgsConstructor;
import my.example.blog.domain.Account;
import my.example.blog.dto.JoinForm;
import my.example.blog.service.AccountService;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;


import javax.validation.Valid;

@Controller
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {
    private final AccountService accountService;
    @GetMapping("/login")
    public String login(
            @RequestParam(name = "fail",
                    required = false,
                    defaultValue = "false") String errorFlag){

        return "users/login"; // view name 을 리턴한다.
    }
    @GetMapping("/join")
    public String joinform(){
        return "users/joinform";
    }

    // Form데이터를 DTO로 파라미터를 받아들일 경우엔 @ModelAttribute JoinForm joinForm
    // DTO에 Validation관련 어노테이션을 사용했을 경우에는 @Valid를 사용한다.
    @PostMapping("/join")
    public String join(@Valid JoinForm joinForm, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            throw new IllegalArgumentException(bindingResult.toString());
        }
        if(!joinForm.getPassword1().equals(joinForm.getPassword2()))
            throw new IllegalArgumentException("암호와 암호확인이 틀려요.");

        Account account = new Account();
        account.setEmail(joinForm.getEmail());
        account.setName(joinForm.getName());
        account.setNickName(joinForm.getNickName());
        PasswordEncoder passwordEncoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
        account.setPasswd(passwordEncoder.encode(joinForm.getPassword1()));

        Account result = accountService.join(account);

        return "redirect:/users/welcome";
    }
    @GetMapping("/welcome")
    public String welcome(){
        return "users/welcome";

    }
    @GetMapping("/delete")
    public String delete(@RequestParam(name = "id")Long id){
        accountService.deleteAccount(id);
        return "users/welcome";
    }
}