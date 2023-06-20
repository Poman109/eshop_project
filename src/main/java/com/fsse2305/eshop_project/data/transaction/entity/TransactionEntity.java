package com.fsse2305.eshop_project.data.transaction.entity;

import com.fsse2305.eshop_project.data.Status;
import com.fsse2305.eshop_project.data.product.entity.ProductEntity;


import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.List;

public class TransactionEntity {
    private Integer tid;
    private Integer buyerUid;
    private Timestamp datatime;
    private Status status;
    private BigDecimal total;
    private List<ProductEntity> products;
    private Integer quantity;
    private BigDecimal subtotal;

}
