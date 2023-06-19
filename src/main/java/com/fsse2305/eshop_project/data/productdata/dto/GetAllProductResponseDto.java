package com.fsse2305.eshop_project.data.productdata.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fsse2305.eshop_project.data.productdata.domainobject.ProductDetailsData;

import java.math.BigDecimal;

public class GetAllProductResponseDto {
    private Integer pid;
    private String name;
    @JsonProperty("image_url")
    private String imageUrl;
    private BigDecimal price;
    @JsonProperty("has_stock")
    private Boolean stock;

    public GetAllProductResponseDto(ProductDetailsData productDetailsData) {
        this.pid = productDetailsData.getPid();
        this.name = productDetailsData.getName();
        this.imageUrl = productDetailsData.getImageUrl();
        this.price = productDetailsData.getPrice();
        setStock(productDetailsData);

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

    public Boolean getStock() {
        return stock;
    }

    public void setStock(ProductDetailsData productDetailsData) {
        if (productDetailsData.getStock()>0){
            this.stock = true;
        } else {
            this.stock = false;
        }
    }
}
