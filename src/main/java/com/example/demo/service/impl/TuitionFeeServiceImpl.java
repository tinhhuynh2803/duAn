package com.example.demo.service.impl;

import com.example.demo.model.TuitionFee;
import com.example.demo.repository.TuitionFeeRepository;
import com.example.demo.service.ITuitionFeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TuitionFeeServiceImpl implements ITuitionFeeService {

    @Autowired
    private TuitionFeeRepository tuitionFeeRepository;

    @Override
    public List<TuitionFee> getAllTuitionFee() {
        return tuitionFeeRepository.findAll();
    }

    @Override
    public TuitionFee getTuitionFeeById(Long id) {
        return tuitionFeeRepository.findById(id).orElseThrow();
    }

    @Override
    public TuitionFee createTuitionFee(TuitionFee tuitionFee) {
        return tuitionFeeRepository.save(tuitionFee);
    }

    @Override
    public TuitionFee updateTuitionFee(Long id, TuitionFee tuitionFee) {
        TuitionFee existingTuitionFee = tuitionFeeRepository.findById(id).orElseThrow();
        existingTuitionFee.setRegistrationDate(tuitionFee.getRegistrationDate());
        existingTuitionFee.setCollectionDate(tuitionFee.getCollectionDate());
        existingTuitionFee.setNote(tuitionFee.getNote());
        existingTuitionFee.setCollectedMoney(tuitionFee.getCollectedMoney());
        existingTuitionFee.setActivate(tuitionFee.getActivate());
        return tuitionFeeRepository.save(existingTuitionFee);
    }

    @Override
    public void deleteTuitionFee(Long id) {
        tuitionFeeRepository.deleteById(id);
    }
}
