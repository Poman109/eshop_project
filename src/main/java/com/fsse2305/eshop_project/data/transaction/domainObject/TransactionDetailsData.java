package com.fsse2305.eshop_project.data.transaction.domainObject;

import com.fsse2305.eshop_project.data.Status;
import com.fsse2305.eshop_project.data.transaction.entity.TransactionEntity;
import com.fsse2305.eshop_project.data.transactionProduct.domainObject.TransactionProductDetailData;
import com.fsse2305.eshop_project.data.transactionProduct.entity.TransactionProductEntity;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class TransactionDetailsData {
    private Integer transactionId;
    private Integer userId;
    private Timestamp datetime;
    private Status status;
    private BigDecimal total;
    private List<TransactionProductDetailData> productList;

    public TransactionDetailsData(TransactionEntity transaction, List<TransactionProductEntity> productEntityList){
        this.transactionId = transaction.getTid();
        this.userId = transaction.getUser().getUid();
        this.datetime = transaction.getDatetime();
        this.status = transaction.getStatus();
        this.total = transaction.getTotal();
        setProductList(productEntityList);
    }


    public Integer getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(Integer transactionId) {
        this.transactionId = transactionId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Timestamp getDatetime() {
        return datetime;
    }

    public void setDatetime(Timestamp datetime) {
        this.datetime = datetime;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    public List<TransactionProductDetailData> getProductList() {
        return productList;
    }

    public void setProductList(List<TransactionProductEntity> productEntityList) {
        List<TransactionProductDetailData> transactionProductDetailDataList = new ArrayList<>();
        for(TransactionProductEntity transactionProduct : productEntityList){
            transactionProductDetailDataList.add(new TransactionProductDetailData(transactionProduct));
        }
        this.productList = transactionProductDetailDataList;
    }
}
