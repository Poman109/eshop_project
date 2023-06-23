package com.fsse2305.eshop_project.data.transaction.entity;

import com.fsse2305.eshop_project.data.Status;
import com.fsse2305.eshop_project.data.transactionProduct.entity.TransactionProductEntity;
import com.fsse2305.eshop_project.data.user.entity.UserEntity;
import jakarta.persistence.*;


import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name="Transaction")
public class TransactionEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer tid;
    @ManyToOne
    @JoinColumn(name="user_id",nullable = false)
    private UserEntity user;
    @Column(nullable = false)
    private Timestamp datetime;
    @Column(nullable = false)
    private Status status;
    @Column(nullable = false)
    private BigDecimal total;

    @OneToMany(mappedBy = "transaction")
    private List<TransactionProductEntity> transactionProductList = new ArrayList<>();

    public TransactionEntity() {
    }

    public TransactionEntity(UserEntity userEntity, BigDecimal total) {
        this.user = userEntity;
        setDatetime();
        this.status = Status.PREPARE;
        this.total = total;

    }

    public Integer getTid() {
        return tid;
    }

    public void setTid(Integer tid) {
        this.tid = tid;
    }

    public UserEntity getUser() {
        return user;
    }

    public void setUser(UserEntity buyerUid) {
        this.user = buyerUid;
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

    public List<TransactionProductEntity> getTransactionProductList() {
        return transactionProductList;
    }

    public void setTransactionProductList(List<TransactionProductEntity> transactionProductList) {
        this.transactionProductList = transactionProductList;
    }

    public Timestamp getDatetime() {
        return datetime;
    }

    public void setDatetime() {
        Date date = new Date();
        this.datetime = new Timestamp(date.getTime());
    }
}
