package com.example.backend.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MemberRoleEntity {

    private Long memberId;
    private Long roleId;

    @Override
    public String toString() {
        return "MemberRole{" +
                "member_id='" + memberId + '\'' +
                ", role_id='" + roleId + '\'' +
                '}';
    }
}
