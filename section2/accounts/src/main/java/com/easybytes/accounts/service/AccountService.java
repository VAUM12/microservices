package com.easybytes.accounts.service;

import com.easybytes.accounts.dto.CustomerDto;
import jakarta.validation.Valid;

public interface AccountService {

    /**
     *
     * @param customerDto- CustomerDto object
     */
    void createAccount(CustomerDto customerDto);

    CustomerDto fetchAccount(String mobileNumber);

    boolean updateAccount( CustomerDto customerDto);
    boolean deleteAccount(String mobileNumber);
}
