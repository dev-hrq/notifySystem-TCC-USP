package com.phrq.notifyback.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import lombok.Data;
import java.time.LocalDateTime;

@Data
@Document(collection = "messages")
public class Message {
    @Id
    private String id;
    private String mensagem;
    private boolean lembrarRemetente;
    private LocalDateTime dataLembrete;
    private LocalDateTime dataEvento;
} 