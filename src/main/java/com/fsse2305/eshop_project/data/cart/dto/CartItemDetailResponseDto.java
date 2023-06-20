package com.fsse2305.eshop_project.data.cart.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fsse2305.eshop_project.data.cart.domainObject.CartItemDetailsData;

import java.math.BigDecimal;

public class CartItemDetailResponseDto {
    @JsonProperty("pid")
    private Integer pid;
    @JsonProperty("name")
    private String name;
    @JsonProperty("image_url")
    private String imageUrl;
    @JsonProperty("price")
    private BigDecimal price;
    @JsonProperty("cart_quantity")
    private Integer quantity;
    @JsonProperty("stock")
    private Integer stock;

    public CartItemDetailResponseDto(CartItemDetailsData creatCartItemData){
        this.pid = creatCartItemData.getPid().getPid();
        this.name = creatCartItemData.getPid().getName();
        this.imageUrl = creatCartItemData.getPid().getImageUrl();
        this.price = creatCartItemData.getPid().getPrice();
        this.quantity = creatCartItemData.getQuantity();
        this.stock = creatCartItemData.getPid().getStock();
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }
}
