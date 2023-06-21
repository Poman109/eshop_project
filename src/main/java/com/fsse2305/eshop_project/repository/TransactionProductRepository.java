package com.fsse2305.eshop_project.repository;

import com.fsse2305.eshop_project.data.transaction.entity.TransactionProductEntity;
import org.springframework.data.repository.CrudRepository;

public interface TransactionProductRepository extends CrudRepository<TransactionProductEntity,Integer> {

}
