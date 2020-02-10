package org.npally.billApi.repository;

import org.npally.billApi.models.Bill;
import org.springframework.data.repository.CrudRepository;

public interface BillRepository extends CrudRepository<Bill, Long> {
}
