package com.fsse2305.eshop_project.data.product.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fsse2305.eshop_project.data.product.domainObject.ProductDetailsData;

import java.math.BigDecimal;

public class ProductDetailsResponseDto {
    private Integer pid;
    private String name;
    private String description;
    @JsonProperty("image_url")
    private String imageUrl;
    private BigDecimal price;
    private Integer stock;

    public ProductDetailsResponseDto() {
    }

    public ProductDetailsResponseDto(ProductDetailsData productDetailsData){
        this.pid = productDetailsData.getPid();
        this.name = productDetailsData.getName();
        this.description = productDetailsData.getDescription();
        this.imageUrl = productDetailsData.getImageUrl();
        this.price = productDetailsData.getPrice();
        this.stock = productDetailsData.getStock();

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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }
}
