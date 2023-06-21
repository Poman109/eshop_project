package com.fsse2305.eshop_project.data.transaction.entity;

import com.fsse2305.eshop_project.data.Status;
import com.fsse2305.eshop_project.data.product.entity.ProductEntity;
import com.fsse2305.eshop_project.data.user.entity.UserEntity;
import jakarta.persistence.*;


import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="Transaction")
public class TransactionEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer tid;
    @ManyToOne
    @JoinColumn(name="user_id",nullable = false)
    private UserEntity buyerUid;
    @Column(nullable = false)
    private Timestamp datatime;
    @Column(nullable = false)
    private Status status;
    @Column(nullable = false)
    private BigDecimal total;

    @OneToMany(mappedBy = "tid")
    private List<TransactionProductEntity> transactionProductList = new ArrayList<>();

    public Integer getTid() {
        return tid;
    }

    public void setTid(Integer tid) {
        this.tid = tid;
    }

    public UserEntity getBuyerUid() {
        return buyerUid;
    }

    public void setBuyerUid(UserEntity buyerUid) {
        this.buyerUid = buyerUid;
    }

    public Timestamp getDatatime() {
        return datatime;
    }

    public void setDatatime(Timestamp datatime) {
        this.datatime = datatime;
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
}
