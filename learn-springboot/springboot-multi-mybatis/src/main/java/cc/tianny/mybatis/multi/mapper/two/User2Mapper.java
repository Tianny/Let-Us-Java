package cc.tianny.mybatis.multi.mapper.two;

import cc.tianny.mybatis.multi.model.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

public interface User2Mapper {
	
	List<User> getAll();
	
	User getOne(Long id);

	void insert(User user);

	void update(User user);

	void delete(Long id);

}