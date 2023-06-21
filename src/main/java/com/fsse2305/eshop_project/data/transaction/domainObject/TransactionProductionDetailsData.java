package com.fsse2305.eshop_project.data.transaction.domainObject;

import com.fsse2305.eshop_project.data.Status;
import com.fsse2305.eshop_project.data.user.entity.UserEntity;

import java.math.BigDecimal;
import java.sql.Timestamp;

public class TransactionProductionDetailsData {
    private UserEntity user;
    private Timestamp datatime;
    private Status status;
    private BigDecimal total;


}
