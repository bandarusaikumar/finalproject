package com.care.aged.AgedCareArt.controller.v1;


import com.care.aged.AgedCareArt.entity.Message;
import com.care.aged.AgedCareArt.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.*;

@RestController
@RequestMapping(value = "/api/messaging", produces = MediaType.APPLICATION_JSON_VALUE)
public class MessageController {

    @Autowired
    private MessageService service;

    @RequestMapping(method = GET, value = "{id}")
    public Message loadById(@PathVariable Long id) {
        return this.service.findById(id);
    }

    @RequestMapping(method = GET)
    public List<Message> loadAll() {
        return this.service.findAll();
    }

    @RequestMapping(method = GET, value = "/my/inbox")
    public List<Message> loadForReceiver(@PathVariable(required = false) Long id) {
        return this.service.findForReceiver(id);
    }

    @RequestMapping(method = POST, value = "send")
    public Message create(@RequestBody Message message) {
        return this.service.save(message);
    }

    @RequestMapping(method = PUT)
    public Message update(@RequestBody Message message) {
        return this.service.save(message);
    }

    @RequestMapping(method = DELETE, value = "{id}")
    public void delete(@PathVariable Long id) {
        this.service.delete(id);
    }

    @RequestMapping(method = GET, value = "sent/{id}")
    public List<Message> loadSentMessages(@PathVariable Long id) {
        return this.service.loadSentMessages(id);
    }

    @RequestMapping(method = GET, value = "received/{id}")
    public List<Message> loadReceivedMessages(@PathVariable(required = false) Long id) {
        return this.service.findForReceiver(id);
    }
}
