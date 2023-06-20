package com.fsse2305.eshop_project.data.cart.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fsse2305.eshop_project.data.Status;
import com.fsse2305.eshop_project.data.cart.domainObject.UpdatedCartItemData;

public class UpdateCartItemResponseDto {
    @JsonProperty("result")
    private Status status;

    public UpdateCartItemResponseDto(UpdatedCartItemData updatedCartItemData) {
        this.status = updatedCartItemData.getStatus();
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}
