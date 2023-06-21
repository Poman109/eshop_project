package com.fsse2305.eshop_project.repository;

import com.fsse2305.eshop_project.data.transaction.entity.TransactionEntity;
import org.hibernate.Transaction;
import org.springframework.data.repository.CrudRepository;

public interface TransactionRepository extends CrudRepository<TransactionEntity,Integer> {
}
