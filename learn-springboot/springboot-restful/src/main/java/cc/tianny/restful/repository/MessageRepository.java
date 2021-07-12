package cc.tianny.restful.repository;

import cc.tianny.restful.model.Message;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Tianny
 * Date: 2021/7/12
 * Time: 8:16 下午
 * Description: No Description
 */
public interface MessageRepository {
    List<Message> findAll();
    Message save(Message message);
    Message update(Message message);
    Message updateText(Message message);
    Message findMessage(Long id);
    Message deleteMessage(Long id);


}
