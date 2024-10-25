package com.example.demo.service.impl;

import com.example.demo.model.Topics;
import com.example.demo.repository.TopicsRepository;
import com.example.demo.service.ITopicsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TopicsServiceImpl implements ITopicsService {

    @Autowired
    private TopicsRepository topicsRepository;

    @Override
    public List<Topics> getAllTopics() {
        return topicsRepository.findAll();
    }

    @Override
    public Topics getTopicByID(Long id) {
        return topicsRepository.findById(id).orElseThrow();
    }

    @Override
    public Topics createTopic(Topics subject) {
        return topicsRepository.save(subject);
    }

    @Override
    public Topics updateTopic(Long id, Topics subject) {
        Topics topic = topicsRepository.findById(id).orElseThrow();
        topic.setTopicsCode(subject.getTopicsCode());
        topic.setTopicsName(subject.getTopicsName());
        topic.setTheoryHours(subject.getTheoryHours());
        topic.setPracticalHours(subject.getPracticalHours());
        topic.setActive(subject.getActive());
        topic.setOriginalPrice(subject.getOriginalPrice());
        topic.setPromotionalPrice(subject.getPromotionalPrice());
        return topicsRepository.save(topic);
    }

    @Override
    public void deleteTopic(Long id) {
        topicsRepository.deleteById(id);
    }
}