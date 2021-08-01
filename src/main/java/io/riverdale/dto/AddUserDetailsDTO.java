package io.riverdale.dto;

import io.riverdale.enums.Gender;
import io.riverdale.models.BankDetail;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
public class AddUserDetailsDTO {

    private String name;
    private String lastName;
    private Date dob;
    private Gender gender;
    private String pan;
    private String address;
    private List<BankDetail> bankDetails = new ArrayList<>();

    public AddUserDetailsDTO(String name, String lastName, Date dob, Gender gender, String pan, String address) {
        this.name = name;
        this.lastName = lastName;
        this.dob = dob;
        this.gender = gender;
        this.pan = pan;
        this.address = address;
    }

    public AddUserDetailsDTO(String name, String lastName, Date dob, Gender gender, String pan, String address, List<BankDetail> bankDetails) {
        this.name = name;
        this.lastName = lastName;
        this.dob = dob;
        this.gender = gender;
        this.pan = pan;
        this.address = address;
        this.bankDetails = bankDetails;
    }
}

