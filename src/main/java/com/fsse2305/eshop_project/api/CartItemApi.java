package com.fsse2305.eshop_project.api;

import com.fsse2305.eshop_project.data.cart.domainObject.CartItemDetailsData;
import com.fsse2305.eshop_project.data.cart.domainObject.CreatedCartItemData;
import com.fsse2305.eshop_project.data.cart.dto.CartItemDetailResponseDto;
import com.fsse2305.eshop_project.data.cart.dto.CreateCartItemResponseDto;
import com.fsse2305.eshop_project.data.cart.dto.UpdateCartItemResponseDto;
import com.fsse2305.eshop_project.data.user.domainObject.FirebaseUserData;
import com.fsse2305.eshop_project.service.CartItemService;
import com.fsse2305.eshop_project.utility.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationToken;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/cart")
public class CartItemApi {

    private final CartItemService cartItemService;
    @Autowired
    public CartItemApi(CartItemService cartItemService) {
        this.cartItemService = cartItemService;
    }


    @PutMapping("/{pid}/{quantity}")
    public CreateCartItemResponseDto putCartItem(JwtAuthenticationToken jwtToken, @PathVariable Integer pid, @PathVariable Integer quantity){
        FirebaseUserData firebaseUserData = JwtUtil.getFirebaseUserData(jwtToken);
        return new CreateCartItemResponseDto(cartItemService.putCartItem(firebaseUserData,pid,quantity));

    }

    @GetMapping()
    public List<CartItemDetailResponseDto> getCartItem(JwtAuthenticationToken jwtToken){
        FirebaseUserData firebaseUserData = JwtUtil.getFirebaseUserData(jwtToken);
        List<CartItemDetailResponseDto> cartItemDetailResponseArray = new ArrayList<>();
        for(CartItemDetailsData cartItemDetailsData: cartItemService.getUserCart(firebaseUserData)){
            cartItemDetailResponseArray.add(new CartItemDetailResponseDto(cartItemDetailsData));
        }
        return cartItemDetailResponseArray;
    }

    @PatchMapping("/{pid}/{quantity}")
    public UpdateCartItemResponseDto updateCartItemQuantity(JwtAuthenticationToken jwtToken, @PathVariable Integer pid, @PathVariable Integer quantity) {
        FirebaseUserData firebaseUserData = JwtUtil.getFirebaseUserData(jwtToken);

        return new UpdateCartItemResponseDto(cartItemService.updateCartItemQuantity(firebaseUserData,pid,quantity));
    }



}
