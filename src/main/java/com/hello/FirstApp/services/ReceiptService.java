package com.hello.FirstApp.services;

import com.hello.FirstApp.modals.Receipt;
import com.hello.FirstApp.repos.ReceiptRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReceiptService {
    @Autowired
    private ReceiptRepo receipt_repo;

    public boolean createReceipt(Receipt receipt){
        receipt_repo.save(receipt);
        return true;
    }

    public List<Receipt> readAllReceipts(){
        return (List<Receipt>) receipt_repo.findAll();
    }

    public Optional<Receipt> readReceipt(int id){
        return receipt_repo.findById(id);
    }

    public boolean updateReceipt(Receipt receipt){
        createReceipt(receipt);
        return true;
    }

    public boolean deleteReceipt(int id){
        receipt_repo.deleteById(id);
        return true;
    }
}
