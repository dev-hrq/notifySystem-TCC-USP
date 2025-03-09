package com.phrq.notifyback.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.Parameter;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.phrq.notifyback.dto.MessageDTO;
import com.phrq.notifyback.dto.MessageCreateDTO;
import com.phrq.notifyback.service.MessageService;
import jakarta.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/messages")
@Tag(name = "Message", description = "Message management APIs")
public class MessageController {

    private final MessageService messageService;

    public MessageController(MessageService messageService) {
        this.messageService = messageService;
    }

    @Operation(
        summary = "Create a new message",
        description = "Creates a new message and returns the saved message with generated ID and sender information"
    )
    @PostMapping
    public ResponseEntity<MessageDTO> createMessage(@Valid @RequestBody MessageCreateDTO createDTO) {
        return ResponseEntity.ok(messageService.saveMessage(createDTO));
    }

    @Operation(
        summary = "Get all messages",
        description = "Returns a list of all messages"
    )
    @GetMapping
    public ResponseEntity<List<MessageDTO>> getAllMessages() {
        return ResponseEntity.ok(messageService.getAllMessages());
    }

    @Operation(
        summary = "Get messages by sender",
        description = "Returns all messages sent by a specific sender"
    )
    @GetMapping("/remetente/{remetente}")
    public ResponseEntity<List<MessageDTO>> getMessagesByRemetente(
            @Parameter(description = "Sender's identifier") 
            @PathVariable String remetente) {
        return ResponseEntity.ok(messageService.getMessagesByRemetente(remetente));
    }

    @Operation(
        summary = "Get messages by recipient",
        description = "Returns all messages sent to a specific recipient"
    )
    @GetMapping("/destinatario/{destinatario}")
    public ResponseEntity<List<MessageDTO>> getMessagesByDestinatario(
            @Parameter(description = "Recipient's identifier")
            @PathVariable String destinatario) {
        return ResponseEntity.ok(messageService.getMessagesByDestinatario(destinatario));
    }
}