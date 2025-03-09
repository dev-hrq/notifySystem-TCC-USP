package com.phrq.notifyback.mapper;

import org.springframework.stereotype.Component;
import org.springframework.beans.BeanUtils;
import com.phrq.notifyback.dto.MessageDTO;
import com.phrq.notifyback.dto.MessageCreateDTO;
import com.phrq.notifyback.model.Message;

@Component
public class MessageMapper {
    
    public Message toEntity(MessageCreateDTO dto) {
        Message message = new Message();
        BeanUtils.copyProperties(dto, message);
        return message;
    }

    public MessageDTO toDTO(Message entity) {
        MessageDTO dto = new MessageDTO();
        BeanUtils.copyProperties(entity, dto);
        return dto;
    }
}