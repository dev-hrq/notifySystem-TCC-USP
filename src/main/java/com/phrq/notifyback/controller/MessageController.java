package com.phrq.notifyback.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.phrq.notifyback.dto.MessageDTO;
import com.phrq.notifyback.service.MessageService;
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
        description = "Creates a new message and returns the saved message with generated ID"
    )
    @PostMapping
    public ResponseEntity<MessageDTO> createMessage(@RequestBody MessageDTO messageDTO) {
        return ResponseEntity.ok(messageService.saveMessage(messageDTO));
    }

    @Operation(
        summary = "Get all messages",
        description = "Returns a list of all messages"
    )
    @GetMapping
    public ResponseEntity<List<MessageDTO>> getAllMessages() {
        return ResponseEntity.ok(messageService.getAllMessages());
    }
}