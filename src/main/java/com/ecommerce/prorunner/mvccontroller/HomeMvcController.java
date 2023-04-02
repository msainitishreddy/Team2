package com.ecommerce.prorunner.mvccontroller;

import com.ecommerce.prorunner.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeMvcController {
    @Autowired
    private ProductService productService;



    @GetMapping("/")
    public String defaultPage(){
        return "redirect:/home";
    }

    @GetMapping("/home")
    public String homePage(Model model){
        return "homepage" ;
    }
    @GetMapping("/about-us")
    public String aboutUsPage(){
        return "aboutUs" ;
    }

    @GetMapping("/support")
    public String supportPage(){
        return "support" ;
    }

    @GetMapping("/contact-us")
    public String contactUsPage(){
        return "contactUs" ;
    }

}
