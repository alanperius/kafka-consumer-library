package com.kafka.libraryeventsconsumer.consumer;

import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.listener.AcknowledgingMessageListener;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.stereotype.Component;

//DESCOMENTAR ISSO!
//@Component
@Slf4j
public class LibraryEventsConsumerManualOffSet implements AcknowledgingMessageListener<Integer, String> {

    @Override
    @KafkaListener(topics = {"library"})
    public void onMessage(ConsumerRecord<Integer, String> consumerRecord, Acknowledgment acknowledgment) {
        log.info("messagasdsadsad = {}", consumerRecord);
        //Manualmente setamos a msg como 'lida' e ela não vai ser mais consumida. è enviada direto ao offset. Esse é o modo MANUAL(AckMode.MANUAL)
        acknowledgment.acknowledge();
    }
}
