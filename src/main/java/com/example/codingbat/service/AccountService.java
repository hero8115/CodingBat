package com.example.codingbat.service;

import com.example.codingbat.dto.AccountDto;
import com.example.codingbat.dto.ApiResponse;
import com.example.codingbat.entity.Account;
import com.example.codingbat.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AccountService {

    @Autowired
    AccountRepository accountRepository;


    public List<Account> accountList(){
        return accountRepository.findAll();
    }

    public ApiResponse addAccount(AccountDto accountDto){
        boolean existsByEmail = accountRepository.existsByEmail(accountDto.getEmail());
        if (existsByEmail){
            return new ApiResponse("Bunday emaildan account ochilgan bo'lishi mumkin", false);
        }
        Account account = new Account();
        account.setEmail(accountDto.getEmail());
        account.setPassword(accountDto.getPassword());
        accountRepository.save(account);
        return new ApiResponse("Ro'yxatdan o'tildi", true);
    }

    public ApiResponse updateAccount(Integer id, AccountDto accountDto){
        Optional<Account> byId = accountRepository.findById(id);
        if (byId.isPresent()){
            Account account = byId.get();
            account.setEmail(accountDto.getEmail());
            account.setPassword(accountDto.getPassword());
            accountRepository.save(account);
            return new ApiResponse("Malumotlar o'zgartirildi", true);
        }
        return new ApiResponse("Bunday Id lik mijoz ro'yxatdan o'tmagan", false);
    }

    public ApiResponse deleteAccount(Integer id) {
        boolean existsById = accountRepository.existsById(id);
        if (existsById){
            accountRepository.deleteById(id);
            return new ApiResponse("Account o'chirildi", true);
        }
        return new ApiResponse("Bunday Id lik account topilmadi", false);
    }
}
