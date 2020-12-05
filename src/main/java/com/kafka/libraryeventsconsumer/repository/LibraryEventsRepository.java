package com.kafka.libraryeventsconsumer.repository;

import com.kafka.libraryeventsconsumer.entity.LibraryEvent;
import org.springframework.data.repository.CrudRepository;

public interface LibraryEventsRepository extends CrudRepository<LibraryEvent, Integer> {

}
