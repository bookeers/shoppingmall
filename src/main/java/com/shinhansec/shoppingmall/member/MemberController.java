package com.shinhansec.shoppingmall.member;

import com.shinhansec.shoppingmall.utils.ApiUtils;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@AllArgsConstructor
@RestController
public class MemberController {

    private final MemberService memberService;

    @PostMapping("/signup")
    public ApiUtils.ApiResult<String> signup(@Valid @RequestBody MemberDTO memberDto) {
        if (isDuplicateId(memberDto)) {
            return ApiUtils.error(null,"이미 존재하는 아이디입니다", HttpStatus.CONFLICT);
        }

        Member requestMember = memberDto.convertToEntity();
        String userId = memberService.Signup(requestMember);
        return ApiUtils.success(userId);
    }

    @PostMapping("/login")
    public ResponseEntity<ApiUtils.ApiResult<String>> login(@RequestBody MemberDTO memberDto) {
        try {
            memberService.login(memberDto.getUserId(), memberDto.getPw());
            return ResponseEntity.ok(ApiUtils.success("로그인 성공"));
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(ApiUtils.error(null,e.getMessage(), HttpStatus.UNAUTHORIZED));
        }
    }

    private boolean isDuplicateId(MemberDTO memberDto) {
        return memberService.checkDuplicateId(memberDto.getUserId());
    }
}