package com.fsse2305.eshop_project.service;

import com.fsse2305.eshop_project.data.transaction.domainObject.TransactionDetailsData;
import com.fsse2305.eshop_project.data.transaction.entity.TransactionEntity;
import com.fsse2305.eshop_project.data.transactionProduct.entity.TransactionProductEntity;
import com.fsse2305.eshop_project.data.user.domainObject.FirebaseUserData;

import java.util.List;


public interface TransactionService {


    TransactionDetailsData createTransaction(FirebaseUserData firebaseUserData);

    TransactionDetailsData getTransactionById(FirebaseUserData firebaseUserData, Integer tid);

    interface TransactionProductService {
        List<TransactionProductEntity> getTransactionItemList(TransactionEntity transaction);
    }
}
