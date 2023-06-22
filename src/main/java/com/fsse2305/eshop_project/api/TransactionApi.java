package com.fsse2305.eshop_project.api;

import com.fsse2305.eshop_project.data.transaction.domainObject.TransactionDetailsData;
import com.fsse2305.eshop_project.data.transaction.dto.TransactionResponseDto;
import com.fsse2305.eshop_project.data.user.domainObject.FirebaseUserData;
import com.fsse2305.eshop_project.service.TransactionService;
import com.fsse2305.eshop_project.utility.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("transaction")
public class TransactionApi {

    private final TransactionService transactionService;
    @Autowired
    public TransactionApi(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    @PostMapping("/prepare")
    public TransactionResponseDto createTransaction(JwtAuthenticationToken jwtToken){
        FirebaseUserData firebaseUserData = JwtUtil.getFirebaseUserData(jwtToken);
        TransactionDetailsData createTransactionDetailsData =  transactionService.createTransaction(firebaseUserData);
        TransactionResponseDto createTransactionResponseDto = new TransactionResponseDto(createTransactionDetailsData);
        return createTransactionResponseDto;

    }



}
