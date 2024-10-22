package com.easybytes.accounts.service.impl;

import com.easybytes.accounts.dto.AccountsDto;
import com.easybytes.accounts.dto.CustomerDto;
import com.easybytes.accounts.entity.Accounts;
import com.easybytes.accounts.entity.Customer;
import com.easybytes.accounts.exception.CustomerAlreadyExistsException;
import com.easybytes.accounts.exception.ResourceNotFoundException;
import com.easybytes.accounts.mapper.AccountsMapper;
import com.easybytes.accounts.mapper.CustomerMapper;
import com.easybytes.accounts.repository.AccountsRepository;
import com.easybytes.accounts.repository.CustomerRepository;
import com.easybytes.accounts.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Random;

@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountsRepository accountsRepository;

    @Autowired
    private CustomerRepository customerRepository;

    /**
     * @param customerDto - CustomerDto object
     */
    @Override
    public void createAccount(CustomerDto customerDto) {

        Customer customer= CustomerMapper.customerDtoToCustomer(customerDto,new Customer());
        Optional<Customer> optionalCustomer=customerRepository.findByMobileNumber(customerDto.getMobileNumber());
        if(optionalCustomer.isPresent()){
            throw new CustomerAlreadyExistsException("Customer Already Exists"+customerDto.getMobileNumber());
        }
        Customer savedCustomer=customerRepository.save(customer);
        accountsRepository.save(createNewAccount(savedCustomer));
    }

    @Override
    public CustomerDto fetchAccount(String mobileNumber) {
        Customer customer = customerRepository.findByMobileNumber(mobileNumber).orElseThrow(
                () -> new ResourceNotFoundException("Customer", "mobileNumber", mobileNumber)
        );
        Accounts accounts = accountsRepository.findByCustomerId(customer.getCustomerId()).orElseThrow(
                () -> new ResourceNotFoundException("Account", "customerId", customer.getCustomerId().toString())
        );
        CustomerDto customerDto = CustomerMapper.customerToCustomerDto(customer, new CustomerDto());
        customerDto.setAccountsDto(AccountsMapper.accountsToAccountsDto(accounts, new AccountsDto()));
        return customerDto;
    }

    @Override
    public boolean updateAccount(CustomerDto customerDto) {
        boolean isUpdated = false;
        AccountsDto accountsDto = customerDto.getAccountsDto();
        if(accountsDto !=null ){
            Accounts accounts = accountsRepository.findById(accountsDto.getAccountNumber()).orElseThrow(
                    () -> new ResourceNotFoundException("Account", "AccountNumber", accountsDto.getAccountNumber().toString())
            );
            AccountsMapper.accountsDtoToAccounts(accountsDto, accounts);
            accounts = accountsRepository.save(accounts);

            Long customerId = accounts.getCustomerId();
            Customer customer = customerRepository.findById(customerId).orElseThrow(
                    () -> new ResourceNotFoundException("Customer", "CustomerID", customerId.toString())
            );
            CustomerMapper.customerDtoToCustomer(customerDto,customer);
            customerRepository.save(customer);
            isUpdated = true;
        }
        return  isUpdated;
    }

    private Accounts createNewAccount(Customer customer) {
        Accounts account = new Accounts();
        account.setCustomerId(customer.getCustomerId());
        long randomAccNumber=1000000000L+ new Random().nextInt(900000000);
        account.setAccountNumber(randomAccNumber);
        account.setAccountType("Savings");
        return account;
    }
}
