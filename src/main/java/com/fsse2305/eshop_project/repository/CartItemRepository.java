package com.fsse2305.eshop_project.repository;

import com.fsse2305.eshop_project.data.cart.entity.CartItemEntity;
import com.fsse2305.eshop_project.data.product.entity.ProductEntity;
import com.fsse2305.eshop_project.data.user.entity.UserEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface CartItemRepository extends CrudRepository<CartItemEntity,Integer> {

    @Query(value = "SELECT *FROM cart WHERE user_id=?1 AND product_id=?2",nativeQuery = true)
    Optional<CartItemEntity> findByUserUidAndProductPid(Integer uid, Integer pid);

    Optional<List<CartItemEntity>> findByUserUid(Integer userId);
}
