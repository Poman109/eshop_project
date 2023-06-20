package com.fsse2305.eshop_project.data.user.entity;

import com.fsse2305.eshop_project.data.cart.entity.CartItemEntity;
import com.fsse2305.eshop_project.data.user.domainObject.FirebaseUserData;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="user")
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer uid;
    @Column(name = "firebase_uid",unique = true)
    private String firebaseUid;
    private String email;

    @OneToMany(mappedBy = "uid")
    private List<CartItemEntity> UserCartItemsArray = new ArrayList<>();


    public UserEntity(FirebaseUserData firebaseUserData){
        this.firebaseUid = firebaseUserData.getFirebaseUid();
        this.email = firebaseUserData.getEmail();
    }

    public UserEntity() {

    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirebaseUid() {
        return firebaseUid;
    }

    public void setFirebaseUid(String firebaseUid) {
        this.firebaseUid = firebaseUid;
    }

    public List<CartItemEntity> getUserCartItemsArray() {
        return UserCartItemsArray;
    }

    public void setUserCartItemsArray(List<CartItemEntity> userCartItemsArray) {
        UserCartItemsArray = userCartItemsArray;
    }
}
