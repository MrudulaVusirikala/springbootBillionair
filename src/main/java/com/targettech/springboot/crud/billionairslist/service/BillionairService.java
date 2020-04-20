package com.targettech.springboot.crud.billionairslist.service;

import com.targettech.springboot.crud.billionairslist.entities.Billionair;
import com.targettech.springboot.crud.billionairslist.repositories.BillionairRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

       return billionairRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid Billionair Id:" + id));
    }
    // public Optional<Billionair> getFile(String fileId) {
    //    return billionairRepository.findById(fileId);
    // }

}
