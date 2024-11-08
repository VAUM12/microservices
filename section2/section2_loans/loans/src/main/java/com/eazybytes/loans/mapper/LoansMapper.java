package com.eazybytes.loans.mapper;

import com.eazybytes.loans.dto.LoansDto;
import com.eazybytes.loans.entity.Loans;

public class LoansMapper {
    public static Loans loansDtoToLoans(Loans loans, LoansDto loansDto) {
        loans.setLoanNumber(loansDto.getLoanNumber());
        loans.setLoanType(loansDto.getLoanType());
        loans.setMobileNumber(loansDto.getMobileNumber());
        loans.setTotalLoan(loansDto.getTotalLoan());
        loans.setAmountPaid(loansDto.getAmountPaid());
        loans.setOutstandingAmount(loansDto.getOutstandingAmount());
        return loans;
    }

    public static LoansDto loansToLoansDto(Loans loans,LoansDto loansDto) {
        loansDto.setLoanType(loans.getLoanType());
        loansDto.setLoanNumber(loans.getLoanNumber());
        loansDto.setAmountPaid(loans.getAmountPaid());
        loansDto.setOutstandingAmount(loans.getOutstandingAmount());
        loansDto.setTotalLoan(loans.getTotalLoan());
        loansDto.setMobileNumber(loans.getMobileNumber());
        return loansDto;
    }
}
