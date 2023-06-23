package com.fsse2305.eshop_project.service;

import com.fsse2305.eshop_project.data.transaction.domainObject.TransactionDetailsData;
import com.fsse2305.eshop_project.data.user.domainObject.FirebaseUserData;


public interface TransactionService {


    TransactionDetailsData createTransaction(FirebaseUserData firebaseUserData);

    TransactionDetailsData getTransactionById(FirebaseUserData firebaseUserData, Integer tid);
}
