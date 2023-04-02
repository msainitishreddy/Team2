package com.ecommerce.prorunner.service;

import com.ecommerce.prorunner.entity.OrderEntity;
import com.ecommerce.prorunner.entity.ProRunnerUserEntity;
import com.ecommerce.prorunner.entity.ProductEntity;
import com.ecommerce.prorunner.repository.ProRunnerRepository;
import org.hibernate.criterion.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

@Service
public class ProRunnerUserServiceImpl implements ProRunnerUserService{

    @Autowired
    private ProRunnerRepository proRunnerRepository;

    @Autowired
    private ProductService productService;

    @Autowired
    private OrderService orderService;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public ProRunnerUserEntity createUser(ProRunnerUserEntity proRunnerUserEntity) {
        if(proRunnerUserEntity.getRole()==null){
            //proRunnerUserEntity.setRole("ADMIN");
            proRunnerUserEntity.setRole("USER");
        }
        proRunnerUserEntity.setPassword(passwordEncoder.encode(proRunnerUserEntity.getPassword()));
        proRunnerUserEntity = proRunnerRepository.save(proRunnerUserEntity);
        return proRunnerUserEntity;
    }

    @Override
    public ProRunnerUserEntity findProRunnerUserByEmail(String email) {
        return proRunnerRepository.findByEmail(email);
    }

    @Override
    public void deleteProduct(Long Id) {

    }

    @Override
    public List<ProductEntity> addProductsToCartList(Long productId, String email) {
        ProRunnerUserEntity proRunnerUserEntity = proRunnerRepository.findByEmail(email);
        String cartProductIdsCSV = proRunnerUserEntity.getCartProductList();//proRunnerRepository.getCartListProducts(proRunnerUserEntity.getId());
        if((cartProductIdsCSV != null && cartProductIdsCSV.length() > 0 )) {
            if(!cartProductIdsCSV.contains(""+productId)){
                cartProductIdsCSV = cartProductIdsCSV + "," + productId;

            }
        }
        else{
            cartProductIdsCSV = "" + productId;
        }
        proRunnerRepository.addOrUpdateProductsToCartList(cartProductIdsCSV, proRunnerUserEntity.getId());
        return this.getCartListProductsByIds(cartProductIdsCSV);
        //return null;
    }

    @Override
    public List<ProductEntity> removeProductFromCartList(Long productId, String email) {
        ProRunnerUserEntity proRunnerUserEntity = proRunnerRepository.findByEmail(email);
        String cartProductIdsCSV = proRunnerUserEntity.getCartProductList();//proRunnerRepository.getCartListProducts(proRunnerUserEntity.getId());
        if(cartProductIdsCSV.length() == 0 || cartProductIdsCSV.length() == 1){
            cartProductIdsCSV ="";
        }
        else{
            String[] productIdsStringArray = cartProductIdsCSV.split(",");
            String tempProductIds="";
            for(int i=0;i<productIdsStringArray.length;i++){
                if(i == productIdsStringArray.length-1){
                    tempProductIds += productIdsStringArray[i].equals(""+productId) ? "" : productIdsStringArray[i];
                }
                else{
                    tempProductIds += productIdsStringArray[i].equals(""+productId) ? "" : productIdsStringArray[i]+ ",";
                }
            }
            cartProductIdsCSV = tempProductIds;
        }
        //cartProductIdsCSV = cartProductIdsCSV.replace(""+productId,"").replace(",,","");
        proRunnerRepository.addOrUpdateProductsToCartList(cartProductIdsCSV, proRunnerUserEntity.getId());
        return this.getCartListProductsByIds(cartProductIdsCSV);
    }

    @Override
    public List<ProductEntity> getCartListProducts(String email) {
        ProRunnerUserEntity proRunnerUserEntity = proRunnerRepository.findByEmail(email);
        String cartProductIdsCSV = proRunnerRepository.getCartListProducts(proRunnerUserEntity.getId());
        return this.getCartListProductsByIds(cartProductIdsCSV);
    }

    @Override
    public List<ProductEntity> getCartListProductsByIds(String StringProductIds) {
        if(StringProductIds.equals("")){
            return new ArrayList<ProductEntity>();
        }
        List<Long> longList = new LinkedList<>();
        String[] productIdsStringArray = StringProductIds.split(",");

        if(productIdsStringArray.length > 0){
            for(String productIdString : productIdsStringArray){
                if(productIdString!= null && !productIdString.equals("")){
                    Long longId = Long.parseLong(productIdString);
                    if(!longList.contains(longId)){
                        longList.add(longId);
                    }
                }
            }
        }
        else{
            return  new ArrayList<ProductEntity>();
        }
        return productService.listOfProductsByIds(longList);
    }

    @Override
    public String placeOrder(String email) {
        ProRunnerUserEntity proRunnerUserEntity = proRunnerRepository.findByEmail(email);
        List<ProductEntity> products = this.getCartListProducts(email);

        OrderEntity  orderEntity = new OrderEntity();
        orderEntity.setProRunnerUser(proRunnerUserEntity);
        orderEntity.setProducts(products);
        orderEntity.setAddress(proRunnerUserEntity.getAddress());
        orderEntity = orderService.createOrder(orderEntity);
        if(orderEntity != null && orderEntity.getId() > 0){
            proRunnerRepository.addOrUpdateProductsToCartList("", proRunnerUserEntity.getId());
            return "order placed";
        }
        return "order not placed";
    }


}
