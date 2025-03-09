package com.phrq.notifyback.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import com.phrq.notifyback.model.Message;

@Repository
public interface MessageRepository extends MongoRepository<Message, String> {
    // Métodos personalizados podem ser adicionados aqui
}