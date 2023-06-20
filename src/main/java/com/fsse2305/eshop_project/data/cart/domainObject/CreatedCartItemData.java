package com.fsse2305.eshop_project.data.cart.domainObject;

import com.fsse2305.eshop_project.data.Status;

public class CreatedCartItemData {
    private Status status;

    public CreatedCartItemData(Status status) {
        this.status = status;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}
