package com.example.backend.mapper;

import com.example.backend.entity.MemberRoleEntity;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MemberRoleMapper {
    public void insert(MemberRoleEntity memberRoleEntity);
}
