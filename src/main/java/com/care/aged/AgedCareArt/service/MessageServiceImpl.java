package com.care.aged.AgedCareArt.service;

import com.care.aged.AgedCareArt.entity.Message;
import com.care.aged.AgedCareArt.entity.User;
import com.care.aged.AgedCareArt.jpa.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class MessageServiceImpl implements MessageService {

    @Autowired
    private MessageRepository repo;

    @Autowired
    private UserService userService;

    @Override
    public Message save(Message message) {
        if (message.getReceiver() != null) {
            User sender = userService.getByEmail(message.getSender().getEmail());
            message.setSender(sender);
        }
        if (message.getReceiver() != null) {
            User receiver = userService.getByEmail(message.getReceiver().getEmail());
            message.setReceiver(receiver);
        }
        if (message.getParentMessage() != null) {
            Message parent = message.getParentMessage();
            parent.setResponded(true);
            repo.save(parent);
        }
        message.setSendDate(new Date());
        return repo.save(message);
    }

    @Override
    public List<Message> findAll() {
        return repo.findAll();
    }

    @Override
    public Message findById(Long id) {
        return repo.findById(id).get();
    }

    @Override
    public void delete(Long id) {
        repo.deleteById(id);
    }

    @Override
    public List<Message> findForReceiver(Long id) {
        if (id == null) {
            String username = (String) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
            return repo.findByReceiverAccountUsername(username);
        } else
            return repo.findByReceiverId(id);

    }

    @Override
    public List<Message> loadSentMessages(Long id) {
        return repo.findBySenderId(id);
    }


}
