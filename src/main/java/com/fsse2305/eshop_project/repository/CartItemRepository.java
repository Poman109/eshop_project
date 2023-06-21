package com.fsse2305.eshop_project.repository;

import com.fsse2305.eshop_project.data.cart.entity.CartItemEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface CartItemRepository extends CrudRepository<CartItemEntity,Integer> {

}
