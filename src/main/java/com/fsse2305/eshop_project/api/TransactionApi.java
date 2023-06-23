package com.fsse2305.eshop_project.api;

import com.fsse2305.eshop_project.data.SuccessResponseDto;
import com.fsse2305.eshop_project.data.transaction.domainObject.TransactionDetailsData;
import com.fsse2305.eshop_project.data.transaction.dto.TransactionResponseDto;
import com.fsse2305.eshop_project.data.user.domainObject.FirebaseUserData;
import com.fsse2305.eshop_project.exception.TransactionNotAllowException;
import com.fsse2305.eshop_project.service.TransactionService;
import com.fsse2305.eshop_project.utility.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationToken;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/{tid}")
    public TransactionResponseDto getTransactionDetails(JwtAuthenticationToken jwtToken, @PathVariable Integer tid){
        FirebaseUserData firebaseUserData = JwtUtil.getFirebaseUserData(jwtToken);
        return new TransactionResponseDto(transactionService.getTransactionById(firebaseUserData,tid));

    }

    @PatchMapping("/{tid}/pay")
    public SuccessResponseDto updateTransactionStatus(JwtAuthenticationToken jwtToken, @PathVariable Integer tid){
        FirebaseUserData firebaseUserData = JwtUtil.getFirebaseUserData(jwtToken);
        if(transactionService.updateTransactionStatus(firebaseUserData,tid)){
            return new SuccessResponseDto();
        } else {
            throw new TransactionNotAllowException("Cannot update transaction status");
        }
    }



}
