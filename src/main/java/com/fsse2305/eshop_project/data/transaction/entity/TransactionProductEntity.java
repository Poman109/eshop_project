package com.fsse2305.eshop_project.data.transaction.entity;

import jakarta.persistence.*;

import java.math.BigDecimal;
@Entity
@Table(name="TransactionProduct")
public class TransactionProductEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer tpid;
    @ManyToOne
    @JoinColumn(name="transaction_id",nullable = false)
    private TransactionEntity tid;
    @Column(nullable = false)
    private Integer pid;
    @Column(nullable = false)
    private String name;
    private String description;
    private String imageUrl;
    @Column(nullable = false)
    private BigDecimal price;
    @Column(nullable = false)
    private Integer stock;
    @Column(nullable = false)
    private Integer quantity;
    @Column(nullable = false)
    private BigDecimal subtotal;

    public Integer getTpid() {
        return tpid;
    }

    public void setTpid(Integer tpid) {
        this.tpid = tpid;
    }

    public TransactionEntity getTid() {
        return tid;
    }

    public void setTid(TransactionEntity tid) {
        this.tid = tid;
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
