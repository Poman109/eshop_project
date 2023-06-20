package com.fsse2305.eshop_project.data.transaction.entity;

import com.fsse2305.eshop_project.data.product.entity.ProductEntity;
import com.fsse2305.eshop_project.data.transaction.TransactionStatus;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.List;

public class TransactionEntity {
    private Integer tid;
    private Integer buyerUid;
    private Timestamp datatime;
    private TransactionStatus status;
    private BigDecimal total;
    private List<ProductEntity> products;
    private Integer quantity;
    private BigDecimal subtotal;

}
