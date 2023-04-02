package com.ecommerce.prorunner.mvccontroller;

import com.ecommerce.prorunner.entity.ProductEntity;
import com.ecommerce.prorunner.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ProductMvcController {
    @Autowired
    private ProductService productService;

    @PostMapping("/add-product")
    public String createProduct(@ModelAttribute("product") ProductEntity productEntity){
        ProductEntity product =productService.addProduct(productEntity);
        return "addproduct";
    }

    @GetMapping("/add-product")
    public String createProduct(Model model){
        model.addAttribute("product",new ProductEntity());
        return "addproduct";
    }

    @GetMapping("/products/{category}/{category-type}")
    public String getProductsByCategoryAndSubCategory(@PathVariable("category") String category,@PathVariable(value = "category-type") String categoryType, Model model){
        model.addAttribute("productList", productService.getProductsByCategoryAndSubCategory(category,categoryType));
        model.addAttribute("category", category);
        return "product-page";
    }

    @GetMapping("/products/{category}")
    public String getProductsByCategory(@PathVariable("category") String category, Model model){
        model.addAttribute("productList", productService.getProductsByCategoryAndSubCategory(category,null));
        model.addAttribute("category", category);
        return "product-page";
    }

    @GetMapping("/error")
    public String errorPage(){
        return "/error/40X";
    }
}
