package com.fsse2305.eshop_project.service.impl;

import com.fsse2305.eshop_project.data.Status;
import com.fsse2305.eshop_project.data.cart.entity.CartItemEntity;
import com.fsse2305.eshop_project.data.transaction.domainObject.TransactionDetailsData;
import com.fsse2305.eshop_project.data.transaction.entity.TransactionEntity;
import com.fsse2305.eshop_project.data.transactionProduct.entity.TransactionProductEntity;
import com.fsse2305.eshop_project.data.user.domainObject.FirebaseUserData;
import com.fsse2305.eshop_project.data.user.entity.UserEntity;
import com.fsse2305.eshop_project.exception.TransactionNotAllowException;
import com.fsse2305.eshop_project.repository.TransactionProductRepository;
import com.fsse2305.eshop_project.repository.TransactionRepository;
import com.fsse2305.eshop_project.service.CartItemService;
import com.fsse2305.eshop_project.service.TransactionService;
import com.fsse2305.eshop_project.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TransactionServiceImpl implements TransactionService {
    private final TransactionProductService transactionProductService;
    private  final TransactionProductRepository transactionProductRepository;
    private final TransactionRepository transactionRepository;
    private final CartItemService cartItemService;
    private final UserService userService;
    @Autowired
    public TransactionServiceImpl(TransactionProductService transactionProductService, TransactionProductRepository transactionProductRepository,
                                  TransactionRepository transactionRepository, CartItemService cartItemService, UserService userService) {
        this.transactionProductService = transactionProductService;
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

    @Override
    public TransactionDetailsData getTransactionById(FirebaseUserData firebaseUserData, Integer tid){
        UserEntity userEntity =userService.getEntityByFirebaseUserData(firebaseUserData);
        Optional<TransactionEntity> optionalTransactionEntity = transactionRepository.findByTidAndUser(tid,userEntity);
        if (optionalTransactionEntity.isEmpty()){
            throw new TransactionNotAllowException("No this transaction in account.");
        } else{
                return new TransactionDetailsData(optionalTransactionEntity.get(),transactionProductService.getTransactionItemList(optionalTransactionEntity.get()));
            }

    }

    @Override
    public Boolean updateTransactionStatus(FirebaseUserData firebaseUserData,Integer tid){
        UserEntity userEntity =userService.getEntityByFirebaseUserData(firebaseUserData);
        Optional<TransactionEntity> optionalTransactionEntity = transactionRepository.findByTidAndUser(tid,userEntity);
        if(optionalTransactionEntity.isEmpty()){
            throw new TransactionNotAllowException("No this transaction in account.");
        } else {
            optionalTransactionEntity.get().setStatus(Status.PROCESSING);
            transactionRepository.save(optionalTransactionEntity.get());
            return true;
        }
    }










    public BigDecimal getTotalPriceBySubtotal(List<CartItemEntity> cartItemEntityList){
        BigDecimal total = BigDecimal.ZERO;
        for(CartItemEntity cartItemEntity: cartItemEntityList){
            total = total.add(cartItemEntity.getProduct().getPrice().multiply(new BigDecimal(cartItemEntity.getQuantity())));
        }
        return total;
    }







}
