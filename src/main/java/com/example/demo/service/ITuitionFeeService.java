package com.example.demo.service;

import com.example.demo.model.TuitionFee;

import java.util.List;

public interface ITuitionFeeService {

    public List<TuitionFee> getAllTuitionFee();
    public TuitionFee getTuitionFeeById(Long id);
    public TuitionFee createTuitionFee(TuitionFee tuitionFee);
    public TuitionFee updateTuitionFee(Long id, TuitionFee tuitionFee);
    public void deleteTuitionFee(Long id);
}
