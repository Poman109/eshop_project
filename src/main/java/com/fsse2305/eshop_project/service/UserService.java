package com.fsse2305.eshop_project.service;

import com.fsse2305.eshop_project.data.cart.entity.CartItemEntity;
import com.fsse2305.eshop_project.data.user.domainObject.FirebaseUserData;
import com.fsse2305.eshop_project.data.user.entity.UserEntity;

import java.util.List;

public interface UserService {
    UserEntity getEntityByFirebaseUserData(FirebaseUserData firebaseUserData);


}
