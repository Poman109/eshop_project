package com.fsse2305.eshop_project.repository;

import com.fsse2305.eshop_project.data.productdata.domainobject.ProductDetailsData;
import com.fsse2305.eshop_project.data.productdata.entity.ProductEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface ProductRepository extends CrudRepository<ProductEntity,Integer> {

    Optional<ProductEntity> findByPid(Integer productId);
}
