package cc.tianny.mybatis.mapper;

import java.util.List;

import cc.tianny.mybatis.model.User;
import cc.tianny.mybatis.param.UserParam;

public interface UserMapper {

	List<User> getAll();

	List<User> getList(UserParam userParam);

	int getCount(UserParam userParam);

	User getOne(Long id);

	void insert(User user);

	int update(User user);

	int delete(Long id);

}