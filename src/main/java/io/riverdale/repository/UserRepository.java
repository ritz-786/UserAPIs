package io.riverdale.repository;

import io.riverdale.models.UserDetail;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends CrudRepository<UserDetail, Long> {

    @Query("select u from UserDetail u where u.pan = :pan")
    Optional<UserDetail> findByPan(@Param("pan") String pan);
}