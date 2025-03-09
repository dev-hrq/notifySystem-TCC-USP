package com.phrq.notifyback.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import lombok.Data;
import java.time.LocalDateTime;
import org.bson.types.ObjectId;

@Data
@Document(collection = "messages")
public class MessageEntity {
    @Id
    private ObjectId id;
    private String mensagem;
    private boolean lembrarRemetente;
    private LocalDateTime dataLembrete;
    private LocalDateTime dataEvento;

    // Constructors, getters, and setters are handled by Lombok @Data
}