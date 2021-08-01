package io.riverdale.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AddBankDetailsDTO {
    private Long userId;
    private String accountNumber;
    private String ifsc;
}
