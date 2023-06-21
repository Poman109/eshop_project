package com.fsse2305.eshop_project.data.cart.domainObject;

import com.fsse2305.eshop_project.data.Status;

public class DeletedCartItemData {
    private Status status;

    public DeletedCartItemData(Status status) {
        this.status = status;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}
