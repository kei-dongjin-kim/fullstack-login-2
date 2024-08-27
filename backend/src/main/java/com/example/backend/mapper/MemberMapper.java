package com.example.backend.mapper;

import com.example.backend.entity.MemberEntity;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MemberMapper {
    public MemberEntity find(Long id);
    public MemberEntity findByEmail(String email);
    public void insert(MemberEntity memberEntity);
    public void update(MemberEntity memberEntity);
    public void delete(Long id);
}
