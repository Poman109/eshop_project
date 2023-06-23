package com.fsse2305.eshop_project.service.impl;

import com.fsse2305.eshop_project.data.transaction.entity.TransactionEntity;
import com.fsse2305.eshop_project.data.transactionProduct.entity.TransactionProductEntity;
import com.fsse2305.eshop_project.exception.TransactionNotAllowException;
import com.fsse2305.eshop_project.repository.TransactionProductRepository;
import com.fsse2305.eshop_project.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TransactionProductServiceImpl implements TransactionService.TransactionProductService {
    private final TransactionProductRepository transactionProductRepository;
    @Autowired
    public TransactionProductServiceImpl(TransactionProductRepository transactionProductRepository) {
        this.transactionProductRepository = transactionProductRepository;
    }

    @Override
    public List<TransactionProductEntity> getTransactionItemList(TransactionEntity transaction) {
        Optional<List<TransactionProductEntity>> transactionItemList =
                transactionProductRepository.findAllByTransaction(transaction);
        if(transactionItemList.isEmpty()){
            throw new TransactionNotAllowException("Cannot find transaction product");
        } else {
            return transactionItemList.get();
        }



    }
}
