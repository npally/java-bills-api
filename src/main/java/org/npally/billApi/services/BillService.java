package org.npally.billApi.services;

import org.npally.billApi.models.Bill;
import org.npally.billApi.repository.BillRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BillService {

    @Autowired
    private BillRepository billRepository;

    public List<Bill> getAllBills() {
        List<Bill> bills = new ArrayList<>();
        billRepository.findAll().forEach(bills::add);
        return bills;
    }

    public Bill getBill(long id) {
        return billRepository.findById(id).orElse(null);
    }

    public void addBill(Bill bill) {
        billRepository.save(bill);
    }

    public void updateBill(long id, Bill newBill) {
        Bill oldBill = billRepository.findById(id).orElse(null);
        oldBill.setTitle(newBill.getTitle());
        oldBill.setDescription(newBill.getDescription());
        oldBill.setAmount(newBill.getAmount());
        oldBill.setCategory(newBill.getCategory());
        billRepository.save(oldBill);
    }

    public void deleteBill(long id) {
        billRepository.deleteById(id);
    }
}
