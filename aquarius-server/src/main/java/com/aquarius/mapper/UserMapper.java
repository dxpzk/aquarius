package com.aquarius.mapper;

import com.aquarius.model.UserModel;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface UserMapper {
    UserModel query(@Param("id") int id);
}
