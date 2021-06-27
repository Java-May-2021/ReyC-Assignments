package com.reymer.events.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.reymer.events.models.Message;

@Repository
public interface MessageRepository extends CrudRepository<Message, Long> {

}
