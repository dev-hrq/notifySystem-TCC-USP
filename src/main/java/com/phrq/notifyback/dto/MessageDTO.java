package com.phrq.notifyback.dto;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class MessageDTO {
    private String id;  // ObjectId as String for API representation
    private String mensagem;
    private boolean lembrarRemetente;
    private LocalDateTime dataLembrete;
    private LocalDateTime dataEvento;
}