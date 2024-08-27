package com.example.backend.service;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.backend.entity.MemberRoleEntity;
import com.example.backend.mapper.MemberRoleMapper;
import com.example.backend.dto.MemberDto;
import com.example.backend.entity.MemberEntity;
import com.example.backend.mapper.MemberMapper;


@Service
public class MemberService {

    private final MemberMapper memberMapper;
    private final MemberRoleMapper memberRoleMapper;
    private final PasswordEncoder passwordEncoder;

    public MemberService(
        MemberMapper memberMapper,
        MemberRoleMapper memberRoleMapper,
        PasswordEncoder passwordEncoder
    ) {
        this.memberMapper = memberMapper;
        this.memberRoleMapper = memberRoleMapper;
        this.passwordEncoder = passwordEncoder;
    }

    public MemberDto signUp(MemberDto memberDto) {
        try {
            MemberEntity memberEntity = MemberEntity.builder()
                    .email(memberDto.getEmail())
                    .password(passwordEncoder.encode(memberDto.getPassword()))
                    .username(memberDto.getUsername())
                    .build();

            memberMapper.insert(memberEntity);

            MemberEntity newMemberEntity = memberMapper.findByEmail(memberDto.getEmail());
            Long memberId = newMemberEntity.getId();

            MemberRoleEntity memberRoleEntity = MemberRoleEntity.builder()
                    .memberId(memberId)
                    .roleId(2L) // 2 is a basic role which is 'USER'
                    .build();

            memberRoleMapper.insert(memberRoleEntity);

            return MemberDto.from(newMemberEntity);
        } catch (Exception e) {
            throw new RuntimeException("An error occurred during signup.", e);
        }
    }

}
