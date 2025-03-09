package com.phrq.notifyback.dto;

import lombok.Data;
import java.time.LocalDateTime;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.NotBlank;
import com.fasterxml.jackson.annotation.JsonFormat;

@Data
public class MessageCreateDTO {
    @NotBlank(message = "A mensagem não pode estar vazia")
    private String mensagem;
    
    @NotBlank(message = "O destinatário não pode estar vazio")
    private String destinatario;
    
    private boolean lembrarRemetente;
    
    @NotNull(message = "A data do lembrete não pode estar vazia")
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
    private LocalDateTime dataLembrete;
    
    @NotNull(message = "A data do evento não pode estar vazia")
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
    private LocalDateTime dataEvento;
} 