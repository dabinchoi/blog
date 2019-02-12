package my.example.blog.controller;

import my.example.blog.domain.Account;
import my.example.blog.dto.JoinForm;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;

@Controller
@RequestMapping("/users")
public class UserController {
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
    @PostMapping("/join")
    public String join(@Valid JoinForm joinForm, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            throw new IllegalArgumentException(bindingResult.toString());
        }
        if(!joinForm.getPassword1().equals(joinForm.getPassword2()))
            throw new IllegalArgumentException("암호,암호확인이 틀리다");

        Account account = new Account();
        account.setName(joinForm.getName());
        account.setNickName(joinForm.getNickname());
        account.setEmail(joinForm.getEmail());
        PasswordEncoder passwordEncoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
        account.setPasswd(passwordEncoder.encode(joinForm.getPassword1()));




        return "redirect:/users/welcome";
    }



}
