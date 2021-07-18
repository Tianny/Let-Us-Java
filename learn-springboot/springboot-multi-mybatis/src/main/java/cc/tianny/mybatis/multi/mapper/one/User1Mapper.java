package cc.tianny.mybatis.multi.mapper.one;


import cc.tianny.mybatis.multi.model.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

public interface User1Mapper {
	
	List<User> getAll();
	
	User getOne(Long id);

	void insert(User user);

	void update(User user);

	void delete(Long id);

}