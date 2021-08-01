package io.riverdale.service;

import io.riverdale.dto.AddUserDetailsDTO;
import io.riverdale.models.RemovedResponse;
import io.riverdale.models.UserDetail;

import java.util.concurrent.CompletableFuture;

public interface UserDetailService {
    UserDetail addPeople(AddUserDetailsDTO userDetailsDTO);

    UserDetail getUserDetail(Long id);

    RemovedResponse deleteUserDetail(Long userDetailId);

    CompletableFuture<String> getAsyncValue();
}
