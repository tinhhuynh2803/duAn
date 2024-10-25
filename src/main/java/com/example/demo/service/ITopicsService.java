package com.example.demo.service;

import com.example.demo.model.Topics;

import java.util.List;

public interface ITopicsService {

    public List<Topics> getAllTopics();
    public Topics getTopicByID(Long id);
    public Topics createTopic(Topics subject);
    public Topics updateTopic(Long id, Topics subject);
    public void deleteTopic(Long id);
}