package com.fsse2305.eshop_project.data.cart.entity;

import com.fsse2305.eshop_project.data.product.entity.ProductEntity;

import java.util.List;

public class CartEntity {
    private Integer cid;
    private Integer uid;
    private List<ProductEntity> products;
    private Integer quantity;
}
