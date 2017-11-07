package com.usping.kdsn.auth.mapper;

import com.usping.kdsn.auth.model.User;
import java.util.List;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.stereotype.Component;

/**
 * Created by stan on 17-7-2.
 */
@MapperScan
@Mapper
@Component
public interface UserMapper {

  @Select("select * from user")
  List<User>  findAll();

  @Select("select * from user where id=#{id}")
  User findById(Integer id);

  //@Insert(
  //    "insert into user(username,name,email,phone,industry,assortment,userrole,joblocation,school,workexperience,projectexperience,password) "
  //        + "VALUES(#{username},#{name},#{email},#{phone},#{industry),#{assortment},#{user_role},#{job_location},#{school},#{work_experience},#{project_experience},#{password})")
  //boolean saveUser(User user);
  //
  //@Update("update user "
  //    + "set "
  //    + "username=#{username},"
  //    + "name=#{name},"
  //    + "email=#{email},"
  //    + "phone=#{phone},"
  //    + "industry=#{industry},"
  //    + "assortment=#{assortment},"
  //    + "reward_points=#{userrole},"
  //    + "joblocation=#{joblocation},"
  //    + "school=#{school},"
  //    + "workexperience=#{workexperience},"
  //    + "projectexperience=#{projectexperience},"
  //    + "password=#{password} "
  //    + "where id=#{id}")
  //boolean updateUser(User user);

  @Delete("delete from user where id =#{id}")
  boolean deleteUser(Integer id);
}
