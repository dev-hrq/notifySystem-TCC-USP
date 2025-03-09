package com.phrq.notifyback.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.phrq.notifyback.dto.MessageDTO;
import com.phrq.notifyback.mapper.MessageMapper;
import com.phrq.notifyback.model.Message;
import com.phrq.notifyback.repository.MessageRepository;

@Service
public class MessageService {

    private final MessageRepository repository;
    private final MessageMapper mapper;

    public MessageService(MessageRepository repository, MessageMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    public MessageDTO saveMessage(MessageDTO messageDTO) {
        Message message = mapper.toEntity(messageDTO);
        Message savedMessage = repository.save(message);
        return mapper.toDTO(savedMessage);
    }

    public List<MessageDTO> getAllMessages() {
        return repository.findAll().stream()
                .map(mapper::toDTO)
                .collect(Collectors.toList());
    }
}