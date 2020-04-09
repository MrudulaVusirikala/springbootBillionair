package com.targettech.springboot.crud.billionairslist.service;

import com.targettech.springboot.crud.billionairslist.entities.Billionair;
import com.targettech.springboot.crud.billionairslist.repositories.BillionairRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
@Service
public class BillionairService {

    private final BillionairRepository billionairRepository;

    @Autowired
    public BillionairService(BillionairRepository billionairRepository) {
        this.billionairRepository = billionairRepository;
    }
    public List<Billionair> sortedOutBillionairList(){
       return billionairRepository.findAll(Sort.by(Sort.Direction.DESC,"netWorth"));
    }
    public Billionair saveBillionair(Billionair billionair){

        return billionairRepository.save(billionair);
    }
    public void deleteBillionair(Billionair billionair){

        billionairRepository.delete(billionair);
    }
    public  Billionair findBillionairById(long id) {
       // if(billionairRepository.existsById(id)){
       //     return  billionairRepository.findById(id)
       // }
       return billionairRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid Billionair Id:" + id));
    }

}
