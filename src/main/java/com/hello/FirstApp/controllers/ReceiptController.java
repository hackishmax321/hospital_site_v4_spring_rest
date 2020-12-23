package com.hello.FirstApp.controllers;

import com.hello.FirstApp.modals.Receipt;
import com.hello.FirstApp.services.ReceiptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.Optional;

@RequestMapping("api/receipts")
@RestController
public class ReceiptController {
    @Autowired
    private ReceiptService receipt_serve;

    @PostMapping
    public boolean postPatient(@Valid @NotNull @RequestBody Receipt receipt){
        receipt_serve.createReceipt(receipt);
        return true;
    }

    @GetMapping
    public List<Receipt> getAllReceipts(){
        return receipt_serve.readAllReceipts();
    }

    @GetMapping(path = "{id}")
    public Optional<Receipt> getReceipt(@PathVariable("id") int id){
        return receipt_serve.readReceipt(id);
    }

    @PutMapping(path = "{id}")
    public boolean putReceipt(@PathVariable("id") int id, @Valid @NotNull @RequestBody Receipt receipt){
        receipt.setCode(id);
        receipt_serve.updateReceipt(receipt);
        return true;
    }

    @DeleteMapping(path = "{id}")
    public boolean deleteReceipt(@PathVariable("id") int id){
        receipt_serve.deleteReceipt(id);
        return true;
    }
}
