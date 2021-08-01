package io.riverdale.service;

import io.riverdale.enums.Gender;
import io.riverdale.exceptions.UserNotFoundException;
import io.riverdale.models.UserDetail;
import io.riverdale.repository.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
class UserDetailServiceTest {

    @Autowired
    private UserDetailService userDetailService;

    @MockBean
    private UserRepository userRepository;

    @BeforeEach
    void setUp() {
        UserDetail userDetail = UserDetail.builder()
                .id(1L)
                .address("Patna")
                .gender(Gender.MALE)
                .name("Riya")
                .lastName("Shastri")
                .build();

        Optional<UserDetail> optionalUserDetail = Optional.of(userDetail);

        Mockito.when(userRepository.findById(1L))
                .thenReturn(optionalUserDetail);

        Mockito.when(userRepository.findById(2L))
                .thenThrow(UserNotFoundException.class);
    }

    @Test
    @DisplayName("Testing the getting of userDetail")
    void getUserDetail() {
        Long userId = 1L;
        UserDetail user = userDetailService.getUserDetail(userId);
        assertEquals(userId, user.getId());
    }

    @Test
    @DisplayName("Testing the user when userId not present")
    void getUserDetailWhenNoUserPresent() {
        Long userId = 2L;
        assertThrows(UserNotFoundException.class, () -> {
            userDetailService.getUserDetail(userId);
        });
    }
}