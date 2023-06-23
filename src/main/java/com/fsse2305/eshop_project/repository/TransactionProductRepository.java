package com.fsse2305.eshop_project.repository;

import com.fsse2305.eshop_project.data.transaction.entity.TransactionEntity;
import com.fsse2305.eshop_project.data.transactionProduct.entity.TransactionProductEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface TransactionProductRepository extends CrudRepository<TransactionProductEntity,Integer> {

    Optional<List<TransactionProductEntity>> findAllByTransaction(TransactionEntity transaction);

}
