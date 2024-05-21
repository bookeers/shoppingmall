package com.shinhansec.shoppingmall.member;

import com.shinhansec.shoppingmall.utils.ApiUtils;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import static com.shinhansec.shoppingmall.utils.ApiUtils.error;
import static com.shinhansec.shoppingmall.utils.ApiUtils.success;

@Slf4j
@AllArgsConstructor
@RestController
public class MemberController {

    MemberService memberService;

    @PostMapping("/signup")
    public ApiUtils.ApiResult signup(@Valid @RequestBody MemberDto memberDto) {

        if(isDuplicateId(memberDto))
            return error("이미 존재하는 아이디입니다", HttpStatus.CONFLICT);

        Member requestMember = memberDto.convertToEntity();
        String userId = memberService.join(requestMember);
        return success(userId);
    }

    private boolean isDuplicateId(MemberDto memberDto) {

        return memberService.checkDuplicateId(memberDto.getUserId());
    }

}
