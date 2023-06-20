package com.fsse2305.eshop_project.data.cart.entity;

import com.fsse2305.eshop_project.data.product.entity.ProductEntity;
import com.fsse2305.eshop_project.data.user.entity.UserEntity;
import jakarta.persistence.*;

@Entity
@Table(name = "cart")
public class CartItemEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer cid;
    @ManyToOne
    @JoinColumn(name="product_id")
    private ProductEntity pid;
    @ManyToOne
    @JoinColumn(name="user_id")
    private UserEntity uid;
    private Integer quantity;

    public CartItemEntity() {
    }

    public Integer getCid() {
        return cid;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
    }

    public ProductEntity getPid() {
        return pid;
    }

    public void setPid(ProductEntity pid) {
        this.pid = pid;
    }

    public UserEntity getUid() {
        return uid;
    }

    public void setUid(UserEntity uid) {
        this.uid = uid;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
}
