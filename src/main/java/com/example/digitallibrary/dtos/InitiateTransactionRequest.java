package com.example.digitallibrary.dtos;

import com.example.digitallibrary.enums.TransactionType;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class InitiateTransactionRequest {

    @NotNull
    private String studentRollNumber;

    @NotNull
    private Integer bookId;

    @NotNull
    private TransactionType transactionType;

}
