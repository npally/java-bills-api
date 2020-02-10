package org.npally.billApi.controller;

import org.npally.billApi.models.Bill;
import org.npally.billApi.services.BillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BillController {

    @Autowired
    private BillService billService;

    @RequestMapping("/bills")
    public List<Bill> getAllBills() {
        return billService.getAllBills();
    }

    @RequestMapping(method = RequestMethod.POST, value="/bills")
    public List<Bill> addBill(@RequestBody Bill bill) {
        billService.addBill(bill);
        return billService.getAllBills();
    }

    @RequestMapping("/bills/{id}")
    public Bill getBill(@PathVariable long  id) {
        return billService.getBill(id);
    }

    @RequestMapping(method = RequestMethod.PUT, value="bills/{id}")
    public void updateBill(@RequestBody Bill bill, @PathVariable long id) {
        billService.updateBill(id, bill);
    }

    @RequestMapping(method = RequestMethod.DELETE, value="bills/{id}")
    public void deleteBill(@PathVariable long id) {
        billService.deleteBill(id);
    }
}
