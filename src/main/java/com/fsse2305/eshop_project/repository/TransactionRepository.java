package com.fsse2305.eshop_project.repository;

import com.fsse2305.eshop_project.data.transaction.entity.TransactionEntity;
import com.fsse2305.eshop_project.data.user.entity.UserEntity;
import org.hibernate.Transaction;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface TransactionRepository extends CrudRepository<TransactionEntity,Integer> {
    Optional<TransactionEntity> findByTidAndUser(Integer tid,UserEntity user);


}
