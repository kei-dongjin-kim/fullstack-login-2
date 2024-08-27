package com.example.backend.controller;

import com.example.backend.dto.MemberDto;
import com.example.backend.service.MemberService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api")
public class MemberController {

    private final MemberService memberService;

    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    @PostMapping("/signup")
    public ResponseEntity<MemberDto> signUp(
            @Valid @RequestBody MemberDto memberDto
    ) {
        return ResponseEntity.ok(memberService.signUp(memberDto));
    }

}