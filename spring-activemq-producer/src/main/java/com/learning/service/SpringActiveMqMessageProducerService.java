package com.learning.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

import javax.jms.Queue;

@Service
public class SpringActiveMqMessageProducerService {

    private final Logger logger = LoggerFactory.getLogger(SpringActiveMqMessageProducerService.class);

    @Autowired
    private JmsTemplate jmsTemplate;

    @Autowired
    private Queue queue;

    public void publish(String message) {
        jmsTemplate.convertAndSend(queue, message);
    }
}
