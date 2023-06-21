package com.fsse2305.eshop_project.data.cart.domainObject;

import com.fsse2305.eshop_project.data.cart.entity.CartItemEntity;
import com.fsse2305.eshop_project.data.product.domainObject.ProductDetailsData;


public class CartItemDetailsData {
    private Integer cid;
    private ProductDetailsData product;
    private Integer quantity;

    public CartItemDetailsData(CartItemEntity cartItemEntity){
        this.cid = cartItemEntity.getCid();
        this.product = new ProductDetailsData(cartItemEntity.getProduct());
        this.quantity = cartItemEntity.getQuantity();

    }


    public Integer getCid() {
        return cid;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
    }

    public ProductDetailsData getProduct() {
        return product;
    }

    public void setProduct(ProductDetailsData product) {
        this.product = product;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
}