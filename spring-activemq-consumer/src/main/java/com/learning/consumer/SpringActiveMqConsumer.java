package com.learning.consumer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
@EnableJms
public class SpringActiveMqConsumer {

    private final Logger logger = LoggerFactory.getLogger(SpringActiveMqConsumer.class);

    @JmsListener(destination = "test")
    public void listener(String message) {
        logger.info("Received message: {}", message);
    }
}
