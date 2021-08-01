package io.riverdale.service;

import io.riverdale.dto.AddBankDetailsDTO;
import io.riverdale.models.BankDetail;
import io.riverdale.models.RemovedResponse;

public interface BankDetailService {
    BankDetail addBankDetail(AddBankDetailsDTO addBankDetailsDTO);

     RemovedResponse deleteBankDetail(Long bankDetailId);

    BankDetail findBankById(Long bankId);
}
