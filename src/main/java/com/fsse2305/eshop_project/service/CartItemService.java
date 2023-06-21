package com.fsse2305.eshop_project.service;

import com.fsse2305.eshop_project.data.cart.domainObject.CartItemDetailsData;
import com.fsse2305.eshop_project.data.cart.entity.CartItemEntity;
import com.fsse2305.eshop_project.data.user.domainObject.FirebaseUserData;

import java.util.List;
import java.util.Optional;

public interface CartItemService {
    Boolean putCartItem(FirebaseUserData firebaseUserData, Integer pid, Integer quantity);

    List<CartItemDetailsData> getUserCart(FirebaseUserData firebaseUserData);

    CartItemDetailsData updateCartItemQuantity(FirebaseUserData firebaseUserData, Integer pid, Integer quantity);

    Boolean deletedCartItem(FirebaseUserData firebaseUserData, Integer pid);

   List<CartItemEntity> getCartItemByUid(Integer userId);
}
