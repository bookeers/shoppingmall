package com.shinhansec.shoppingmall.member;

import com.shinhansec.shoppingmall.utils.ApiUtils;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@Slf4j
@AllArgsConstructor
@RestController
public class MemberController {
    private final MemberService memberService;

    @PostMapping("/signup")
    public ApiUtils.ApiResult<String> signup(@Valid @RequestBody MemberDTO memberDto) {
        if (isDuplicateId(memberDto)) {
            return ApiUtils.error(null, "이미 존재하는 아이디입니다", HttpStatus.CONFLICT);
        }

        Member requestMember = memberDto.convertToEntity();
        String userId = memberService.join(requestMember);
        return ApiUtils.success(userId);
    }

    // todo 로그인 구현

    private boolean isDuplicateId(MemberDTO memberDto) {
        return memberService.checkDuplicateId(memberDto.getUserId());
    }
}
