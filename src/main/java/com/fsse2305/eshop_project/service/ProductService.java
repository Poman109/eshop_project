package com.fsse2305.eshop_project.service;

import com.fsse2305.eshop_project.data.product.domainObject.ProductDetailsData;
import com.fsse2305.eshop_project.data.product.entity.ProductEntity;

import java.util.List;

public interface ProductService {


    List<ProductDetailsData> getAllProduct();

   ProductDetailsData getOneProduct(Integer productId);

   ProductEntity getProductEntity(Integer pid);
}
