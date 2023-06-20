package com.fsse2305.eshop_project.repository;

import com.fsse2305.eshop_project.data.cart.entity.CartItemEntity;
import org.springframework.data.repository.CrudRepository;

public interface CartItemRepository extends CrudRepository<CartItemEntity,Integer> {
}
