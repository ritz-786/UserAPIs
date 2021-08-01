package io.riverdale.service;

import io.riverdale.dto.AddBankDetailsDTO;
import io.riverdale.exceptions.UserNotFoundException;
import io.riverdale.models.BankDetail;
import io.riverdale.models.RemovedResponse;
import io.riverdale.models.UserDetail;
import io.riverdale.repository.BankRepository;
import io.riverdale.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BankDetailServiceImpl implements BankDetailService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    BankRepository bankRepository;

    @Override
    public BankDetail addBankDetail(AddBankDetailsDTO addBankDetailsDTO) {
        BankDetail bankDetail = new BankDetail();
        Long userId = addBankDetailsDTO.getUserId();
        Optional<UserDetail> oUserDetail = userRepository.findById(userId);
        if (oUserDetail.isPresent()) {
            bankDetail.setAccountNumber(addBankDetailsDTO.getAccountNumber());
            bankDetail.setIfsc(addBankDetailsDTO.getIfsc());
            bankDetail.setUserDetail(oUserDetail.get());
            return bankRepository.save(bankDetail);
        }
        throw new UserNotFoundException("No Such User Found, So Bank Account Can't Be Added");
    }

    @Override
    public RemovedResponse deleteBankDetail(Long bankDetailId) {
        bankRepository.deleteById(bankDetailId);
        return new RemovedResponse("Bank Deleted",true);
    }

    @Override
    public BankDetail findBankById(Long bankId) {
        Optional<BankDetail> bankDetail = bankRepository.findById(bankId);
        if(bankDetail.isPresent())
            return bankDetail.get();
        throw new UserNotFoundException("No such bankAccount");
    }
}
