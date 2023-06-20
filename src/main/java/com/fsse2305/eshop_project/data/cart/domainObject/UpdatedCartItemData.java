package com.fsse2305.eshop_project.data.cart.domainObject;

import com.fsse2305.eshop_project.data.Status;

public class UpdatedCartItemData {
    private Status status;

    public UpdatedCartItemData(Status status) {
        this.status = status;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}
