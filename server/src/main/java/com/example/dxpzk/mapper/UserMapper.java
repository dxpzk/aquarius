package com.example.dxpzk.mapper;

import com.example.dxpzk.model.UserModel;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface UserMapper {
    UserModel query(@Param("id") int id);
}
