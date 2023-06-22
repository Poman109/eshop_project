package com.fsse2305.eshop_project.service.impl;

import com.fsse2305.eshop_project.data.cart.domainObject.CartItemDetailsData;
import com.fsse2305.eshop_project.data.cart.entity.CartItemEntity;
import com.fsse2305.eshop_project.data.product.entity.ProductEntity;
import com.fsse2305.eshop_project.data.user.domainObject.FirebaseUserData;
import com.fsse2305.eshop_project.data.user.entity.UserEntity;
import com.fsse2305.eshop_project.exception.ProductNotFoundException;
import com.fsse2305.eshop_project.exception.UpdateCartItemNotAllowedException;
import com.fsse2305.eshop_project.repository.CartItemRepository;
import com.fsse2305.eshop_project.service.CartItemService;
import com.fsse2305.eshop_project.service.ProductService;
import com.fsse2305.eshop_project.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CartItemServiceImpl implements CartItemService {
//    private Logger logger = LoggerFactory.getLogger(CartItemEntity.class);

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
    public Boolean putCartItem(FirebaseUserData firebaseUserData, Integer pid, Integer quantity){
        UserEntity userEntity =userService.getEntityByFirebaseUserData(firebaseUserData);
        ProductEntity productEntity = productService.getProductEntity(pid);
        if(!checkHasStock(productEntity,quantity)){
            throw new UpdateCartItemNotAllowedException("Not enough stock!");
        }

        Optional<CartItemEntity> optionalCartItemEntity = cartItemRepository.findByUserUidAndProductPid(userEntity.getUid(),productEntity.getPid());
        if (optionalCartItemEntity.isEmpty()){
            CartItemEntity cartItemEntity = new CartItemEntity(productEntity,userEntity,quantity);
            cartItemRepository.save(cartItemEntity);
            return true;
        } else {
            if(!checkHasStock(productEntity,optionalCartItemEntity.get().getQuantity()+quantity)){
                throw new UpdateCartItemNotAllowedException("Not enough stock!");
            } else {
                optionalCartItemEntity.get().setQuantity(optionalCartItemEntity.get().getQuantity()+quantity);
                cartItemRepository.save(optionalCartItemEntity.get());
                return true;
            }
        }
    }

    @Override
    public List<CartItemDetailsData> getUserCart(FirebaseUserData firebaseUserData){
        UserEntity userEntity =userService.getEntityByFirebaseUserData(firebaseUserData);
        List<CartItemDetailsData> cartItemDetailsDataList = new ArrayList<>();
        for(CartItemEntity cartItemEntity:getCartItemByUid(userEntity.getUid())){
            cartItemDetailsDataList.add(new CartItemDetailsData(cartItemEntity));
        }
        return cartItemDetailsDataList;


//        List<CartItemDetailsData> cartItemDetailsDataList = new ArrayList<>();
//        for(CartItemEntity cartItemEntity:userEntity.getUserCartItemsArray()){
//            CartItemDetailsData cartItemDetailsData = new CartItemDetailsData(cartItemEntity);
//            cartItemDetailsDataList.add(cartItemDetailsData);
//        }
    }

    @Override
    public CartItemDetailsData updateCartItemQuantity(FirebaseUserData firebaseUserData, Integer pid, Integer quantity){
        UserEntity userEntity =userService.getEntityByFirebaseUserData(firebaseUserData);
        if(productService.getProductEntity(pid).getStock() < quantity){
            throw new UpdateCartItemNotAllowedException("Not enough stock!");
        }
        Optional<CartItemEntity> optionalCartItemEntity = cartItemRepository.findByUserUidAndProductPid(userEntity.getUid(),pid);
        if(optionalCartItemEntity.isEmpty()){
            throw new ProductNotFoundException("No this product in cart");
        } else {
            if(quantity == 0){
                optionalCartItemEntity.get().setQuantity(quantity);
                cartItemRepository.delete(optionalCartItemEntity.get());
                return new CartItemDetailsData(optionalCartItemEntity.get());
            }
            optionalCartItemEntity.get().setQuantity(quantity);
            cartItemRepository.save(optionalCartItemEntity.get());
            return new CartItemDetailsData(optionalCartItemEntity.get());
        }


//        for(CartItemEntity cartItemEntity:userEntity.getUserCartItemsArray()){
//            if (cartItemEntity.getProduct().getPid() != pid){
//                continue;
//            }
//            if(quantity == 0){
//                cartItemEntity.setQuantity(quantity);
//                cartItemRepository.delete(cartItemEntity);
//                return new CartItemDetailsData(cartItemEntity);
//            }
//            cartItemEntity.setQuantity(quantity);
//            cartItemRepository.save(cartItemEntity);
//            return new CartItemDetailsData(cartItemEntity);
//        }
//        throw new UpdateCartItemNotAllowedException("Cannot update quantity");
    }

    @Override
    public Boolean deletedCartItem(FirebaseUserData firebaseUserData, Integer pid){
        UserEntity userEntity =userService.getEntityByFirebaseUserData(firebaseUserData);

        Optional<CartItemEntity> optionalCartItemEntity = cartItemRepository.findByUserUidAndProductPid(userEntity.getUid(),pid);
        if(optionalCartItemEntity.isEmpty()){
            throw new UpdateCartItemNotAllowedException("No product id :"+pid +"in cart.");
        }
        cartItemRepository.delete(optionalCartItemEntity.get());
        return true;
    }

    public Boolean checkHasStock(ProductEntity productEntity,Integer quantity){
            return productEntity.getStock()>= quantity;
    }

    @Override
    public List<CartItemEntity> getCartItemByUid(Integer userId){
        Optional<List<CartItemEntity>> optionalCartItemEntityList =  cartItemRepository.findByUserUid(userId);
        if(optionalCartItemEntityList.isEmpty()){
            throw new ProductNotFoundException("No item in cart.");
        }
        return optionalCartItemEntityList.get();
    }




}
