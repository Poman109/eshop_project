package com.fsse2305.eshop_project.data.transactionProduct.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fsse2305.eshop_project.data.product.dto.ProductDetailsResponseDto;
import com.fsse2305.eshop_project.data.transactionProduct.domainObject.TransactionProductDetailData;

import java.math.BigDecimal;

public class TransactionProductionResponseDto {
    @JsonProperty("tpid")
    private Integer tpid;
    @JsonProperty("product")
    private ProductDetailsResponseDto item;
    @JsonProperty("quantity")
    private Integer quantity;
    @JsonProperty("subtotal")
    private BigDecimal subtotal;


    public TransactionProductionResponseDto(TransactionProductDetailData data){
        this.tpid = data.getTpid();
        setItem(data);
        this.quantity = data.getQuantity();
        this.subtotal = data.getSubtotal();

    }


    public Integer getTpid() {
        return tpid;
    }

    public void setTpid(Integer tpid) {
        this.tpid = tpid;
    }

    public ProductDetailsResponseDto getItem() {
        return item;
    }

    public void setItem(TransactionProductDetailData data) {
        ProductDetailsResponseDto productDetailsResponseDto = new ProductDetailsResponseDto();
        productDetailsResponseDto.setPid(data.getPid());
        productDetailsResponseDto.setName(data.getName());
        productDetailsResponseDto.setDescription(data.getDescription());
        productDetailsResponseDto.setImageUrl(data.getImageUrl());
        productDetailsResponseDto.setPrice(data.getPrice());
        productDetailsResponseDto.setStock(data.getStock());
        this.item = productDetailsResponseDto;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public BigDecimal getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(BigDecimal subtotal) {
        this.subtotal = subtotal;
    }
}
