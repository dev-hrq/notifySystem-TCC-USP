package com.phrq.notifyback.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.index.Indexed;
import lombok.Data;
import java.time.LocalDateTime;

@Data
@Document(collection = "messages")
public class Message {
    @Id
    private String id;
    private String mensagem;
    @Indexed
    private String remetente;
    @Indexed
    private String destinatario;
    private boolean lembrarRemetente;
    private LocalDateTime dataLembrete;
    private LocalDateTime dataEvento;
} 