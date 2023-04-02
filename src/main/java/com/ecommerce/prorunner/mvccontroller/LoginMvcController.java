package com.ecommerce.prorunner.mvccontroller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.security.Principal;

@Controller
public class LoginMvcController {

    @GetMapping("/login")
    public String login(Principal principal){
        if(principal != null){
            return "redirect:/home";
        }
        return "login";
    }
    @GetMapping("/forgot-pw")
    public String forgotPwPage(){
        return "forgotPw" ;
    }
}
