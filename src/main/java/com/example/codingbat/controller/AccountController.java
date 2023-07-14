package com.example.codingbat.controller;

import com.example.codingbat.dto.AccountDto;
import com.example.codingbat.dto.ApiResponse;
import com.example.codingbat.entity.Account;
import com.example.codingbat.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/account")
public class AccountController {

    @Autowired
    AccountService accountService;

    @GetMapping
    public List<Account> accountList(){
        return accountService.accountList();
    }

    @PostMapping
    public ApiResponse addAccount(@RequestBody AccountDto accountDto){
        return accountService.addAccount(accountDto);
    }

    @PutMapping("/{id}")
    public ApiResponse updateAccount(@PathVariable Integer id, @RequestBody AccountDto accountDto){
        return accountService.updateAccount(id, accountDto);
    }

    @DeleteMapping("/{id}")
    public ApiResponse deleteAccount(@PathVariable Integer id){
        return accountService.deleteAccount(id);
    }


}
