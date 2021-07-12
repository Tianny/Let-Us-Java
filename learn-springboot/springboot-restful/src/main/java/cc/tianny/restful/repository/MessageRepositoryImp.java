package cc.tianny.restful.repository;

import cc.tianny.restful.model.Message;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

/**
 * Created with IntelliJ IDEA.
 * User: Tianny
 * Date: 2021/7/12
 * Time: 8:18 下午
 * Description: No Description
 */
@Service("messageRepository")
public class MessageRepositoryImp implements MessageRepository {
    private static AtomicLong counter = new AtomicLong();
    private final ConcurrentHashMap<Long, Message> messages = new ConcurrentHashMap<>();

    @Override
    public List<Message> findAll() {
        List<Message> messages = new ArrayList<Message>(this.messages.values());
        return messages;
    }

    @Override
    public Message save(Message message) {
        Long id = message.getId();
        if (id == null) {
            id = counter.incrementAndGet();
            message.setId(id);
        }
        this.messages.put(id, message);
        return message;
    }

    @Override
    public Message update(Message message) {
        this.messages.put(message.getId(), message);
        return message;
    }

    @Override
    public Message updateText(Message message) {
        Message msg = this.messages.get(message.getId());
        msg.setText(message.getText());
        this.messages.put(msg.getId(), msg);
        return msg;
    }

    @Override
    public Message findMessage(Long id) {
        return this.messages.get(id);
    }

    @Override
    public Message deleteMessage(Long id) {
        return this.messages.get(id);
    }
}
