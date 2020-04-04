package com.targettech.springboot.crud.billionairslist.controller;

import com.targettech.springboot.crud.billionairslist.entities.Billionair;
import com.targettech.springboot.crud.billionairslist.repositories.BillionairRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
@Controller
public class BillionairContoller {

    private final BillionairRepository billionairRepository;

    @Autowired
    public BillionairContoller(BillionairRepository billionairRepository) {
        this.billionairRepository = billionairRepository;
    }

    @GetMapping("/")
    public String showBillionair(Model model){
        model.addAttribute("billionairs", billionairRepository.findAll(Sort.by(Sort.Direction.DESC,"networth")));
        return "index";
    }

    @GetMapping("/addBillionair" )
        public String showAddBillionairForm(Billionair billionair){return "add-billionair";}

    @PostMapping("/addBillionair")
    public String addBillionair(@Valid Billionair billionair, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "add-billionair";
        }

        billionairRepository.save(billionair);
        model.addAttribute("billionairs", billionairRepository.findAll(Sort.by(Sort.Direction.DESC,"networth")));
        return "index";
    }

    @GetMapping("/updateBillionair/{id}")
    public String showUpdateBillionairForm(@PathVariable("id") long id, Model model) {
        Billionair billionair = billionairRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid Billionair Id:" + id));
        model.addAttribute("billionair", billionair);
        return "update-billionair";
    }

    @PostMapping("/updateBillionair/{id}")
    public String updateBillionair(@PathVariable("id") long id, @Valid Billionair billionair, BindingResult result, Model model) {
        if (result.hasErrors()) {
            billionair.setId(id);
            return "update-billionair";
        }
        billionairRepository.save(billionair);
        model.addAttribute("billionairs", billionairRepository.findAll(Sort.by(Sort.Direction.DESC,"networth")));
        return "index";
    }

    @GetMapping("/deleteBillionair/{id}")
    public String deleteBillionair(@PathVariable("id") long id, Model model) {
        Billionair billionair = billionairRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid billionair Id:" + id));
        billionairRepository.delete(billionair);
        model.addAttribute("billionairs", billionairRepository.findAll(Sort.by(Sort.Direction.DESC,"networth")));
        return "index";
    }
}


