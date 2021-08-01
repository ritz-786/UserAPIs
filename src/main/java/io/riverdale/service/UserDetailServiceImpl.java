package io.riverdale.service;

import io.riverdale.dto.AddUserDetailsDTO;
import io.riverdale.exceptions.UserAlreadyPresentException;
import io.riverdale.exceptions.UserNotFoundException;
import io.riverdale.models.BankDetail;
import io.riverdale.models.RemovedResponse;
import io.riverdale.models.UserDetail;
import io.riverdale.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import lombok.var;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.atomic.AtomicInteger;

@Service
@Slf4j
public class UserDetailServiceImpl implements UserDetailService {

    @Autowired
    UserRepository userRepository;

    @Override
    public UserDetail addPeople(AddUserDetailsDTO userDetailsDTO) {
        Optional<UserDetail> checkExistingUser = userRepository.findByPan(userDetailsDTO.getPan());
        if(checkExistingUser.isPresent())
            throw new UserAlreadyPresentException("User Already Present");

        UserDetail userDetail = new UserDetail();
        userDetail.setName(userDetailsDTO.getName());
        userDetail.setAddress(userDetailsDTO.getLastName());
        userDetail.setDob(userDetailsDTO.getDob());
        userDetail.setGender(userDetailsDTO.getGender());
        userDetail.setBankDetails(userDetailsDTO.getBankDetails());
        userDetail.setPan(userDetailsDTO.getPan());
        userDetail.setLastName(userDetailsDTO.getLastName());

        for (BankDetail bankDetail : userDetail.getBankDetails()) {
            bankDetail.setUserDetail(userDetail);
        }

        return userRepository.save(userDetail);
    }

    @Override
    public UserDetail getUserDetail(Long id) {
        Optional<UserDetail> userDetail = userRepository.findById(id);
        if(!userDetail.isPresent())
            throw new UserNotFoundException("User Not Found");
        return userDetail.get();
    }

    @Override
    public RemovedResponse deleteUserDetail(Long userDetailId) {
        userRepository.deleteById(userDetailId);
        return new RemovedResponse("Bank Deleted",true);
    }

    @Override
    @Async
    public CompletableFuture<String> getAsyncValue(){
        log.info("Received request");
        Map<Integer,String> m = new HashMap<>();
        m.put(0,"Ritik");
        m.put(1,"Robert");
        Map<Integer,String> m1 = m;
        CompletableFuture<String> future = CompletableFuture
                .supplyAsync(() -> {
                    String s = m1.get(0);
                    return processRequest(s);
                })
                .thenApply(x -> x.concat("ds"));
        m.put(0,"Raining");
        log.info("inside getAsync {}",m.get(0));
        m.clear();
        return future;
    }

    private String processRequest(String s) {
        Long delayTime = 10000L;
        log.info("Start processing request");
        try {
            Thread.sleep(delayTime);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        log.info("Completed processing request {}",s);
        return "Processing done after " + delayTime + s;
    }

    @Async
    private void fun(String s){
        try{
            Thread.sleep(10000L);
        }catch (InterruptedException e){
            throw new RuntimeException(e);
        }
        log.info("reached , {}",s);
    }
}
