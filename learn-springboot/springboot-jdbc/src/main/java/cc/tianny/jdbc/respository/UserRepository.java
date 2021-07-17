package cc.tianny.jdbc.respository;

import cc.tianny.jdbc.model.User;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Tianny
 * Date: 2021/7/17
 * Time: 11:38 上午
 * Description: No Description
 */
public interface UserRepository  {

    int save(User user);

    int update(User user);

    int delete(long id);

    List<User> findALL();

    User findById(long id);
}
