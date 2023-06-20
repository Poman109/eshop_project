package com.fsse2305.eshop_project.service;

import com.fsse2305.eshop_project.data.user.domainObject.FirebaseUserData;

public interface CartItemService {
    void putCartItem(FirebaseUserData firebaseUserData, Integer pid, Integer quantity);
}
