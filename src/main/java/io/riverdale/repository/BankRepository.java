package io.riverdale.repository;

import io.riverdale.models.BankDetail;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BankRepository extends CrudRepository<BankDetail,Long> {
}
