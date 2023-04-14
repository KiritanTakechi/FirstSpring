package com.ouka.mapper;

import com.ouka.model.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface UserMapper {
    @Results(id = "userResultMap", value = {
            @Result(property = "nickname", column = "f_nickname"),
            @Result(property = "username", column = "f_username"),
            @Result(property = "password", column = "f_password")})
    @ConstructorArgs({
            @Arg(column = "f_nickname", javaType = String.class),
            @Arg(column = "f_username", javaType = String.class),
            @Arg(column = "f_password", javaType = String.class)})
    @Select("select * from t_user")
    List<User> getUserAll();

    @ResultMap("userResultMap")
    @Select("select * from t_user where f_id = #{id}")
    User getUserById(Integer id);

    @ResultMap("userResultMap")
    @Select("select * from t_user where f_username = #{username}")
    User getUserByUsername(String username);

    @Insert("insert into t_user(f_nickname, f_username, f_password) values(#{nickname}, #{username}, #{password})")
    Integer insertUser(User user);

    @Delete("delete from t_user where f_id = #{id}")
    Integer deleteUserById(Integer id);

    @Delete("delete from t_user where f_username = #{username}")
    Integer deleteUserByUsername(String username);

    @Update("update t_user set f_nickname = #{nickname}, f_password = #{password} where f_username = #{username}")
    Integer updateUser(User user);
}