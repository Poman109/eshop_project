package com.fsse2305.eshop_project.data.cart.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fsse2305.eshop_project.data.Status;
import com.fsse2305.eshop_project.data.cart.domainObject.DeletedCartItemData;

public class DeleteCartItemResponseDto {
    @JsonProperty("result")
    private Status status;

    public DeleteCartItemResponseDto(DeletedCartItemData deletedCartItemData) {
        this.status = deletedCartItemData.getStatus();
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}
