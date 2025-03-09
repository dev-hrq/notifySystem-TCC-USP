package com.phrq.notifyback.dto;

import java.time.LocalDateTime;
import lombok.Data;

@Data
public class MessageDTO {
    private String id;
    private String mensagem;
    private String remetente;
    private String destinatario;
    private boolean lembrarRemetente;
    private LocalDateTime dataLembrete;
    private LocalDateTime dataEvento;
}