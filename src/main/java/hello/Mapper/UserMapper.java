package hello.Mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import hello.domain.User;

@Mapper
public interface UserMapper {

	@Select("select * from user where name = #{name}")
	User findUserById(@Param("name") String name);
	
	@Select("select * from user")
	List<User> queryall();

}
