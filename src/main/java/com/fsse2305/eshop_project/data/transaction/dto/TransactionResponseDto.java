package com.fsse2305.eshop_project.data.transaction.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fsse2305.eshop_project.data.Status;
import com.fsse2305.eshop_project.data.transaction.domainObject.TransactionDetailsData;
import com.fsse2305.eshop_project.data.transactionProduct.domainObject.TransactionProductDetailData;
import com.fsse2305.eshop_project.data.transactionProduct.dto.TransactionProductionResponseDto;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class TransactionResponseDto {
    @JsonProperty("tid")
    private Integer transactionId;
    @JsonProperty("buyer_uid")
    private Integer userId;
    @JsonProperty("datetime")
    private Timestamp datetime;
    @JsonProperty("status")
    private Status status;
    @JsonProperty("total")
    private BigDecimal total;
    @JsonProperty("items")
    private List<TransactionProductionResponseDto> transactionProductList;

    public TransactionResponseDto(TransactionDetailsData data){
        this.transactionId = data.getTransactionId();
        this.userId = data.getUserId();
        this.datetime = data.getDatetime();
        this.status = data.getStatus();
        this.total = data.getTotal();
        setTransactionProductList(data.getProductList());

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

    public List<TransactionProductionResponseDto> getTransactionProductList() {
        return transactionProductList;
    }

    public void setTransactionProductList(List<TransactionProductDetailData> transactionProductList) {
        List<TransactionProductionResponseDto> transactionProductionResponseDtoList = new ArrayList<>();
        for(TransactionProductDetailData transactionProductDetailData: transactionProductList){
            transactionProductionResponseDtoList.add(new TransactionProductionResponseDto(transactionProductDetailData));
        }
        this.transactionProductList = transactionProductionResponseDtoList;
    }
}
