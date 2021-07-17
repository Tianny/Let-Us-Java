package cc.tianny.multi.respository;

import cc.tianny.multi.model.User;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Tianny
 * Date: 2021/7/17
 * Time: 11:38 上午
 * Description: No Description
 */
public interface UserRepository  {
    int save(User user, JdbcTemplate jdbcTemplate);

    int update(User user,JdbcTemplate jdbcTemplate);

    int delete(long id,JdbcTemplate jdbcTemplate);

    List<User> findALL(JdbcTemplate jdbcTemplate);

    User findById(long id,JdbcTemplate jdbcTemplate);
}
