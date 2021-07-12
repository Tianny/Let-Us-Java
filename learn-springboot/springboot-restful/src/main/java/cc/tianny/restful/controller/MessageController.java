package cc.tianny.restful.controller;

import cc.tianny.restful.model.Message;
import cc.tianny.restful.repository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Tianny
 * Date: 2021/7/12
 * Time: 8:32 下午
 * Description: No Description
 */
@Controller
@RequestMapping("/")
public class MessageController {
    @Autowired
    private MessageRepository messageRepository;

    @GetMapping(value = "messages")
    public List<Message> list() {
        return this.messageRepository.findAll();
    }

    @PostMapping(value = "message")
    public Message create(Message message) {
        message = this.messageRepository.save(message);
        return message;
    }

    @PutMapping(value = "message")
    public Message modify(Message message) {
        return this.messageRepository.update(message);
    }

    @PatchMapping(value = "/message/text")
    public Message patch(Message message) {
        return this.messageRepository.updateText(message);
    }

    @GetMapping(value = "message/{id}")
    public Message get(@PathVariable Long id) {
        return this.messageRepository.findMessage(id);
    }

    @DeleteMapping(value = "message/{id}")
    public void delete(@PathVariable("id") Long id) {
        this.messageRepository.deleteMessage(id);
    }
}
