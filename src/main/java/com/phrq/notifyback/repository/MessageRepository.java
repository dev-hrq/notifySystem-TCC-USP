package com.phrq.notifyback.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import com.phrq.notifyback.model.Message;
import java.util.List;

@Repository
public interface MessageRepository extends MongoRepository<Message, String> {
    List<Message> findByRemetente(String remetente);
    List<Message> findByDestinatario(String destinatario);
}