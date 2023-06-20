package com.fsse2305.eshop_project.service.impl;

import com.fsse2305.eshop_project.data.Status;
import com.fsse2305.eshop_project.data.cart.domainObject.CartItemDetailsData;
import com.fsse2305.eshop_project.data.cart.domainObject.CreatedCartItemData;
import com.fsse2305.eshop_project.data.cart.entity.CartItemEntity;
import com.fsse2305.eshop_project.data.product.entity.ProductEntity;
import com.fsse2305.eshop_project.data.user.domainObject.FirebaseUserData;
import com.fsse2305.eshop_project.data.user.entity.UserEntity;
import com.fsse2305.eshop_project.service.CartItemService;
import com.fsse2305.eshop_project.service.ProductService;
import com.fsse2305.eshop_project.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CartItemServiceImpl implements CartItemService {
    private final UserService userService;
    private final ProductService productService;
    @Autowired
    public CartItemServiceImpl(UserService userService, ProductService productService) {
        this.userService = userService;
        this.productService = productService;
    }

    @Override
    public CreatedCartItemData putCartItem(FirebaseUserData firebaseUserData, Integer pid, Integer quantity){
        UserEntity userEntity =userService.getEntityByFirebaseUserData(firebaseUserData);

        ProductEntity productEntity = productService.getProductEntity(pid);
        CartItemEntity cartItemEntity = new CartItemEntity();
        cartItemEntity.setUid(userEntity);
        cartItemEntity.setPid(productEntity);
        cartItemEntity.setQuantity(quantity);
        return new CreatedCartItemData(Status.SUCCESS);
    }
}
