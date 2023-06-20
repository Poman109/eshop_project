package com.fsse2305.eshop_project.data.cart.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fsse2305.eshop_project.data.Status;
import com.fsse2305.eshop_project.data.cart.domainObject.CartItemDetailsData;
import com.fsse2305.eshop_project.data.cart.domainObject.CreatedCartItemData;

public class CreateCartItemResponseDto {
    @JsonProperty("result")
    private Status status;

    public CreateCartItemResponseDto(CreatedCartItemData createdCartItemData){
        this.status = createdCartItemData.getStatus();
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}
