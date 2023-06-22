package com.fsse2305.eshop_project.data.cart.dto;

import com.fsse2305.eshop_project.data.cart.domainObject.CartItemDetailsData;
import com.fsse2305.eshop_project.data.cart.entity.CartItemEntity;
import com.fsse2305.eshop_project.data.product.domainObject.ProductDetailsData;
import com.fsse2305.eshop_project.data.product.dto.ProductDetailsResponseDto;

public class CartItemDetailResponseDto {
    private Integer cid;
    private ProductDetailsResponseDto product;
    private Integer quantity;

    public CartItemDetailResponseDto(CartItemDetailsData cartItemDetailsData){
        this.cid = cartItemDetailsData.getCid();
        this.product = new ProductDetailsResponseDto(cartItemDetailsData.getProduct());
        this.quantity = cartItemDetailsData.getQuantity();

    }

    public Integer getCid() {
        return cid;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
    }

    public ProductDetailsResponseDto getProduct() {
        return product;
    }

    public void setProduct(ProductDetailsResponseDto product) {
        this.product = product;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
}
