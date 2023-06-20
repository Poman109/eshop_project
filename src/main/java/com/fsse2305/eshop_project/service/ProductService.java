package com.fsse2305.eshop_project.service;

import com.fsse2305.eshop_project.data.product.domainobject.ProductDetailsData;

import java.util.List;

public interface ProductService {


    List<ProductDetailsData> getAllProduct();

   ProductDetailsData getOneProduct(Integer productId);
}
