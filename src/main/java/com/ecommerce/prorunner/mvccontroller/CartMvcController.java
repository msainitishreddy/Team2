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
import java.util.stream.Collectors;

@Controller
public class CartMvcController {
    @Autowired
    private ProRunnerUserService proRunnerUserService;

    @GetMapping("/add-to-cart/{id}")
    public String addProductToCart(@PathVariable(value = "id") long productID, Model model, Principal principal){
        model.addAttribute("productList",proRunnerUserService.addProductsToCartList(productID,principal.getName()));
        return "redirect:/my-cart" ;
    }

    @GetMapping("/remove-cart-item/{id}")
    public String deleteProductFromCart(@PathVariable(value = "id") long productID, Model model, Principal principal){
        model.addAttribute("productList",proRunnerUserService.removeProductFromCartList(productID,principal.getName()));
        return "redirect:/my-cart";
    }

    @GetMapping("/my-cart")
    public String myCart(Model model, Principal principal){
        List<ProductEntity> cartListProducts = proRunnerUserService.getCartListProducts(principal.getName());
        double totalPrice = cartListProducts.stream().mapToDouble(ProductEntity::getPrice).sum();
        model.addAttribute("productList", cartListProducts);
        model.addAttribute("totalPrice", totalPrice);
        return "cart" ;
    }

    @PostMapping("/my-cart/place-order")
    public String placeOrder(Model model, Principal principal){
        proRunnerUserService.placeOrder(principal.getName());
        model.addAttribute("productList",proRunnerUserService.getCartListProducts(principal.getName()));
        model.addAttribute("orderStatus","Order placed Successfully");
        return "cart" ;
    }

}
