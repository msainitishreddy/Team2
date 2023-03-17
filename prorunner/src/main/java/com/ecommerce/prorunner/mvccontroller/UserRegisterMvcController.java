package com.ecommerce.prorunner.mvccontroller;

import com.ecommerce.prorunner.entity.ProRunnerUserEntity;
import com.ecommerce.prorunner.service.ProRunnerUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user-register")
public class UserRegisterMvcController {
    @Autowired
    private ProRunnerUserService proRunnerUserService;

    @PostMapping
    public String createUser(@ModelAttribute("user") ProRunnerUserEntity proRunnerUserEntity){
        ProRunnerUserEntity response = proRunnerUserService.createOrder(proRunnerUserEntity);
        return "signup";
    }

    @GetMapping
    public String createUser(Model model){
        model.addAttribute("user",new ProRunnerUserEntity());
        return "signup";
    }

}
