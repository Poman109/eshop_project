package com.fsse2305.eshop_project.service.impl;

import com.fsse2305.eshop_project.data.product.domainObject.ProductDetailsData;
import com.fsse2305.eshop_project.data.product.entity.ProductEntity;
import com.fsse2305.eshop_project.exception.ProductNotFoundException;
import com.fsse2305.eshop_project.repository.ProductRepository;
import com.fsse2305.eshop_project.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;
    @Autowired
    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public List<ProductDetailsData> getAllProduct(){
        List<ProductDetailsData> productDetailsDataList = new ArrayList<>();
        for(ProductEntity productEntity: productRepository.findAll()){
            productDetailsDataList.add(new ProductDetailsData(productEntity));
        }
        return productDetailsDataList;

    }

    @Override
    public ProductDetailsData getOneProduct(Integer productId){
        Optional<ProductEntity> productEntity = productRepository.findByPid(productId);
            if(productEntity.isPresent()){
                return new ProductDetailsData(productEntity.get());
            }
            throw new ProductNotFoundException("Cannot found productId: "+productId);
    }

    @Override
    public ProductEntity getProductEntity(Integer pid){
        Optional<ProductEntity> productEntity = productRepository.findByPid(pid);
        if(productEntity.isPresent()){
            return productEntity.get();
        }
        throw new ProductNotFoundException("Cannot found productId: "+pid);
    }



}
