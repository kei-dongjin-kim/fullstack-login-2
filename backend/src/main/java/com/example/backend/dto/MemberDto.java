package com.example.backend.dto;

//import java.util.Set;
//import java.util.stream.Collectors;

import com.example.backend.entity.MemberEntity;
import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MemberDto {


    @NotNull
    @Size(min = 3, max = 50)
    private String username;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @NotNull
    @Size(min = 3, max = 100)
    private String password;

    @NotNull
    @Size(min = 3, max = 50)
    private String email;

//    private Set<RoleDto> RoleDtoSet;

    public static MemberDto from(MemberEntity memberEntity) {
        if (memberEntity == null) return null;

        return MemberDto.builder()
                .email(memberEntity.getEmail())
                .username(memberEntity.getUsername())
//                .RoleDtoSet(memberEntity.getRoleName().stream()
//                        .map(role -> RoleDto.builder().roleName(role.getRoleName()).build())
//                        .collect(Collectors.toSet()))
                .build();
    }

}