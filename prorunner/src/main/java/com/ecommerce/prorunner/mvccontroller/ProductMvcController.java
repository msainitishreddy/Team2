package com.ecommerce.prorunner.mvccontroller;

import com.ecommerce.prorunner.entity.ProductEntity;
import com.ecommerce.prorunner.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/add-product")
public class ProductMvcController {
    @Autowired
    private ProductService productService;

    @PostMapping
    public String createUser(@ModelAttribute("product") ProductEntity productEntity){
        ProductEntity product =productService.addProduct(productEntity);
        return "addproduct";
    }

    @GetMapping
    public String createUser(Model model){
        model.addAttribute("product",new ProductEntity());
        return "addproduct";
    }

}
