package com.fsse2305.eshop_project.service.impl;

import com.fsse2305.eshop_project.data.Status;
import com.fsse2305.eshop_project.data.cart.domainObject.CartItemDetailsData;
import com.fsse2305.eshop_project.data.cart.domainObject.CreatedCartItemData;
import com.fsse2305.eshop_project.data.cart.domainObject.DeletedCartItemData;
import com.fsse2305.eshop_project.data.cart.entity.CartItemEntity;
import com.fsse2305.eshop_project.data.product.entity.ProductEntity;
import com.fsse2305.eshop_project.data.user.domainObject.FirebaseUserData;
import com.fsse2305.eshop_project.data.user.entity.UserEntity;
import com.fsse2305.eshop_project.exception.UpdateCartItemNotAllowedException;
import com.fsse2305.eshop_project.repository.CartItemRepository;
import com.fsse2305.eshop_project.service.CartItemService;
import com.fsse2305.eshop_project.service.ProductService;
import com.fsse2305.eshop_project.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CartItemServiceImpl implements CartItemService {
    private final UserService userService;
    private final ProductService productService;
    private final CartItemRepository cartItemRepository;
    @Autowired
    public CartItemServiceImpl(UserService userService, ProductService productService, CartItemRepository cartItemRepository) {
        this.userService = userService;
        this.productService = productService;
        this.cartItemRepository = cartItemRepository;
    }

    @Override
    public CreatedCartItemData putCartItem(FirebaseUserData firebaseUserData, Integer pid, Integer quantity){
        UserEntity userEntity =userService.getEntityByFirebaseUserData(firebaseUserData);
        ProductEntity productEntity = productService.getProductEntity(pid);
        if(productEntity.getStock() < quantity){
            throw new UpdateCartItemNotAllowedException("Not enough stock!");
        }
        for(CartItemEntity cartItemEntity:userEntity.getUserCartItemsArray()){
            if(cartItemEntity.getPid().getPid()==pid){
                throw new UpdateCartItemNotAllowedException("Product has been added to cart already.");
            }
        }
        CartItemEntity cartItemEntity = new CartItemEntity();
        cartItemEntity.setUid(userEntity);
        cartItemEntity.setPid(productEntity);
        cartItemEntity.setQuantity(quantity);
        cartItemRepository.save(cartItemEntity);
        return new CreatedCartItemData(Status.SUCCESS);
    }

    @Override
    public List<CartItemDetailsData> getUserCart(FirebaseUserData firebaseUserData){
        UserEntity userEntity =userService.getEntityByFirebaseUserData(firebaseUserData);
        List<CartItemDetailsData> cartItemDetailsDataList = new ArrayList<>();
        for(CartItemEntity cartItemEntity:userEntity.getUserCartItemsArray()){
            CartItemDetailsData cartItemDetailsData = new CartItemDetailsData(cartItemEntity);
            cartItemDetailsDataList.add(cartItemDetailsData);
        }
        return cartItemDetailsDataList;
    }

    @Override
    public CartItemDetailsData updateCartItemQuantity(FirebaseUserData firebaseUserData, Integer pid, Integer quantity){
        UserEntity userEntity =userService.getEntityByFirebaseUserData(firebaseUserData);
        if(productService.getProductEntity(pid).getStock() < quantity){
            throw new UpdateCartItemNotAllowedException("Not enough stock!");
        }
        for(CartItemEntity cartItemEntity:userEntity.getUserCartItemsArray()){
            if (cartItemEntity.getPid().getPid() != pid){
                continue;
            }
            if(quantity == 0){
                cartItemEntity.setQuantity(quantity);
                cartItemRepository.delete(cartItemEntity);
                return new CartItemDetailsData(cartItemEntity);
            }
            cartItemEntity.setQuantity(quantity);
            cartItemRepository.save(cartItemEntity);
            return new CartItemDetailsData(cartItemEntity);
        }
        throw new UpdateCartItemNotAllowedException("Cannot update quantity");
    }

    @Override
    public DeletedCartItemData deletedCartItem(FirebaseUserData firebaseUserData, Integer pid){
        UserEntity userEntity =userService.getEntityByFirebaseUserData(firebaseUserData);
        for(CartItemEntity cartItemEntity:userEntity.getUserCartItemsArray()){
            if (cartItemEntity.getPid().getPid() != pid){
                continue;
            }
            cartItemRepository.delete(cartItemEntity);
            return new DeletedCartItemData(Status.SUCCESS );
        }
        throw new UpdateCartItemNotAllowedException("No product id :"+pid +"in cart.");
    }
}
