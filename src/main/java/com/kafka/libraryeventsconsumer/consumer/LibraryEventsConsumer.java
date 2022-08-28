package com.kafka.libraryeventsconsumer.consumer;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.kafka.libraryeventsconsumer.service.LibraryEventsService;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.RecoverableDataAccessException;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class LibraryEventsConsumer {

    @Autowired
    private LibraryEventsService libraryEventsService;

//    @KafkaListener(topics = "ala20partition")
//    public void receive(ConsumerRecord<?, ?> consumerRecord,
//                        Acknowledgment acknowledgment) throws InterruptedException {
//        acknowledgment.acknowledge();
//
//        wait(5000);
//        System.out.println("Received message: ");
//        System.out.println(consumerRecord.value().toString());
//        log.info("message number:: {} processed - partition::{} - msg = {} ", consumerRecord.key(), consumerRecord.partition(), consumerRecord.value());
//
//
//    }
    @KafkaListener(topics = {"testTopic7777"}, concurrency = "8")
    public void onMessage(ConsumerRecord<Integer, String> consumerRecord) throws InterruptedException {
        log.info("message number:: {} processed - partition::{} - msg = {} ", consumerRecord.key(), consumerRecord.partition(), consumerRecord.value());
        Thread.sleep(4_000);
    }
}
