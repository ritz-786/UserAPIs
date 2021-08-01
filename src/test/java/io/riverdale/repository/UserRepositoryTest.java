package io.riverdale.repository;

import io.riverdale.enums.Gender;
import io.riverdale.models.UserDetail;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import javax.swing.text.html.Option;
import java.util.Calendar;
import java.util.Date;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class  UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private TestEntityManager entityManager;

    @BeforeEach
    void setup(){
        UserDetail userDetail = UserDetail.builder()
                .address("Patna,Bihar")
                .dob(new Date(new Date().getYear(), Calendar.OCTOBER, 15))
                .lastName("Sanghi")
                .name("Sanjana")
                .pan("DQHPRS")
                .gender(Gender.FEMALE)
                .build();

        entityManager.persist(userDetail);
    }

    @Test
    public void createUserDetailTest(){
        Optional<UserDetail> userDetail = userRepository.findById(1L);
        System.out.println(userDetail);
        assertEquals(userDetail.get().getName(),"Sanjana");
    }
}