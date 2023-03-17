package com.ecommerce.prorunner.mvccontroller;

import com.ecommerce.prorunner.service.ProRunnerUserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeMvcController {
    private ProRunnerUserService proRunnerUserService;

    @GetMapping("/")
    public String defaultPage(){
        return "homepage";
    }

    @GetMapping("/home")
    public String homePage(){
       return "homepage" ;
    }

}
