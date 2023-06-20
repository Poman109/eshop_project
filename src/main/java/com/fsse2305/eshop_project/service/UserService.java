package com.fsse2305.eshop_project.service;

import com.fsse2305.eshop_project.data.user.domainObject.FirebaseUserData;
import com.fsse2305.eshop_project.data.user.entity.UserEntity;

public interface UserService {
    UserEntity getEntityByFirebaseUserData(FirebaseUserData firebaseUserData);
}
