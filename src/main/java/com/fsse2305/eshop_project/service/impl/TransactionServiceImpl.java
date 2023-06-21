package com.fsse2305.eshop_project.service.impl;

import com.fsse2305.eshop_project.data.cart.entity.CartItemEntity;
import com.fsse2305.eshop_project.data.transaction.entity.TransactionEntity;
import com.fsse2305.eshop_project.data.user.domainObject.FirebaseUserData;
import com.fsse2305.eshop_project.data.user.entity.UserEntity;
import com.fsse2305.eshop_project.service.CartItemService;
import com.fsse2305.eshop_project.service.TransactionService;
import com.fsse2305.eshop_project.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransactionServiceImpl implements TransactionService {

    private final CartItemService cartItemService;
    private final UserService userService;
    @Autowired
    public TransactionServiceImpl(CartItemService cartItemService, UserService userService) {
        this.cartItemService = cartItemService;
        this.userService = userService;
    }


    public void createTransaction(FirebaseUserData firebaseUserData){
        UserEntity userEntity =userService.getEntityByFirebaseUserData(firebaseUserData);
        List<CartItemEntity> CartItemEntityList = cartItemService.getCartItemByUid(userEntity.getUid());
        TransactionEntity transaction = new TransactionEntity(userEntity);

        for(CartItemEntity cartItemEntity: CartItemEntityList){

        }

    }

}
