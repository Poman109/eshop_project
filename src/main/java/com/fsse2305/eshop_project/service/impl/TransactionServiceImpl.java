package com.fsse2305.eshop_project.service.impl;

import com.fsse2305.eshop_project.data.cart.entity.CartItemEntity;
import com.fsse2305.eshop_project.data.transaction.domainObject.TransactionDetailsData;
import com.fsse2305.eshop_project.data.transaction.entity.TransactionEntity;
import com.fsse2305.eshop_project.data.transactionProduct.entity.TransactionProductEntity;
import com.fsse2305.eshop_project.data.user.domainObject.FirebaseUserData;
import com.fsse2305.eshop_project.data.user.entity.UserEntity;
import com.fsse2305.eshop_project.repository.TransactionProductRepository;
import com.fsse2305.eshop_project.repository.TransactionRepository;
import com.fsse2305.eshop_project.service.CartItemService;
import com.fsse2305.eshop_project.service.TransactionService;
import com.fsse2305.eshop_project.service.UserService;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Service
public class TransactionServiceImpl implements TransactionService {

    private  final TransactionProductRepository transactionProductRepository;
    private final TransactionRepository transactionRepository;
    private final CartItemService cartItemService;
    private final UserService userService;
    @Autowired
    public TransactionServiceImpl(TransactionProductRepository transactionProductRepository, TransactionRepository transactionRepository, CartItemService cartItemService, UserService userService) {
        this.transactionProductRepository = transactionProductRepository;
        this.transactionRepository = transactionRepository;
        this.cartItemService = cartItemService;
        this.userService = userService;
    }

    @Override
    public TransactionDetailsData createTransaction(FirebaseUserData firebaseUserData){
        UserEntity userEntity =userService.getEntityByFirebaseUserData(firebaseUserData);
        List<CartItemEntity> cartItemEntityList = cartItemService.getCartItemByUid(userEntity.getUid());

        BigDecimal total = getTotalPriceBySubtotal(cartItemEntityList);
        TransactionEntity transaction = new TransactionEntity(userEntity,total);
        transactionRepository.save(transaction);

        List<TransactionProductEntity> transactionProductEntityList = new ArrayList<>();
        for(CartItemEntity cartItemEntity:cartItemEntityList){
            TransactionProductEntity transactionProductEntity = new TransactionProductEntity(transaction,cartItemEntity);
            transactionProductEntityList.add(transactionProductEntity);
            transactionProductRepository.save(transactionProductEntity);
        }

            return new TransactionDetailsData(transaction,transactionProductEntityList);
    }

//    public TransactionDetailsData getTransactionById(FirebaseUserData firebaseUserData,Integer tid){
//
//    }





    public BigDecimal getTotalPriceBySubtotal(List<CartItemEntity> cartItemEntityList){
        BigDecimal total = BigDecimal.ZERO;
        for(CartItemEntity cartItemEntity: cartItemEntityList){
            total = total.add(cartItemEntity.getProduct().getPrice().multiply(new BigDecimal(cartItemEntity.getQuantity())));
        }
        return total;
    }







}
