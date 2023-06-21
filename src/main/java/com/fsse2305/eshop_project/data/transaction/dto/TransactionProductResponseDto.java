package com.fsse2305.eshop_project.data.transaction.dto;

import com.fsse2305.eshop_project.data.Status;
import com.fsse2305.eshop_project.data.product.entity.ProductEntity;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.List;

public class TransactionProductResponseDto {
    private Integer transactionId;
    private Integer userId;
    private Timestamp datatime;
    private Status status;
    private BigDecimal total;
    private List<ProductEntity> product;
    private Integer quantity;
    private BigDecimal subtotal;

}
