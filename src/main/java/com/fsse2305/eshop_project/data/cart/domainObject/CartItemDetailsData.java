package com.fsse2305.eshop_project.data.cart.domainObject;

import com.fsse2305.eshop_project.data.cart.entity.CartItemEntity;
import com.fsse2305.eshop_project.data.product.domainObject.ProductDetailsData;


public class CartItemDetailsData {
    private Integer cid;
    private ProductDetailsData pid;
    private Integer quantity;

    public CartItemDetailsData(CartItemEntity cartItemEntity){
        this.cid = cartItemEntity.getCid();
        this.pid = new ProductDetailsData(cartItemEntity.getPid());
        this.quantity = cartItemEntity.getQuantity();

    }


    public Integer getCid() {
        return cid;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
    }

    public ProductDetailsData getPid() {
        return pid;
    }

    public void setPid(ProductDetailsData pid) {
        this.pid = pid;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
}