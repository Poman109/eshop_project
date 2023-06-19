package com.fsse2305.eshop_project.service;

import com.fsse2305.eshop_project.data.productdata.domainobject.ProductDetailsData;

import java.util.List;
import java.util.Optional;

public interface ProductService {


    List<ProductDetailsData> getAllProduct();

   ProductDetailsData getOneProduct(Integer productId);
}
