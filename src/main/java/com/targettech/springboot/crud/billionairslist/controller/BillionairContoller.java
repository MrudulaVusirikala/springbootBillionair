package com.targettech.springboot.crud.billionairslist.controller;

import com.targettech.springboot.crud.billionairslist.entities.Billionair;
import com.targettech.springboot.crud.billionairslist.service.BillionairService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
@Controller
public class BillionairContoller {

    private final BillionairService billionairService;

    @Autowired
    public BillionairContoller(BillionairService billionairService) {
        this.billionairService = billionairService;
    }

    @GetMapping("/")
    public String showBillionair(Model model){
        return loadBillionair(model);

    }

    @GetMapping("/addBillionair" )
        public String showAddBillionairForm(Billionair billionair){return "add-billionair";}

    @PostMapping("/addBillionair")
    public String addBillionair(@Valid Billionair billionair, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "add-billionair";
        }

       billionairService.saveBillionair(billionair);
        return loadBillionair(model);

    }

    @GetMapping("/updateBillionair/{id}")
    public String showUpdateBillionairForm(@PathVariable("id") long id, Model model) {
        Billionair billionair =billionairService.findBillionairById(id);
        model.addAttribute("billionair", billionair);
        return "update-billionair";
    }

    @PostMapping("/updateBillionair/{id}")
    public String updateBillionair(@PathVariable("id") long id, @Valid Billionair billionair, BindingResult result, Model model) {
        if (result.hasErrors()) {
            billionair.setId(id);
            return "update-billionair";
        }
        billionairService.saveBillionair(billionair);
        return loadBillionair(model);


    }

    @GetMapping("/deleteBillionair/{id}")
    public String deleteBillionair(@PathVariable("id") long id, Model model) {
        Billionair billionair = billionairService.findBillionairById(id);
        billionairService.deleteBillionair(billionair);
        return loadBillionair(model);


    }
    public String loadBillionair(Model model){
        model.addAttribute("billionairs", billionairService.sortedOutBillionairList());
        return "index";
    }
}


