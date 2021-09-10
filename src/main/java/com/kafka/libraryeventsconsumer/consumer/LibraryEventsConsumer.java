package com.kafka.libraryeventsconsumer.consumer;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.kafka.libraryeventsconsumer.service.LibraryEventsService;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class LibraryEventsConsumer {

    @Autowired
    private LibraryEventsService libraryEventsService;


    @KafkaListener(topics = {"library3"}, concurrency = "8")
    public void onMessage(ConsumerRecord<Integer, String> consumerRecord) throws InterruptedException, JsonProcessingException {
        //log.info("message number:: {} processed - partition::{} - msg = {} ", consumerRecord.key(), consumerRecord.partition(), consumerRecord.value());
        Thread.sleep(100);

        libraryEventsService.processLibraryEvent(consumerRecord);
        log.info("library3 id {} Saved - Partition {}", consumerRecord.key(), consumerRecord.partition());
    }
}
