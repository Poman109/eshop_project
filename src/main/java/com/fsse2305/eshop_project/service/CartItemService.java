package com.fsse2305.eshop_project.service;

import com.fsse2305.eshop_project.data.cart.domainObject.CartItemDetailsData;
import com.fsse2305.eshop_project.data.cart.domainObject.CreatedCartItemData;
import com.fsse2305.eshop_project.data.user.domainObject.FirebaseUserData;

public interface CartItemService {
    CreatedCartItemData putCartItem(FirebaseUserData firebaseUserData, Integer pid, Integer quantity);
}
