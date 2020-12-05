package com.kafka.libraryeventsconsumer.consumer;

import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class LibraryEventsConsumer {

    @KafkaListener(topics = {"library"})
    public void onMessage(ConsumerRecord<Integer, String> consumerRecord) throws InterruptedException {
        log.info("message number:: {} processed - partition::{} - msg = {} ", consumerRecord.key(), consumerRecord.partition(), consumerRecord.value());
        Thread.sleep(100);
    }
}
