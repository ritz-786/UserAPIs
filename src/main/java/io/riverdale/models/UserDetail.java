package io.riverdale.models;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import io.riverdale.enums.Gender;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "user_details")
@Builder
public class UserDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull
    private String name;

    @NotNull
    private String lastName;

    @DateTimeFormat(style = "yyyy-mm-dd")
    @Temporal(TemporalType.DATE)
    private Date dob;


    @Enumerated(EnumType.STRING)
    private Gender gender;


    @Column(unique = true)
    @NotNull
    private String pan;

    private String address;

    @OneToMany(
            mappedBy = "userDetail",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    @JsonManagedReference
    private List<BankDetail> bankDetails = new ArrayList<>();

    public UserDetail(String name, String lastName, Date dob, Gender gender, String pan, String address) {
        this.name = name;
        this.lastName = lastName;
        this.dob = dob;
        this.gender = gender;
        this.pan = pan;
        this.address = address;
    }

    public UserDetail(String name, String lastName, Date dob, Gender gender, String pan, String address, List<BankDetail> bankDetails) {
        this.name = name;
        this.lastName = lastName;
        this.dob = dob;
        this.gender = gender;
        this.pan = pan;
        this.address = address;
        this.bankDetails = bankDetails;
    }
}
