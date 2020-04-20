package com.targettech.springboot.crud.billionairslist.repositories;

import com.targettech.springboot.crud.billionairslist.entities.Billionair;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface BillionairRepository extends CrudRepository<Billionair, Long> {
    public List<Billionair> findAll(Sort sort);
}
