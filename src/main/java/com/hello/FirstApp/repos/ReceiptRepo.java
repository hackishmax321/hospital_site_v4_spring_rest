package com.hello.FirstApp.repos;

import com.hello.FirstApp.modals.Receipt;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReceiptRepo extends CrudRepository<Receipt, Integer> {
}
