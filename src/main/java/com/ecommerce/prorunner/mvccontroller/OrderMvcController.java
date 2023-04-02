package com.ecommerce.prorunner.mvccontroller;

import com.ecommerce.prorunner.entity.ProductEntity;
import com.ecommerce.prorunner.service.ProRunnerUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.security.Principal;
import java.util.List;

@Controller
public class OrderMvcController {
    @Autowired
    private ProRunnerUserService proRunnerUserService;

    @GetMapping("/my-orders")
    public String myOrders(Model model, Principal principal){
        //model.addAttribute("productList",);
        return "my-cart" ;
    }

}
