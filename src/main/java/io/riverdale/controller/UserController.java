package io.riverdale.controller;

import io.riverdale.dto.AddBankDetailsDTO;
import io.riverdale.dto.AddUserDetailsDTO;
import io.riverdale.models.BankDetail;
import io.riverdale.models.RemovedResponse;
import io.riverdale.models.UserDetail;
import io.riverdale.service.BankDetailService;
import io.riverdale.service.UserDetailService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.CompletableFuture;

@RestController
@RequestMapping("/api/user")
@Slf4j
public class UserController {

    @Autowired
    UserDetailService userDetailService;

    @Autowired
    BankDetailService bankDetailService;

    @PostMapping("/add_people")
    public UserDetail addPeople(@RequestBody AddUserDetailsDTO userDetailsDTO) {
        return userDetailService.addPeople(userDetailsDTO);
    }

    @PostMapping("/add_bank")
    public BankDetail addBankDetail(@RequestBody AddBankDetailsDTO addBankDetailsDTO) {
        return bankDetailService.addBankDetail(addBankDetailsDTO);
    }

    @PostMapping("/delete_bank/{id}")
    public RemovedResponse deleteBankDetail(@PathVariable("id") Long bankDetailId){
        return bankDetailService.deleteBankDetail(bankDetailId);
    }

    @GetMapping("/get_bank/{id}")
    public BankDetail getBankDetail(@PathVariable("id") Long bankId){
        return bankDetailService.findBankById(bankId);
    }

    @PostMapping("/delete_user/{id}")
    public RemovedResponse deleteUserDetail(@PathVariable("id") Long userDetailId){
        return userDetailService.deleteUserDetail(userDetailId);
    }

    @GetMapping("/{id}")
    public UserDetail getUserDetail(@PathVariable("id") Long id) {
        return userDetailService.getUserDetail(id);
    }

    @GetMapping("/async")
    public CompletableFuture<String> getAsyncValue(){
        return userDetailService.getAsyncValue();
    }

    @GetMapping("/async2")
    public CompletableFuture<String> getAsyncValue2(){
        return userDetailService.getAsyncValue();
    }
}
